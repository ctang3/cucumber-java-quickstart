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

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Cheryl Tang
 */
public class AppResponse {

	public AppResponse(int httpStatusCode, JSONObject jsonObject) {
		_httpStatusCode = httpStatusCode;
		_jsonObject = jsonObject;
	}

	public AppResponse(int httpStatusCode, String json) {
		_httpStatusCode = httpStatusCode;

		_jsonObject = _createJSONObject(json);
	}

	public JSONObject getBodyJSONObject() {
		return _jsonObject;
	}

	public int getHttpStatusCode() {
		return _httpStatusCode;
	}

	private JSONObject _createJSONObject(String json) {
		try {
			return new JSONObject(json);
		}
		catch (JSONException jsone) {
			return new JSONObject();
		}
	}

	private final int _httpStatusCode;
	private final JSONObject _jsonObject;

}