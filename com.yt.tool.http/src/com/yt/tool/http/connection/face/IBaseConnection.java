package com.yt.tool.http.connection.face;

import com.yt.tool.http.param.face.IBaseConnectParam;
import com.yt.tool.http.result.face.IBaseConnectResult;

/**
 * @author lyen.wu
 * http请求主流程
 */
public interface IBaseConnection {

	/**
	 * 设置request的参数
	 * @param connectParam
	 */
	public void setConnectParam(IBaseConnectParam connectParam);
	/**设置url，自动生成baseConnectParam*/
	public void setConnectParam(String url);
	/**
	 * 获取返回的结果对象
	 * */
	public IBaseConnectResult getConnectResult() ;
	public void post() throws Exception;
	public void get() throws Exception;
	/**
	 * 获取结果对象的简略结果，比如string，比如filePath
	 * */
	public Object getResultObj();
	
}
