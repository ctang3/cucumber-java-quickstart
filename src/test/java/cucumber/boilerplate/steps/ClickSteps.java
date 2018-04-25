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

import com.liferay.portal.kernel.util.StringBundler;
import cucumber.api.java.en.When;
import cucumber.boilerplate.steps.pages.BasePage;
import org.openqa.selenium.WebElement;

/**
 * @author Cheryl Tang
 */
public class ClickSteps extends BasePage {

	public static void clickButton(String targetName) throws Exception {
		clickButton(targetName, null);
	}

	/**
	 * Clicks a button.
	 *
	 * @param targetName the target element's name or another identifier
	 */
	@When("^I click the \"([^\"]*)\" (radio )?button$")
	public static void clickButton(
			String targetName, String radio) {

		if (radio != null) {
			WebElement webElement = _projectSelenium.findElement(
				"//input[@type='radio']/following-sibling::span[contains(.,'" +
					targetName + "')]");

			webElement.click();

			return;
		}

		StringBundler sb = new StringBundler(8);

		sb.append("//button[normalize-space(text())='");
		sb.append(targetName);
		sb.append("']|//input[@type='button' and normalize-space(@value)='");
		sb.append(targetName);
		sb.append("']");

		WebElement webElement = _projectSelenium.findElement(sb.toString());

		webElement.click();
	}

}