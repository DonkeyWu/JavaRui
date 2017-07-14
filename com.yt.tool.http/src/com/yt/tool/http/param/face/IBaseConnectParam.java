package com.yt.tool.http.param.face;

import java.util.HashMap;
import java.util.Map;

import com.yt.tool.http.utils.HttpProtetyUtils;


/**
 * urlConnect请求的参数
 * 
 * @author lyen.wu
 * 
 */
public interface IBaseConnectParam {

	/**
	 * 获取url链接
	 * */
	public String getUrl() ;
	/**
	 * 获取property属性
	 * */
	public Map<String, String> getPropertyMap();
	/**
	 * 设置property属性
	 * */
	public void setPropertyMap( Map<String, String> propertyMap);
	/**
	 * 获取请求参数
	 * */
	public String getParam();
	/**获取编码*/
	public String getCharsetCode() ;
	/**是否信任所有证书*/
	public boolean isTrustAllCer();
	/**设置cookieMap,每次请求完成之后，都会将cookie设置进来*/
	public void setCookieMap(Map<String, String> cookieMap);
	/**获取cookieMap*/
	public Map<String, String> getCookieMap();
	/**302自动跳转*/
	public boolean isAutoRedirect();

	
	

}





