package com.yt.tools.loader;

import com.yt.tool.check.YtAssert;

public abstract class YtLoader implements IYtLoader{

	/**文件路径，有可能为null，某些读取方式不需要设置路径*/
	protected String path = "";
	/**读取的描述标记，在程序上无作用，只用于调试。日志*/
	protected String desc = null;
	
	public boolean isExists() {
		return true;
	}
	
	/**
	 * 不为null判断，判断流或文件,是否存在
	 * @param in
	 */
	public void notNull(Object in){
		YtAssert.notNull(in, this.getClass() , getDesc() + "  cannot be opened mabe it does not exist");
	}
	
	public boolean isReadable() {
		return true;
	}
	
	/**
	 * 获取描述字符串
	 * @return
	 */
	public String getDesc(){
		return desc == null ? path : desc;
	}
	
}
