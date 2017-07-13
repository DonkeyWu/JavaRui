package com.yt.tool.http.result;

import com.yt.tool.utils.In2ResultUtils;


/**
 * 转换成file
 * 
 * @author lyen.wu
 * 
 */
public class FileConnectResult extends BaseConnectResult {

	/** 文件存放路径 */
	private String filePath = "";

	@Override
	public void dealIn(String charset) throws Exception {
		In2ResultUtils.in2File(in, filePath);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;

	}


}
