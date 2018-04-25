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
import cucumber.api.java.en.When;
import cucumber.boilerplate.steps.pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

/**
 * @author Cheryl Tang
 */
public class GeneralSteps extends BasePage {

	/**
	 * Accepts or dismisses a javascript alert popup.
	 *
	 * @param action the action on the alert, either 'accept' or 'dismiss'
	 */
	@When("I (accept|dismiss) the alert")
	public static void handleAlert(String action) {
		WebDriver webDriver = WebDriverUtil.getWebDriver();

		WebDriver.TargetLocator targetLocator = webDriver.switchTo();

		Alert alert = targetLocator.alert();

		if (action.equals("accept")) {
			alert.accept();
		}
		else {
			alert.dismiss();
		}
	}

}