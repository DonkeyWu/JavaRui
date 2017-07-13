package com.yt.tool.http.connection;

import com.yt.tool.http.result.BaseConnectResult;
import com.yt.tool.http.result.StringConnectResult;

/**
 * 文本网络请求，获取网页的内容或者回包
 * @author lyen.wu
 *
 */
public class StringConnection extends BaseConnection{

	private StringConnectResult stringConnectResult = null ;
	@Override
	public BaseConnectResult getConnectResult() {
		if(stringConnectResult == null){
			stringConnectResult =  new StringConnectResult();
		}
			
		return stringConnectResult;
	}
	@Override
	public Object getResultObj() {
		return stringConnectResult.getContent();
	}

	
	
}
