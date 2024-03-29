package com.yt.tools.http.connection;

import com.yt.tools.http.result.YtBaseConnectResult;
import com.yt.tools.http.result.YtStringConnectResult;

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
