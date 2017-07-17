package com.yt.tools.loader;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import com.yt.tool.io.YtInputStream2OtherUtils;

public class Demo {

	public static void main(String[] args) throws Exception {
		IYtInputStreamLoader loader = new YtClassPathLoader(Demo.class, "t.txt");
		InputStream in = loader.getIn();
		String content = YtInputStream2OtherUtils.in2String(in, "gbk");
		System.out.println(content);
	}
	@Test
	public  void testClassPath() throws Exception {
		IYtInputStreamLoader loader = new YtClassPathLoader(Demo.class, "t.txt");
		InputStream in = loader.getIn();
		String content = YtInputStream2OtherUtils.in2String(in, "gbk");
		System.out.println(content);
	}
	
	/**
	 * 仔细看报错信息
	 * @throws Exception
	 */
	@Test
	public  void errClassPath() throws Exception {
		IYtInputStreamLoader loader = new YtClassPathLoader(Demo.class, "t1.txt" );
		InputStream in = loader.getIn();
		String content = YtInputStream2OtherUtils.in2String(in, "gbk");
		System.out.println(content);
	}
	
	@Test
	public  void testFileSystem() throws Exception{
		IYtInputStreamLoader loader = new YtFileSystemLoader("t.txt");
		InputStream in = loader.getIn();
		String content = YtInputStream2OtherUtils.in2String(in, "utf-8");
		System.out.println(content);
	}
	
	@Test
	public  void errFileSystem() throws Exception{
		IYtInputStreamLoader loader = new YtFileSystemLoader("t1.txt");
		InputStream in = loader.getIn();
		String content = YtInputStream2OtherUtils.in2String(in, "utf-8");
		System.out.println(content);
	}
}
