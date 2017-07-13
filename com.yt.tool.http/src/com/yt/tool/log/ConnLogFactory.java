package com.yt.tool.log;

import java.util.HashMap;
import java.util.Map;

public class ConnLogFactory {

	private static Map<String, IConnLog> logMap = new HashMap<String, IConnLog>();

	public static IConnLog getLogger(Class<?> cls) {
		IConnLog log = logMap.get(cls.getName());
		if (log == null) {
			try {
				//如果没有slf4j的class，就会生成simpleLog
				Class aClass = Class.forName("org.slf4j.Logger");
				log = new ConnLog(cls);
			} catch (ClassNotFoundException e) {
				log = new SimpleLog(cls);
			}
			logMap.put(cls.getName(), log);
		}
		return log;

	}

}
