package com.train.org.json;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
import org.junit.Test;

/**
 * 使用JSONObject构造的JSON文本顺序杂乱，使用JSONStringer则按顺序排列。
 * 一般情况下使用JSONObject即可，但对于一些嵌套的JSON，某些JSONArray没有key,只有value等特殊情况，
 * 则使用JSONStringer.
 * 
 * @author ryan
 *
 */
public class JSONObjectTest {

	@Test
	public void test() {
		System.out.println(prepareJSONObject());
		System.out.println(prepareJSONObject2());
	}

	private static String prepareJSONObject() {
		JSONObject studentJSONObject = new JSONObject();
		try {
			studentJSONObject.put("name", "Jason");
			studentJSONObject.put("id", 20130001);
			studentJSONObject.put("phone", "13579246810");
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return studentJSONObject.toString();
	}

	private static String prepareJSONObject2() {
		JSONStringer jsonStringer = new JSONStringer();
		try {
			jsonStringer.object();
			jsonStringer.key("name");
			jsonStringer.value("Jason");
			jsonStringer.key("id");
			jsonStringer.value(20130001);
			jsonStringer.key("phone");
			jsonStringer.value("13579246810");
			jsonStringer.endObject();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonStringer.toString();
	}

}
