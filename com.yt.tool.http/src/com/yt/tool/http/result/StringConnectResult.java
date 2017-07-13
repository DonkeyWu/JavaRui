package com.yt.tool.http.result;

import com.yt.tool.utils.In2ResultUtils;



/**
 * 文本回包
 * @author lyen.wu
 *
 */
public class StringConnectResult extends BaseConnectResult {

	private String content = "";

	@Override
	public void dealIn(String charsetCode) throws Exception {
		content = In2ResultUtils.in2String(in, charsetCode);

	}

	public String getContent(){
		return content;
	}
	
}
