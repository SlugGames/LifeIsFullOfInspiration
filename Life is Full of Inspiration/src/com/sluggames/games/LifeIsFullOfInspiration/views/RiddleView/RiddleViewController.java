/*
 * MIT License
 *
 * Copyright (c) 2018 Slug Games
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.sluggames.games.LifeIsFullOfInspiration.views.RiddleView;

import com.sluggames.games.LifeIsFullOfInspiration.riddles.Riddle;
import com.sluggames.games.LifeIsFullOfInspiration.views.SelectionView.SelectionViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.SettingsView.SettingsViewController;
import java.time.Duration;
import java.time.Instant;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author david.boeger@sluggames.com
 */
public class RiddleViewController {
	/*
		************************
		*** RIDDLE TEXT FLOW ***
		************************
	*/
	@FXML
	private TextFlow riddleTextFlow;
	@FXML
	private Text riddleText;
	@FXML
	private ScrollPane riddleTextFlowScrollPane;

	/*
		*****************************
		*** SOLVE HERE TEXT FIELD ***
		*****************************
	*/
	@FXML
	private TextField solveHereTextField;

	private void initializeSolveHereTextField() {
		solveHereTextField.setOnAction((
		    ActionEvent actionEvent
		) -> {
			if (
			    riddle.testSolution(
			    solveHereTextField.getText().toLowerCase()
			)) {
				SettingsViewController.correct.play();
				SettingsViewController.greatGuess.play();
				riddle.setSolved(true);
				remainingNotificationDuration =
				    PASS_NOTIFICATION_DURATION;
			} else {
				SettingsViewController.incorrect.play();
				SettingsViewController.notQuite.play();
				riddle.setSolved(false);
				remainingNotificationDuration =
				    FAIL_NOTIFICATION_DURATION;
			}
		});
	}

	/*
		*************************
		*** RIDDLE IMAGE VIEW ***
		*************************
	*/
	@FXML
	private ImageView riddleImageView;
	@FXML
	private StackPane rootStackPane;
	@FXML
	private Pane fillPane;

	private void initializeRiddleImageView() {
		riddleImageView.fitWidthProperty().bind(
		    rootStackPane.widthProperty()
		);
		riddleImageView.fitHeightProperty().bind(
		    rootStackPane.heightProperty()
		);
	}

	/*
		*******************
		*** BACK BUTTON ***
		*******************
	*/
	@FXML
	private Button backButton;
	private SelectionViewManager selectionViewManager;

	private void initializeBackButton() {
		/*
		Set the button press handler.
		*/
		backButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the selection view manager is set, show it.
			*/
			SettingsViewController.buttonPress.play();
			if (selectionViewManager != null) {
				selectionViewManager.show();
			}
		});
	}

	public void setSelectionViewManager(
	    SelectionViewManager selectionViewManager
	) {
		this.selectionViewManager = selectionViewManager;
	}

	/*
		********************
		*** NOTIFICATION ***
		********************
	*/
	public static final Duration FAIL_NOTIFICATION_DURATION =
	    Duration.ofSeconds(1);
	public static final Duration PASS_NOTIFICATION_DURATION =
	    FAIL_NOTIFICATION_DURATION.multipliedBy(2);
	public static final Duration IMAGE_TRANSITION_DURATION =
	    Duration.ofSeconds(2);

	private Duration remainingNotificationDuration = Duration.ZERO;
	private Duration remainingImageTransitionDuration =
	    IMAGE_TRANSITION_DURATION;

	/*
		******************
		*** INITIALIZE ***
		******************
	*/
	@FXML
	public void initialize() {
		/*
		Initialize components.
		*/
		initializeSolveHereTextField();
		initializeRiddleImageView();
		initializeBackButton();

		/*
		Set the default riddle context.
		*/
		setRiddle(riddle);

		/*
		Set an animation timer to manage notifications.
		*/
		new AnimationTimer() {
			private Instant previousTime = Instant.now();

			@Override
			public void handle(
			    long ignoredTime
			) {
				Instant currentTime = Instant.now();
				Duration elapsedTime = Duration.between(
				    previousTime,
				    currentTime
				);
				previousTime = currentTime;

				if (riddle == null) {
					remainingNotificationDuration =
					    Duration.ZERO;
					remainingImageTransitionDuration =
					    IMAGE_TRANSITION_DURATION;
					fillPane.setOpacity(0);
					riddleImageView.setOpacity(0);

					return;
				}

				if (
				    riddle.isSolved() &&
				    remainingNotificationDuration.equals(Duration.ZERO)
				) {
					if (remainingImageTransitionDuration.compareTo(elapsedTime) > 0) {
						remainingImageTransitionDuration =
						    remainingImageTransitionDuration.minus(
						    elapsedTime
						);
					} else {
						remainingImageTransitionDuration =
						    Duration.ZERO;
					}

					double transitionProgress = 1.0 - (
					    (double) remainingImageTransitionDuration.toMillis() /
					    IMAGE_TRANSITION_DURATION.toMillis()
					);

					fillPane.setOpacity(transitionProgress);
					riddleImageView.setOpacity(transitionProgress);

					return;
				}

				if (remainingNotificationDuration.compareTo(elapsedTime) > 0) {
					remainingNotificationDuration =
					    remainingNotificationDuration.minus(
					    elapsedTime
					);

					Color notificationColor;
					Duration notificationDuration;

					if (riddle.isSolved()) {
						notificationColor = Color.GREEN;
						notificationDuration =
						    PASS_NOTIFICATION_DURATION;
					} else {
						notificationColor = Color.RED;
						notificationDuration =
						    FAIL_NOTIFICATION_DURATION;
					}

					double transitionProgress =
					    (double) remainingNotificationDuration.toMillis() /
					    notificationDuration.toMillis();

					riddleTextFlowScrollPane.setBackground(
					    new Background(new BackgroundFill(
					    Color.TRANSPARENT.interpolate(notificationColor, transitionProgress),
					    CornerRadii.EMPTY,
					    Insets.EMPTY
					)));
				} else {
					remainingNotificationDuration = Duration.ZERO;
					riddleTextFlowScrollPane.setBackground(Background.EMPTY);
				}
			}
		}.start();
	}

	/*
		******************
		*** SET RIDDLE ***
		******************
	*/
	private Riddle riddle;

	public void setRiddle(
	    Riddle riddle
	) {
		/*
		Disable all context controls.
		*/
		solveHereTextField.setDisable(true);

		/*
		Clear anything related to the previous riddle.
		*/
		solveHereTextField.clear();
		riddleImageView.setImage(null);
		riddleText.setText("");

		/*
		Check if there is a new riddle being set.
		*/
		if (riddle != null) {
			fillPane.setOpacity(0);
			riddleImageView.setOpacity(0);
			remainingImageTransitionDuration =
			    IMAGE_TRANSITION_DURATION;

			/*
			If so, populate the view with the corresponding data.
			*/
			riddleText.setText(riddle.getText());

			riddleImageView.setImage(
			    riddle.getImage()
			);
			riddleImageView.setVisible(true);

			/*
			Enable all context controls.
			*/
			solveHereTextField.setDisable(false);
		}

		this.riddle = riddle;
	}
}