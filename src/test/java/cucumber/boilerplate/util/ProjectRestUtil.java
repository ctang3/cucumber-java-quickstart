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

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

/**
 * @author Cheryl Tang
 */
public class ProjectRestUtil {

	public static AppResponse delete(String url) throws Exception {
		return _execute(Request.Delete(url));
	}

	public static AppResponse get(String url) throws Exception {
		return _execute(Request.Get(url));
	}

	public static AppResponse post(String url) throws Exception {
		return _execute(Request.Post(url));
	}

	public static AppResponse post(String url, String json) throws Exception {
		Request request = Request.Post(url);

		return _execute(request.bodyString(json, ContentType.APPLICATION_JSON));
	}

	/**
	 * Sends an API request and returns an AppResponse containing the status
	 * code and a JSON object representation of the response body.
	 *
	 * @param  request the API request to send
	 * @return the AppResponse containing the status code and JSON object
	 *         representation of the response
	 * @throws Exception if an exception occurred
	 */
	private static AppResponse _execute(Request request) throws Exception {
		Executor executor = Executor.newInstance();

		executor.auth(
			new HttpHost("localhost", 8080), "test@liferay.com", "test");

		Response response = executor.execute(request);

		return response.handleResponse(_projectResponseHandler);
	}

	private static final ProjectResponseHandler _projectResponseHandler =
		new ProjectResponseHandler();

}