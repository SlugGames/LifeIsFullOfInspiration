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
package com.sluggames.games.LifeIsFullOfInspiration.views.CreditsView;

import com.sluggames.games.LifeIsFullOfInspiration.LifeIsFullOfInspiration;
import com.sluggames.games.LifeIsFullOfInspiration.views.MainMenuView.MainMenuViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author david.boeger@sluggames.com
 */
public class CreditsViewController {
	/*
		*************************
		*** CREDITS TEXT FLOW ***
		*************************
	*/
	public static final String CREDITS =
	    LifeIsFullOfInspiration.TITLE +
	    "" +
	    "\nDeveloped by Slug Games." +
	    "\n\n\n" +
	    "Programming:\n" +
	    "\nDavid Boeger" +
	    "\n\n\n" +
	    "Photography:\n" +
	    "\nDavid Boeger" +
	    "\nFan Xuexue" +
	    "\n\n\n" +
	    "Music:\n" +
	    "\n\"Acoustic Breeze\"" +
	    "\nTheme by Bensound." +
	    "\nhttps://www.bensound.com/" +
	    "\n\n\n" +
	    "Slug Games would like to give special thanks to Tim Ruswick and " +
	    "the community at Game Dev Underground (http://gdu.io) for " +
	    "hosting the Jim Jam and encouraging the creation of fun games!" +
	    "\n\n\n" +
	    "David Boeger dedicates this game to his wife, Fan Xuexue, for " +
	    "being his inspiration.";

	@FXML
	private TextFlow creditsTextFlow;
	@FXML
	private Label creditsTextFlowLabel;

	private void initializeCreditsTextFlow() {
		/*
		Associate with the label.
		*/
		creditsTextFlowLabel.setLabelFor(
		    creditsTextFlow
		);

		/*
		Add the credits text.
		*/
		creditsTextFlow.getChildren().add(
		    new Text(CREDITS)
		);
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
		******************
		*** INITIALIZE ***
		******************
	*/
	@FXML
	public void initialize() {
		/*
		Initialize components.
		*/
		initializeCreditsTextFlow();
		initializeMainMenuButton();
	}
}