package com.yt.tools.loader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author lyen.wu
 * email : flash_rui@126.com
 * 2017年7月16日
 * 
 * 最终的目标，获取inputstream，此类为原始接口类
 *
 */
public interface IYtInputStreamLoader {

	/**
	 * 获取目标inputStream
	 * @return
	 * @throws IOException
	 */
	public InputStream getIn() throws IOException;
	
}
