package com.yt.tool.http.param;

import java.util.HashMap;
import java.util.Map;

import com.yt.tool.http.param.face.IBaseConnectParam;
import com.yt.tool.http.utils.HttpProtetyUtils;


/**
 * urlConnect请求的参数
 * 
 * @author lyen.wu
 * 
 */
public class BaseConnectParam implements IBaseConnectParam{

	//表头参数设置
	private Map<String, String> propertyMap = new HashMap<String, String>();
	//get或者post的参数
	private String param = "";
	//请求的链接
	private String url = "";

	// 设置 HttpURLConnection的字符编码
	private String charsetCode = "UTF-8";
	//信任所有证书
	private boolean trustAllCer = true;
	
	//cookie用以共用session
	private Map<String, String> cookieMap = new HashMap<String, String>();

	private boolean autoRedirect = true;
	

	public BaseConnectParam(String url, String param) {
		this(url,null,null,param);
	}
	public BaseConnectParam(String url) {
		this(url,"");
	}

	public BaseConnectParam(String url, Map<String, String> propertiesMap,
			Map<String, String> headerMap, String param) {
		super();
		this.url = url;
		if(propertiesMap != null){
			this.propertyMap = propertiesMap;
		}
		this.param = param;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 设置通用的property属性
	 */
	public void setCommonProperty() {
		propertyMap = HttpProtetyUtils.getCommonProtety();
	}

	@Override
	public String toString() {
		return "ConnectParam [propertiesMap=" + propertyMap + ", param="
				+ param + ", url=" + url + "]";
	}

	public Map<String, String> getPropertyMap() {
		return propertyMap;
	}

	public void setPropertyMap(Map<String, String> propertiesMap) {
		this.propertyMap = propertiesMap;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getCharsetCode() {
		return charsetCode;
	}

	public void setCharsetCode(String charsetCode) {
		this.charsetCode = charsetCode;
	}

	public boolean isTrustAllCer() {
		return trustAllCer;
	}

	public void setTrustAllCer(boolean trustAllCer) {
		this.trustAllCer = trustAllCer;
	}

	public Map<String, String> getCookieMap() {
		return cookieMap;
	}

	public void setCookieMap(Map<String, String> cookieMap) {
		this.cookieMap = cookieMap;
	}
	
	/**
	 * 设置cookie内容，会自动转成map
	 * 第一个属性同时会存入，only-sessionId
	 * @param cookieContent
	 */
	public void setCookie(String cookieContent){
		if(cookieContent == null){
			return ;
		}
		
		String[] cookies = cookieContent.split(";");
		for( int i = 0 ; i < cookies.length ; i ++ ){
			String[] cookie = cookies[i].split("=");
			String key = cookie[0];
			String value = "";
			if(cookie.length > 1){
				value = cookie[1];
			}
			cookieMap.put(key , value);
			if(i == 0){
				cookieMap.put("only-sessionId", value);
			}
		}
		
	}
	public boolean isAutoRedirect() {
		return autoRedirect;
	}
	public void setAutoRedirect(boolean autoRedirect) {
		this.autoRedirect = autoRedirect;
	}
	
	

}





