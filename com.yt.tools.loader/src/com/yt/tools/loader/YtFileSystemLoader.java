package com.yt.tools.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class YtFileSystemLoader extends YtLoader{

	public YtFileSystemLoader(String path) {
		this(path,null);
	}
	
	public YtFileSystemLoader(String path,String desc) {
		this.desc = desc;
		this.path = path;
	}
	
	public InputStream getIn() throws IOException {
		InputStream in = new FileInputStream(path);
		notNull(in);
		return in;
	}

	@Override
	public boolean isExists() {
		return new File(path).exists();
	}
	
	/**
	 * 是否可读，且不是文件夹
	 * 
	 */
	@Override
	public boolean isReadable() {
		return new File(path).canRead() && !new File(path).isDirectory();
	}
	
}
