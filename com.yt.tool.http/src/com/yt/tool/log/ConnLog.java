package com.yt.tool.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnLog implements IConnLog{

	private  Logger log = null;
	
	public ConnLog(Class<?> cls) {
		log = LoggerFactory.getLogger(cls);
	}
	
	public void info(String o){
		log.info(o);
	}
	
	public void debug(String o){
		log.debug(o);
	}
	
	public void error(String o){
		log.error(o);
	}
	
	
}
