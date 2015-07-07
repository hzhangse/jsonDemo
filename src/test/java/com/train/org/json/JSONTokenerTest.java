package com.train.org.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

public class JSONTokenerTest {

	@Test
	public void test() {
		System.out.println(getJSONContent());
		System.out.println(getJSONContent2());
	}

	private static String JSONText = "{\"id\":20130001,\"phone\":\"13579246810\",\"name\":\"Jason\"}";

	private static String getJSONContent() {
		JSONTokener jsonTokener = new JSONTokener(JSONText);
		JSONObject studentJSONObject;
		String name = null;
		int id = 0;
		String phone = null;
		try {
			studentJSONObject = (JSONObject) jsonTokener.nextValue();
			name = studentJSONObject.getString("name");
			id = studentJSONObject.getInt("id");
			phone = studentJSONObject.getString("phone");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return name + "  " + id + "   " + phone;
	}

	private static String getJSONContent2() {
		String name = null;
		int id = 0;
		String phone = null;
		try {
			JSONObject studentJSONObject = new JSONObject(JSONText);
			name = studentJSONObject.getString("name");
			id = studentJSONObject.getInt("id");
			phone = studentJSONObject.getString("phone");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return name + "  " + id + "   " + phone;
	}
}
