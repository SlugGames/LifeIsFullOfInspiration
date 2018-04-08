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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;

/**
 * @author david.boeger@sluggames.com
 */
public class CreditsViewManager {
	/*
		******************
		*** GAME SCENE ***
		******************
	*/
	private Scene gameScene;

	public void setGameScene(
	    Scene gameScene
	) {
		this.gameScene = gameScene;
	}

	/*
		************
		*** ROOT ***
		************
	*/
	private final ScrollPane root = new ScrollPane();

	public void show() {
		/*
		If the game scene is set, set the root.
		*/
		if (gameScene != null) {
			gameScene.setRoot(root);
		}
	}

	/*
		******************
		*** CONTROLLER ***
		******************
	*/
	private final CreditsViewController controller =
	    new CreditsViewController();

	private void initializeController() {
		/*
		Load the credits view.
		*/
		FXMLLoader creditsViewLoader = new FXMLLoader(
		    getClass().getResource(
		    "CreditsView.fxml"
		));
		creditsViewLoader.setRoot(root);
		creditsViewLoader.setController(controller);

		try {
			creditsViewLoader.load();
		} catch (IOException exception) {
			Logger.getLogger(
			    CreditsViewManager.class.getName()).log(
			    Level.SEVERE,
			    null,
			    exception
			);

			Platform.exit();
		}
	}

	public CreditsViewController getController() {
		return controller;
	}

	/*
		********************
		*** CONSTRUCTION ***
		********************
	*/
	public CreditsViewManager() {
		/*
		Initialize components.
		*/
		initializeController();
	}
}