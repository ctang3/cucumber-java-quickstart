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

import com.liferay.poshi.runner.selenium.BaseWebDriverImpl;
import com.liferay.poshi.runner.selenium.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * @author Cheryl Tang
 */
public class ProjectWebDriverImpl
	extends BaseWebDriverImpl implements ProjectSelenium {

	public ProjectWebDriverImpl(String browserURL, WebDriver webDriver) {
		super(browserURL, webDriver);
	}

	/**
	 * Clicks on an object passed as a WebElement.
	 * Example override method.
	 *
	 * @param webElement the WebElement to click
	 */
	@Override
	public void click(WebElement webElement) {
		try {
			webElement.click();
		}
		catch (Exception e) {
			scrollWebElementIntoView(webElement);

			webElement.click();
		}
	}

	/**
	 * Finds an element on the page using an XPath.
	 * Example extension method.
	 *
	 * @param xpath the XPath of the target element
	 * @return the found element as a WebElement object
	 */
	public WebElement findElement(String xpath) {
		return findElement(By.xpath(xpath));
	}

	/**
	 * Finds an element on the page scoped within another WebElement, using an XPath.
	 *
	 * @param xpath the XPath of the target element
	 * @param webElement the WebElement object to scope the search within
	 * @return the found element as a WebElement object
	 */
	public WebElement findElement(String xpath, WebElement webElement) {
		return webElement.findElement(By.xpath(xpath));
	}

	/**
	 * Finds all elements on the page matching an XPath.
	 *
	 * @param xpath the XPath of the target elements
	 * @return the found elements as a List of WebElements
	 */
	public List<WebElement> findElements(String xpath) {
		return findElements(By.xpath(xpath));
	}

	/**
	 * Waits for the page's javascript to finish loading.
	 */
	public void waitForJavascriptLoadingComplete() {
		WebDriverWait waitDriverWait = new WebDriverWait(
			WebDriverUtil.getWebDriver(), 30);

		waitDriverWait.until(
			webDriver -> {
				JavascriptExecutor javascriptExecutor =
					(JavascriptExecutor)webDriver;

				String readyState = (String)javascriptExecutor.executeScript(
					"return document.readyState");

				return readyState.equals("complete");
			});
	}

}