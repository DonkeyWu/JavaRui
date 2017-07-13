package com.yt.tool.http.utils;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class HttpProtetyUtils {
	/**
	 * 获取通用的requestPropertity设置
	 * 
	 * @return
	 */
	public static Map<String, String> getCommonProtety() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("accept", "*/*");
		map.put("connection", "Keep-Alive");
		map.put("user-agent",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
		return map;
	}

	/**
	 * 设置request属性
	 * 
	 * @param conn
	 * @param map
	 */
	public static void setRequestProperty(HttpURLConnection conn,
			Map<String, String> map) {
		if (map == null) {
			return;
		}
		for (String key : map.keySet()) {
			conn.setRequestProperty(key, map.get(key));
		}
	}

}