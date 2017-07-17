package com.yt.tool.http.connection.face;

import com.yt.tool.http.param.face.IYtBaseConnectParam;
import com.yt.tool.http.result.face.IYtBaseConnectResult;

/**
 * @author lyen.wu
 * http请求主流程
 */
public interface IYtBaseConnection {

	/**
	 * 设置request的参数
	 * @param connectParam
	 */
	public void setConnectParam(IYtBaseConnectParam connectParam);
	/**设置url，自动生成baseConnectParam*/
	public void setConnectParam(String url);
	/**
	 * 获取返回的结果对象
	 * */
	public IYtBaseConnectResult getConnectResult() ;
	public void post() throws Exception;
	public void get() throws Exception;
	/**
	 * 获取结果对象的简略结果，比如string，比如filePath
	 * */
	public Object getResultObj();
	
}
