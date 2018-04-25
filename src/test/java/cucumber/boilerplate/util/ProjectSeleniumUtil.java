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

package cucumber.boilerplate.util;

import com.liferay.poshi.runner.selenium.WebDriverUtil;
import com.liferay.poshi.runner.util.PropsValues;
import cucumber.boilerplate.driver.ProjectSelenium;
import cucumber.boilerplate.driver.ProjectWebDriver;

/**
 * @author Cheryl Tang
 */
public class ProjectSeleniumUtil {

	public static ProjectSelenium getProjectSelenium() {
		return _instance._getProjectSelenium();
	}

	public static void startSelenium() {
		_instance._startProjectSelenium();
	}

	public static void stopSelenium() {
		_instance._stopProjectSelenium();
	}

	private ProjectSelenium _getProjectSelenium() {
		if (_projectSelenium == null) {
			_startProjectSelenium();
		}

		return _projectSelenium;
	}

	private void _startProjectSelenium() {
		_projectSelenium = new ProjectWebDriver(
			PropsValues.PORTAL_URL, WebDriverUtil.getWebDriver());
	}

	private void _stopProjectSelenium() {
		if (_projectSelenium != null) {
			WebDriverUtil.stopWebDriver();

			_projectSelenium.stop();

			_projectSelenium.stopLogger();
		}

		_projectSelenium = null;
	}

	private static final ProjectSeleniumUtil _instance = new ProjectSeleniumUtil();

	private static ProjectSelenium _projectSelenium;

}