package com.yt.tool.log;

import java.util.HashMap;
import java.util.Map;

public class YtConnLogFactory {

	private static Map<String, IYtConnLog> logMap = new HashMap<String, IYtConnLog>();

	public static IYtConnLog getLogger(Class<?> cls) {
		IYtConnLog log = logMap.get(cls.getName());
		if (log == null) {
			try {
				//如果没有slf4j的class，就会生成simpleLog
				Class aClass = Class.forName("org.slf4j.Logger");
				log = new YtConnLog(cls);
			} catch (ClassNotFoundException e) {
				log = new YtSimpleLog(cls);
			}
			logMap.put(cls.getName(), log);
		}
		return log;

	}

}
