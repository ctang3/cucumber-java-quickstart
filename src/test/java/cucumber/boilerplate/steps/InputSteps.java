/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package cucumber.boilerplate.steps;

import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import cucumber.api.java.en.When;
import cucumber.boilerplate.steps.pages.BasePage;

/**
 * @author Cheryl Tang
 */
public class InputSteps extends BasePage {

	/**
	 * Clears then enters text into the search bar.
	 *
	 * @param input string to enter into the search bar
	 */
	@When("I enter \"([^\"]*)\" in the search bar")
	public static void inputSearchBar(
			String input)
		throws Exception {

		_projectSelenium.sendKeys(
			"//input[@title='Search']", input);
	}

}