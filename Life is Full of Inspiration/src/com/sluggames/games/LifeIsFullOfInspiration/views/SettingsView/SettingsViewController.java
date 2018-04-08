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
package com.sluggames.games.LifeIsFullOfInspiration.views.SettingsView;

import com.sluggames.games.LifeIsFullOfInspiration.views.MainMenuView.MainMenuViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.utility.DoubleToPercentageLabelConverter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCombination;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 * @author david.boeger@sluggames.com
 */
public class SettingsViewController {
	/*
		******************
		*** GAME STAGE ***
		******************
	*/
	private Stage gameStage;

	public void setGameStage(
	    Stage gameStage
	) {
		this.gameStage = gameStage;
	}

	/*
		*****************************
		*** FULL SCREEN CHECK BOX ***
		*****************************
	*/
	@FXML
	private CheckBox fullScreenCheckBox;
	

	private void initializeFullScreenCheckBox() {
		/*
		Add a change listener to the selected property.
		*/
		fullScreenCheckBox.selectedProperty().addListener((
		    ObservableValue<? extends Boolean> selectedObservableValue,
		    Boolean selectedOldValue,
		    Boolean selectedNewValue
		) -> {
			/*
			Verify that there is a new selection.
			*/
			if (selectedNewValue == null) {
				throw new NullPointerException(
				    "selectedNewValue == null"
				);
			}

			/*
			Simply return if there is no game stage set.
			*/
			if (gameStage == null) {
				return;
			}

			/*
			Set the game stage's full screen properties accordingly.
			*/
			buttonPress.play();
			if (selectedNewValue) {
				gameStage.setFullScreenExitHint("");
				gameStage.setFullScreenExitKeyCombination(
				    KeyCombination.NO_MATCH
				);
				gameStage.setFullScreen(true);
			} else {
				gameStage.setFullScreen(false);
			}
		});
	}

	/*
		***************************
		*** MUSIC VOLUME SLIDER ***
		***************************
	*/
	@FXML
	private Slider musicVolumeSlider;
	@FXML
	private Label musicVolumeSliderLabel;
	private final MediaPlayer backgroundMusicPlayer = new MediaPlayer(
	    new Media(
	    getClass().getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/AcousticBreeze/Acoustic Breeze.mp3"
	    ).toString()
	));

	private void initializeMusicVolumeSlider() {
		/*
		Prepare labelling.
		*/
		musicVolumeSliderLabel.setLabelFor(
		    musicVolumeSlider
		);
		musicVolumeSlider.setLabelFormatter(
		    new DoubleToPercentageLabelConverter()
		);

		/*
		Bind the background music player's volume to the slider's value
		property.
		*/
		backgroundMusicPlayer.volumeProperty().bind(
		    musicVolumeSlider.valueProperty()
		);

		/*
		Set the background music to loop indefinitely.
		*/
		backgroundMusicPlayer.setCycleCount(
		    MediaPlayer.INDEFINITE
		);
		backgroundMusicPlayer.play();
	}

	/*
		***********************************
		*** SOUND EFFECTS VOLUME SLIDER ***
		***********************************
	*/
	@FXML
	private Slider soundEffectsVolumeSlider;
	@FXML
	private Label soundEffectsVolumeSliderLabel;
	public static AudioClip buttonPress = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Button Press.m4a"
	    ).toString()
	);
	public static AudioClip correct = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Correct.m4a"
	    ).toString()
	);
	public static AudioClip greatGuess = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Great Guess.m4a"
	    ).toString()
	);
	public static AudioClip incorrect = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Incorrect.m4a"
	    ).toString()
	);
	public static AudioClip notQuite = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Not Quite.m4a"
	    ).toString()
	);
	public static AudioClip thanksForPlaying = new AudioClip(
	    SettingsViewController.class.getResource(
	    "/com/sluggames/games/LifeIsFullOfInspiration/audio/Thanks for Playing.m4a"
	    ).toString()
	);

	private void initializeSoundEffectsVolumeSlider() {
		/*
		Prepare labelling.
		*/
		soundEffectsVolumeSliderLabel.setLabelFor(
		    soundEffectsVolumeSlider
		);
		soundEffectsVolumeSlider.setLabelFormatter(
		    new DoubleToPercentageLabelConverter()
		);

		/*
		Bind the audio clip volumes to the sound effects volume slider's
		value property.
		*/
		buttonPress.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
		correct.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
		greatGuess.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
		incorrect.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
		notQuite.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
		thanksForPlaying.volumeProperty().bind(
		    soundEffectsVolumeSlider.valueProperty()
		);
	}

	public DoubleProperty getSoundEffectsVolumeProperty() {
		return soundEffectsVolumeSlider.valueProperty();
	}
	

	/*
		************************
		*** MAIN MENU BUTTON ***
		************************
	*/
	@FXML
	private Button mainMenuButton;
	private MainMenuViewManager mainMenuViewManager;

	private void initializeMainMenuButton() {
		/*
		Set button press handler.
		*/
		mainMenuButton.setOnAction((
		    ActionEvent acionEvent
		) -> {
			/*
			If the main menu view manager is set, show it.
			*/
			buttonPress.play();
			if (mainMenuViewManager != null) {
				mainMenuViewManager.show();
			}
		});
	}

	public void setMainMenuViewManager(
	    MainMenuViewManager mainMenuViewManager
	) {
		this.mainMenuViewManager = mainMenuViewManager;
	}

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
		initializeFullScreenCheckBox();
		initializeMusicVolumeSlider();
		initializeSoundEffectsVolumeSlider();
		initializeMainMenuButton();
	}
}