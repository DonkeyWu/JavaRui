package com.yt.tool.http.connection;

import com.yt.tool.http.result.YtBaseConnectResult;
import com.yt.tool.http.result.YtStringConnectResult;

/**
 * 文本网络请求，获取网页的内容或者回包
 * @author lyen.wu
 *
 */
public class YtStringConnection extends YtBaseConnection{

	private YtStringConnectResult stringConnectResult = null ;
	@Override
	public YtBaseConnectResult getConnectResult() {
		if(stringConnectResult == null){
			stringConnectResult =  new YtStringConnectResult();
		}
			
		return stringConnectResult;
	}
	@Override
	public Object getResultObj() {
		return stringConnectResult.getContent();
	}

	
	
}
