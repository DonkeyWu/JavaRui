package com.yt.tool.http.utils;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class YtHttpProtetyUtils {
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
	
	/**
	 * 设置cookie内容，会自动转成map
	 * 第一个属性同时会存入，only-sessionId
	 * @param cookieContent
	 */
	public static void setCookie(Map<String,String> cookieMap, String cookieContent){
		if(cookieContent == null){
			return ;
		}
		
		String[] cookies = cookieContent.split(";");
		for( int i = 0 ; i < cookies.length ; i ++ ){
			String[] cookie = cookies[i].split("=");
			String key = cookie[0];
			String value = "";
			if(cookie.length > 1){
				value = cookie[1];
			}
			cookieMap.put(key , value);
			if(i == 0){
				cookieMap.put("only-sessionId", value);
			}
		}
		
	}

}