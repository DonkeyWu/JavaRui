package com.yt.tool.log;

public class SimpleLog implements IConnLog{

	private String clsName = "";
	public SimpleLog(Class<?> cls) {
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
