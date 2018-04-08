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
package com.sluggames.games.LifeIsFullOfInspiration;

import com.sluggames.games.LifeIsFullOfInspiration.views.RiddleView.RiddleViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.SettingsView.SettingsViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.MainMenuView.MainMenuViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.LicenseView.LicenseViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.CreditsView.CreditsViewManager;
import com.sluggames.games.LifeIsFullOfInspiration.views.SelectionView.SelectionViewManager;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * @author david.boeger@sluggames.com
 */
public class LifeIsFullOfInspiration extends Application {
	/*
		*************
		*** TITLE ***
		*************
	*/
	public static final String TITLE =
	    "Life is Full of Inspiration";

	/*
		******************************
		*** MAIN MENU VIEW MANAGER ***
		******************************
	*/
	private final MainMenuViewManager mainMenuViewManager =
	    new MainMenuViewManager();

	private void initializeMainMenuViewManager(
	    Stage gameStage
	) {
		mainMenuViewManager.setGameScene(
		    gameStage.getScene()
		);
		mainMenuViewManager.getController().setGameStage(
		    gameStage
		);
		mainMenuViewManager.getController().setSelectionViewManager(
		    selectionViewManager
		);
		mainMenuViewManager.getController().setSettingsViewManager(
		    settingsViewManager
		);
		mainMenuViewManager.getController().setCreditsViewManager(
		    creditsViewManager
		);
		mainMenuViewManager.getController().setLicenseViewManager(
		    licenseViewManager
		);
	}

	/*
		******************************
		*** SELECTION VIEW MANAGER ***
		******************************
	*/
	private final SelectionViewManager selectionViewManager =
	    new SelectionViewManager();

	private void initializeSelectionViewManager(
	    Scene gameScene
	) {
		selectionViewManager.setGameScene(
		    gameScene
		);
		selectionViewManager.getController().setMainMenuViewManager(
		    mainMenuViewManager
		);
		selectionViewManager.getController().setRiddleViewManager(
		    riddleViewManager
		);
	}

	/*
		***************************
		*** RIDDLE VIEW MANAGER ***
		***************************
	*/
	private final RiddleViewManager riddleViewManager =
	    new RiddleViewManager();

	private void initializeRiddleViewManager(
	    Scene gameScene
	) {
		riddleViewManager.setGameScene(
		    gameScene
		);
		riddleViewManager.getController().setSelectionViewManager(
		    selectionViewManager
		);
	}

	/*
		*****************************
		*** SETTINGS VIEW MANAGER ***
		*****************************
	*/
	private final SettingsViewManager settingsViewManager =
	    new SettingsViewManager();

	private void initializeSettingsViewManager(
	    Stage gameStage
	) {
		settingsViewManager.setGameScene(
		    gameStage.getScene()
		);
		settingsViewManager.getController().setGameStage(
		    gameStage
		);
		settingsViewManager.getController().setMainMenuViewManager(
		    mainMenuViewManager
		);
	}

	/*
		****************************
		*** CREDITS VIEW MANAGER ***
		****************************
	*/
	private final CreditsViewManager creditsViewManager =
	    new CreditsViewManager();

	private void initializeCreditsViewManager(
	    Scene gameScene
	) {
		creditsViewManager.setGameScene(
		    gameScene
		);
		creditsViewManager.getController().setMainMenuViewManager(
		    mainMenuViewManager
		);
	}

	/*
		****************************
		*** LICENSE VIEW MANAGER ***
		****************************
	*/
	private final LicenseViewManager licenseViewManager =
	    new LicenseViewManager();

	private void initializeLicenseViewManager(
	    Scene gameScene
	) {
		licenseViewManager.setGameScene(
		    gameScene
		);
		licenseViewManager.getController().setMainMenuViewManager(
		    mainMenuViewManager
		);
	}

	/*
		**************
		*** LAUNCH ***
		**************
	*/
	/*
			--------
			| MAIN |
			--------
	*/
	public static void main(String[] args) {
		launch(args);
	}

	/*
			---------
			| START |
			---------
	*/
	@Override
	public void start(
	    Stage gameStage
	) {
		/*
		Create the game scene with a placeholder root.
		*/
		gameStage.setScene(new Scene(
		    new Group()
		));

		/*
		Initialize all components.
		*/
		initializeMainMenuViewManager(gameStage);
		initializeSelectionViewManager(gameStage.getScene());
		initializeRiddleViewManager(gameStage.getScene());
		initializeSettingsViewManager(gameStage);
		initializeCreditsViewManager(gameStage.getScene());
		initializeLicenseViewManager(gameStage.getScene());

		/*
		Prepare the game stage.
		*/
		gameStage.setTitle(TITLE);
		gameStage.setX(
		    Screen.getPrimary().getBounds().getMinX() + 50
		);
		gameStage.setY(
		    Screen.getPrimary().getBounds().getMinY() + 50
		);
		gameStage.setWidth(Screen.getPrimary().getBounds().getWidth() * 0.8);
		gameStage.setHeight(Screen.getPrimary().getBounds().getHeight() * 0.8);
		gameStage.show();

		/*
		Show the main menu by default.
		*/
		mainMenuViewManager.show();
	}
}