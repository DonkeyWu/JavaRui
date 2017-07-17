package com.yt.tools.http.connection;

import com.yt.tools.http.result.YtBaseConnectResult;
import com.yt.tools.http.result.YtFileConnectResult;

/**
 * 获取文件的网络请求，保存到本地。
 * @author lyen.wu
 *
 */
public class YtFileConnection extends YtBaseConnection{
	
	private String filePath = null;
	private YtFileConnectResult fileConnectResult = new YtFileConnectResult();
	public YtFileConnection(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public YtBaseConnectResult getConnectResult() {
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
