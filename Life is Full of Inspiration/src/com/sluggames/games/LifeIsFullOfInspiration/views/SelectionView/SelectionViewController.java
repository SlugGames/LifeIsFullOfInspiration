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
package com.sluggames.games.LifeIsFullOfInspiration.views.SelectionView;

import com.sluggames.games.LifeIsFullOfInspiration.riddles.Riddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.aliens.AliensRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.bays.BaysRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.family.FamilyRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.flowers.FlowersRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.food.FoodRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.hardship.HardshipRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.history.HistoryRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.lakes.LakesRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.life.LifeRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.mountains.MountainsRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.rainbows.RainbowsRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.romance.RomanceRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.sky.SkyRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.tradition.TraditionRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.trees.TreesRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.riddles.valleys.ValleysRiddle;
import com.sluggames.games.LifeIsFullOfInspiration.views.MainMenuView.MainMenuViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.RiddleView.RiddleViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;

/**
 * @author david.boeger@sluggames.com
 */
public class SelectionViewController {
	/*
		**********************
		*** RIDDLE BUTTONS ***
		**********************
	*/
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	@FXML
	private Button button7;
	@FXML
	private Button button8;
	@FXML
	private Button button9;
	@FXML
	private Button button10;
	@FXML
	private Button button11;
	@FXML
	private Button button12;
	@FXML
	private Button button13;
	@FXML
	private Button button14;
	@FXML
	private Button button15;
	@FXML
	private Button button16;

	private RiddleViewManager riddleViewManager;

	public static final Riddle[] RIDDLES = new Riddle[] {
	    new AliensRiddle(), new BaysRiddle(), new FamilyRiddle(), new FlowersRiddle(),
	    new FoodRiddle(), new HardshipRiddle(), new HistoryRiddle(), new LakesRiddle(),
	    new LifeRiddle(), new MountainsRiddle(), new RainbowsRiddle(), new RomanceRiddle(),
	    new SkyRiddle(), new TraditionRiddle(), new TreesRiddle(), new ValleysRiddle()
	};

	private Button[] riddleButtons;

	private void initializeRiddleButtons() {
		riddleButtons = new Button[] {
		    button1, button2, button3, button4,
		    button5, button6, button7, button8,
		    button9, button10, button11, button12,
		    button13, button14, button15, button16
		};

		for (int index = 0; index < 16; index++) {
			Riddle riddle = RIDDLES[index];

			riddleButtons[index].setOnAction((
			    ActionEvent actionEvent
			) -> {
				if (riddleViewManager != null) {
					riddleViewManager.getController().setRiddle(
					    riddle
					);
					riddleViewManager.show();
				}
			});
		}
	}

	public void setRiddleViewManager(
	    RiddleViewManager riddleViewManager
	) {
		this.riddleViewManager = riddleViewManager;
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
		Set the button press handler.
		*/
		mainMenuButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the main menu view manager is set, show it.
			*/
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
		*****************************
		*** RESET PROGRESS BUTTON ***
		*****************************
	*/
	@FXML
	private Button resetProgressButton;

	private void initializeResetProgressButton() {
		Riddle[] riddles = RIDDLES;
		resetProgressButton.setDisable(true);
		resetProgressButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			for (int index = 0; index < 16; index++) {
				riddles[index].setSolved(false);
				riddleButtons[index].setTextFill(
				    Color.BLACK
				);
			}
		});
	}

	public void updateProgress() {
		Riddle[] riddles = RIDDLES;
		resetProgressButton.setDisable(true);
		for (int index = 0; index < 16; index++) {
			if (riddles[index].isSolved()) {
				riddleButtons[index].setTextFill(
				    Color.GREEN
				);
				resetProgressButton.setDisable(false);
			} else {
				riddleButtons[index].setTextFill(
				    Color.BLACK
				);
			}
		}
	}

	/*
		******************
		*** INITIALIZE ***
		******************
	*/
	@FXML
	private void initialize() {
		/*
		Initialize components.
		*/
		initializeRiddleButtons();
		initializeMainMenuButton();
		initializeResetProgressButton();
	}
}