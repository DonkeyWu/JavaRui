package com.yt.tool.http.result;

import com.yt.tool.io.YtInputStream2OtherUtils;


/**
 * 转换成file
 * 
 * @author lyen.wu
 * 
 */
public class YtFileConnectResult extends YtBaseConnectResult {

	/** 文件存放路径 */
	private String filePath = "";

	@Override
	public void dealIn(String charset) throws Exception {
		YtInputStream2OtherUtils.in2File(in, filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;

	}


}
