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

package cucumber.boilerplate.driver;

import com.liferay.poshi.runner.selenium.LiferaySelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author Cheryl Tang
 */
public interface ProjectSelenium extends LiferaySelenium, WebDriver {

	public void click(WebElement webElement);

	public WebElement findElement(String xpath);

	public WebElement findElement(String xpath, WebElement webElement);

	public List<WebElement> findElements(String xpath);

	public void waitForJavascriptLoadingComplete();

}