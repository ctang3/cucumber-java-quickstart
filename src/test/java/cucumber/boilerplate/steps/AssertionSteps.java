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

import cucumber.api.java.en.Then;
import cucumber.boilerplate.steps.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

/**
 * @author Cheryl Tang
 */
public class AssertionSteps extends BasePage {

	/**
	 * Asserts that the first result in a Google Search has a certain title.
	 *
	 * @param resultTitle the title to assert
	 * @throws Exception if an exception occurs
	 */
	@Then("^I should see that the first result is \"([^\"]*)\"$")
	public void assertFirstSearchResult(String resultTitle) throws Exception {
		WebElement webElement = _projectSelenium.findElement(
				"(//div[@class='rc'])[1]//a");

		Assert.assertTrue(webElement.getText().equals(resultTitle));
	}

}