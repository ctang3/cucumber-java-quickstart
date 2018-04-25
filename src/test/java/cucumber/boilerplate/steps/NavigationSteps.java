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

import com.liferay.poshi.runner.selenium.WebDriverUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.boilerplate.steps.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Cheryl Tang
 */
public class NavigationSteps extends BasePage {

	/**
	 * Moves back a single "item" in the browser's history.
	 */
	@When("^I go back one page$")
	public static void browserBack() {
		_projectSelenium.goBack();
	}

	/**
	 * Moves a single "item" forward in the browser's history. Doesn't do
	 * anything if we are on the latest page viewed.
	 */
	@When("^I go forward one page$")
	public static void browserForward() {
		WebDriver webDriver = WebDriverUtil.getWebDriver();

		WebDriver.Navigation navigation = webDriver.navigate();

		navigation.forward();
	}

	/**
	 * Switches to the focused modal.
	 */
	@When("^I switch to the focused modal$")
	public static void switchToFocusedModal() {
		WebDriver webDriver = WebDriverUtil.getWebDriver();

		WebElement modalWebElement = _projectSelenium.findElement(
			"//iframe[contains(@class,'dialog-iframe-node')]");

		WebDriver.TargetLocator targetLocator = webDriver.switchTo();

		targetLocator.frame(modalWebElement);
	}

	/**
	 * Switches to the main content frame.
	 */
	@When("^I switch to the main frame$")
	public static void switchToMainFrame() {
		WebDriver webDriver = WebDriverUtil.getWebDriver();

		WebDriver.TargetLocator targetLocator = webDriver.switchTo();

		_projectSelenium.goBack();
		targetLocator.defaultContent();
	}

	/**
	 * Navigates to a URL.
	 *
	 * @param url the destination URL
	 */
	@Given("^I go to \"([^\"]*)\"$")
	public void goToUrl(String url) {
		_projectSelenium.get(url);
	}

}