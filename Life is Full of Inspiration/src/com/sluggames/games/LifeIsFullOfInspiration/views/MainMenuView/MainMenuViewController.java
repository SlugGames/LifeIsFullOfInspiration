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
package com.sluggames.games.LifeIsFullOfInspiration.views.MainMenuView;

import com.sluggames.games.LifeIsFullOfInspiration.views.CreditsView.CreditsViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.LicenseView.LicenseViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.LifeIsFullOfInspiration;
import com.sluggames.games.LifeIsFullOfInspiration.views.SelectionView.SelectionViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.SettingsView.SettingsViewManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author david.boeger@sluggames.com
 */
public class MainMenuViewController {
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
		******************
		*** TITLE TEXT ***
		******************
	*/
	@FXML
	private Text titleText;

	private void initializeTitleText () {
		/*
		Set the title text.
		*/
		titleText.setText(
		    LifeIsFullOfInspiration.TITLE
		);
	}

	/*
		*******************
		*** PLAY BUTTON ***
		*******************
	*/
	@FXML
	private Button playButton;
	private SelectionViewManager selectionViewManager;

	private void initializePlayButton() {
		/*
		Set the button press handler.
		*/
		playButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the riddle view manager is set, show it.
			*/
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
		***********************
		*** SETTINGS BUTTON ***
		***********************
	*/
	@FXML
	private Button settingsButton;
	private SettingsViewManager settingsViewManager;

	private void initializeSettingsButton() {
		/*
		Set the button press handler.
		*/
		settingsButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the settings view manager is set, show it.
			*/
			if (settingsViewManager != null) {
				settingsViewManager.show();
			}
		});
	}

	public void setSettingsViewManager(
	    SettingsViewManager settingsViewManager
	) {
		this.settingsViewManager = settingsViewManager;
	}

	/*
		**********************
		*** CREDITS BUTTON ***
		**********************
	*/
	@FXML
	private Button creditsButton;
	private CreditsViewManager creditsViewManager;

	private void initializeCreditsButton() {
		/*
		Set the button press handler.
		*/
		creditsButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the credits view manager is set, show it.
			*/
			if (creditsViewManager != null) {
				creditsViewManager.show();
			}
		});
	}

	public void setCreditsViewManager(
	    CreditsViewManager creditsViewManager
	) {
		this.creditsViewManager = creditsViewManager;
	}

	/*
		**********************
		*** LICENSE BUTTON ***
		**********************
	*/
	@FXML
	private Button licenseButton;
	private LicenseViewManager licenseViewManager;

	private void initializeLicenseButton() {
		/*
		Set the button press handler.
		*/
		licenseButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			/*
			If the license view manager is set, show it.
			*/
			if (licenseViewManager != null) {
				licenseViewManager.show();
			}
		});
	}

	public void setLicenseViewManager(
	    LicenseViewManager licenseViewManager
	) {
		this.licenseViewManager = licenseViewManager;
	}

	/*
		*******************
		*** QUIT BUTTON ***
		*******************
	*/
	@FXML
	private Button quitButton;

	private void initializeQuitButton() {
		quitButton.setOnAction((
		    ActionEvent actionEvent
		) -> {
			Platform.exit();
		});
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
		initializeTitleText();
		initializePlayButton();
		initializeSettingsButton();
		initializeCreditsButton();
		initializeLicenseButton();
		initializeQuitButton();
	}
}