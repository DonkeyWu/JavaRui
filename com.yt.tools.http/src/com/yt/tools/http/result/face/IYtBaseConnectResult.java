package com.yt.tools.http.result.face;

import java.io.InputStream;


/**
 * 
 * @author lyen.wu
 *
 */
public interface IYtBaseConnectResult {

	public int getStateCode() ;
	public void setStateCode(int stateCode);
	public InputStream getIn();
	public void setIn(InputStream in);
	
	public  void dealIn()throws Exception;
	
	public  void dealIn(String charset) throws Exception;
	
	
}
