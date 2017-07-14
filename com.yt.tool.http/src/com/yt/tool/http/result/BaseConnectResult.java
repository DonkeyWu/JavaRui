package com.yt.tool.http.result;

import java.io.InputStream;

import com.yt.tool.http.result.face.IBaseConnectResult;


/**
 * 
 * @author lyen.wu
 *
 */
public abstract class BaseConnectResult implements IBaseConnectResult{

	
	/**
	 * 放置流,子类必须实现流的解析
	 * */
	protected InputStream in = null;
	/**
	 * 状态码：
	 * 0：说明在运行之前还没开始请求就报错了。
	 */
	private int stateCode = 0;
	
	public int getStateCode() {
		return stateCode;
	}
	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}
	public InputStream getIn() {
		return in;
	}
	public void setIn(InputStream in) {
		this.in = in;
	}
	
	public  void dealIn()throws Exception{
		dealIn("UTF-8");
	}
	
	public abstract void dealIn(String charset) throws Exception;
	
	
}
