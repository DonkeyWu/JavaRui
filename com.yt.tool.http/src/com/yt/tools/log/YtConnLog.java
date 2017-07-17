package com.yt.tools.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YtConnLog implements IYtConnLog{

	private  Logger log = null;
	
	public YtConnLog(Class<?> cls) {
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
