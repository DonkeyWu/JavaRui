package com.yt.tools.loader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author lyen.wu
 * email : flash_rui@126.com
 * 2017年7月16日
 *
 * 字节流读取器
 */
public class YtByteArrayLoader extends YtLoader{

	private  byte[] byteArray = null;
	
	public YtByteArrayLoader(byte[] byteArray) {
		this(byteArray , "byte");
	}
	
	public YtByteArrayLoader(byte[] byteArray , String desc) {
		this.byteArray = byteArray;
		this.desc = desc;
	}
	

	public InputStream getIn() throws IOException {
		notNull(byteArray);
		return new ByteArrayInputStream(this.byteArray);
	}
	
	@Override
	public String getDesc() {
		return desc;
	}
}
