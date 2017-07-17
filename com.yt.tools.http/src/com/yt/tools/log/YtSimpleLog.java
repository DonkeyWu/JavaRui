package com.yt.tools.log;

public class YtSimpleLog implements IYtConnLog{

	private String clsName = "";
	public YtSimpleLog(Class<?> cls) {
		clsName = cls.getName();
	}
	
	@Override
	public void info(String o) {
		System.out.println("["+clsName + "]    "+o);
		
	}

	@Override
	public void debug(String o) {
		System.out.println("["+clsName + "]    "+o);
		
	}

	@Override
	public void error(String o) {
		System.err.println("["+clsName + "]    "+o);
		
	}

	
	
}
