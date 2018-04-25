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

import com.liferay.poshi.runner.selenium.SeleniumUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.boilerplate.driver.ProjectSelenium;
import cucumber.boilerplate.util.ProjectSeleniumUtil;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Cheryl Tang
 */
public class CucumberHooks {

	@Before //Runs before each scenario
	public static void setUp() {
		SeleniumUtil.getSelenium();

		ProjectSelenium projectSelenium = ProjectSeleniumUtil.getProjectSelenium();

		WebDriver.Options options = projectSelenium.manage();

		WebDriver.Timeouts timeouts = options.timeouts();

		timeouts.implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After //Runs after each scenario
	public static void tearDown() throws Exception {
		ProjectSelenium projectSelenium = ProjectSeleniumUtil.getProjectSelenium();

		WebDriver.Options manage = projectSelenium.manage();

		manage.deleteAllCookies();
	}

}