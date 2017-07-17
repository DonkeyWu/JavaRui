package com.yt.tools.loader;

/**
 * @author lyen.wu
 * email : flash_rui@126.com
 * 2017年7月16日
 *
 */
public interface IYtLoader extends IYtInputStreamLoader{

	/**
	 * 文件是否存在，在file，和classpath中方法可用
	 * @return
	 */
	public boolean isExists();
	
	/**
	 * 是否可读，在file中可用
	 * @return
	 */
	public boolean isReadable();
	
}
