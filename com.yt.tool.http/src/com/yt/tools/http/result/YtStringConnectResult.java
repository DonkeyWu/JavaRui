package com.yt.tools.http.result;

import com.yt.tools.io.YtInputStream2OtherUtils;



/**
 * 文本回包
 * @author lyen.wu
 *
 */
public class YtStringConnectResult extends YtBaseConnectResult {

	private String content = "";

	@Override
	public void dealIn(String charsetCode) throws Exception {
		content = YtInputStream2OtherUtils.in2String(in, charsetCode);

	}

	public String getContent(){
		return content;
	}
	
}
