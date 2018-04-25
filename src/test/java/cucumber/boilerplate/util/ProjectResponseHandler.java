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

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.ContentResponseHandler;
import org.json.JSONObject;

import java.io.IOException;

/**
 * @author Cheryl Tang
 */
public class ProjectResponseHandler implements ResponseHandler<AppResponse> {

	/**
	 * Handles the response from a request.
	 *
	 * @param  httpResponse the response to handle
	 * @return the AppResponse containing the status code and JSON object
	 * @throws IOException if an exception occurred
	 */
	@Override
	public AppResponse handleResponse(HttpResponse httpResponse)
		throws IOException {

		StatusLine statusLine = httpResponse.getStatusLine();

		int statusCode = statusLine.getStatusCode();

		if (statusCode >= 300) {
			throw new HttpResponseException(
				statusCode, statusLine.getReasonPhrase());
		}
		else if (statusCode == 204) {
			return new AppResponse(statusCode, new JSONObject());
		}

		HttpEntity httpEntity = httpResponse.getEntity();

		if (httpEntity == null) {
			throw new ClientProtocolException("Response contains no content.");
		}

		ContentResponseHandler contentResponseHandler =
			new ContentResponseHandler();

		Content content = contentResponseHandler.handleEntity(httpEntity);

		return new AppResponse(statusCode, content.asString());
	}

}