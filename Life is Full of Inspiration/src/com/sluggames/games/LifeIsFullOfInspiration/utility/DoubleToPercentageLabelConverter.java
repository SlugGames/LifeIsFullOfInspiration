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
package com.sluggames.games.LifeIsFullOfInspiration.utility;

import javafx.util.StringConverter;

/**
 * @author david.boeger@sluggames.com
 */
public class DoubleToPercentageLabelConverter
    extends
    StringConverter<Double>
{
	/*
		**************
		*** SUFFIX ***
		**************
	*/
	public static final String SUFFIX = "%";


	/*
		*****************
		*** TO STRING ***
		*****************
	*/
	@Override
	public String toString(
	    Double value
	) {
		/*
		Validate arguments.
		*/
		if (value == null) {
			throw new NullPointerException(
			    "value == null"
			);
		}

		/*
		Convert the value to a percentage.
		*/
		return
		    (int)(value * 100) +
		    SUFFIX;
	}


	/*
		*******************
		*** FROM STRING ***
		*******************
	*/
	@Override
	public Double fromString(
	    String percentageLabel
	) {
		/*
		Validate arguments.
		*/
		if (percentageLabel == null) {
			throw new NullPointerException(
			    "percentageLabel == null"
			);
		}

		/*
		Reconstruct the value from the percentage.
		*/
		return
		    Double.parseDouble(
		    percentageLabel.replace(SUFFIX, "")) /
		    100;
	}
}