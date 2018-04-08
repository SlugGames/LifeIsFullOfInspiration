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
package com.sluggames.games.LifeIsFullOfInspiration.riddles.hardship;

import com.sluggames.games.LifeIsFullOfInspiration.riddles.Riddle;
import java.util.Arrays;
import java.util.HashSet;
import javafx.scene.image.Image;

/**
 * @author david.boeger@sluggames.com
 */
public class HardshipRiddle implements Riddle {
	/*
		*****************
		*** SOLUTIONS ***
		*****************
	*/
	public static final HashSet<String> SOLUTIONS = new HashSet<> (
	    Arrays.asList(
	    "adversity",
	    "austerity",
	    "challenge",
	    "challenges",
	    "difficulty",
	    "difficulties",
	    "distress",
	    "drudgery",
	    "hardship",
	    "hardships",
	    "rigor",
	    "rigors",
	    "suffering",
	    "travail",
	    "test",
	    "tests",
	    "trial",
	    "trials",
	    "tribulation",
	    "tribulations",
	    "trouble",
	    "troubles"
	));

	@Override
	public boolean testSolution(
	    String solution
	) {
		return SOLUTIONS.contains(solution);
	}

	boolean solved;
	@Override
	public boolean isSolved() {
		return solved;
	}
	@Override
	public void setSolved(boolean solved) {
		this.solved = solved;
	}

	/*
		************
		*** TEXT ***
		************
	*/
	public static final String[] LINES = {
	    "Nothing worth fighting for is easy.",
	    "The best things in life aren't free.",
	    "Life is a journey, not a destination.",
	    "To embrace this is to simply be.",
	    "When times are tough, when money is tight,",
	    "When quick doth approach your next deadline,",
	    "Remember those who have it worse,",
	    "And realize this is not a curse."
	};

	@Override
	public String[] getLines() {
		return LINES;
	}

	/*
		*************
		*** IMAGE ***
		*************
	*/
	public static final Image IMAGE = new Image(
	    HardshipRiddle.class.getResource(
	    "hardship.jpg"
	    ).toString()
	);

	@Override
	public Image getImage() {
		return IMAGE;
	}
}