package com.yt.tools.loader;

import java.io.IOException;
import java.io.InputStream;

public class YtClassPathLoader extends YtLoader {

	private Class<?> clazz;
	
	public YtClassPathLoader(Class<?> clazz , String path ) {
		this(clazz,path,null);
	}
	
	public YtClassPathLoader(Class<?> clazz , String path ,String desc) {
		this.clazz = clazz;
		this.path = path;
		this.desc = desc;
	}
	
	public InputStream getIn() throws IOException {
		InputStream is = this.clazz.getResourceAsStream(path);
		notNull(is);
		return is;
	}
	
	@Override
	public boolean isExists() {
		InputStream is = this.clazz.getResourceAsStream(path);
		boolean ex = is == null?false:true;
		return ex;
	}
	

	
	
	
	
}
