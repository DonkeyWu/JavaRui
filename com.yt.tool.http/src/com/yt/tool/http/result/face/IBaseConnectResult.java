package com.yt.tool.http.result.face;

import java.io.InputStream;


/**
 * 
 * @author lyen.wu
 *
 */
public interface IBaseConnectResult {

	public int getStateCode() ;
	public void setStateCode(int stateCode);
	public InputStream getIn();
	public void setIn(InputStream in);
	
	public  void dealIn()throws Exception;
	
	public  void dealIn(String charset) throws Exception;
	
	
}
