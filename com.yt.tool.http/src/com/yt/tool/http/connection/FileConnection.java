package com.yt.tool.http.connection;

import com.yt.tool.http.result.BaseConnectResult;
import com.yt.tool.http.result.FileConnectResult;

/**
 * 获取文件的网络请求，保存到本地。
 * @author lyen.wu
 *
 */
public class FileConnection extends BaseConnection{
	
	private String filePath = null;
	private FileConnectResult fileConnectResult = new FileConnectResult();
	public FileConnection(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public BaseConnectResult getConnectResult() {
		return fileConnectResult;
	}
	@Override
	public Object getResultObj() {
		
		return fileConnectResult.getFilePath();
	}
	
	@Override
	protected void beforeRequest() {
		super.beforeRequest();
		fileConnectResult.setFilePath(filePath);
	}
	
	
}
