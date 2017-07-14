package com.yt.tool.http.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import com.yt.tool.http.connection.face.IBaseConnection;
import com.yt.tool.http.param.BaseConnectParam;
import com.yt.tool.http.param.face.IBaseConnectParam;
import com.yt.tool.http.result.face.IBaseConnectResult;
import com.yt.tool.http.utils.HttpProtetyUtils;
import com.yt.tool.log.ConnLogFactory;
import com.yt.tool.log.IConnLog;

/**
 * 基础的网络请求类，封装了总体流程
 * @author lyen.wu
 *
 */
public abstract class BaseConnection implements IBaseConnection {
	private static IConnLog log = null;

	protected IBaseConnectResult connectResult;
	protected IBaseConnectParam connectParam;

	public BaseConnection() {
		log = ConnLogFactory.getLogger(this.getClass());
		
	}

	/**
	 * 设置信任所有的证书
	 * @throws Exception
	 */
	private static void trustAllHttpsCertificates() throws Exception {
		javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
		javax.net.ssl.TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext
				.getInstance("TLSv1");
		sc.init(null, trustAllCerts, null);
		javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc
				.getSocketFactory());
	}

	static class miTM implements javax.net.ssl.TrustManager,
			javax.net.ssl.X509TrustManager {
		public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(
				java.security.cert.X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}

		public void checkClientTrusted(
				java.security.cert.X509Certificate[] certs, String authType)
				throws java.security.cert.CertificateException {
			return;
		}
	}

	@Override
	public void setConnectParam(IBaseConnectParam connectParam){
		checkParamCls(connectParam);
		this.connectParam = connectParam;
	}

	@Override
	public void setConnectParam(String url) {
		setConnectParam(new BaseConnectParam(url));
		
	}
	
	/**
	 * 检测类，或者参数是否足够
	 * @param connectParam
	 */
	protected void checkParamCls(IBaseConnectParam connectParam){
		
	}


	@Override
	public void post() throws Exception {
		SimpleCall call = new SimpleCall() {

			@Override
			public void doGet(HttpURLConnection conn) throws IOException {

			}

			@Override
			public void doPost(HttpURLConnection conn, String param)
					throws Exception {
				// 发送POST请求必须设置如下两行
				conn.setDoOutput(true);
				conn.setDoInput(true);
				// 获取URLConnection对象对应的输出流
				PrintWriter out = new PrintWriter(new OutputStreamWriter(
						conn.getOutputStream(), connectParam.getCharsetCode()));

				// 发送请求参数
				out.print(param);

				// flush输出流的缓冲
				out.flush();
			}

		};
		getOrPost(call, "post");

	}

	@Override
	public void get() throws Exception {
		SimpleCall call = new SimpleCall() {

			@Override
			public void doGet(HttpURLConnection conn) throws IOException {
				conn.connect();

			}

			@Override
			public void doPost(HttpURLConnection conn, String param)
					throws Exception {

			}

		};
		getOrPost(call, "get");

	}

	protected void getOrPost(SimpleCall call, String type) throws Exception {
		beforeRequest();
		
		connectResult = getConnectResult();
		
		BufferedReader in = null;

		String url = connectParam.getUrl();
		String param = connectParam.getParam();
		try {
			String urlName = url ;
			URL realUrl = new URL(urlName);
			
			if(connectParam.isAutoRedirect()){
				HostnameVerifier hv = new HostnameVerifier() {  
			        public boolean verify(String urlHostName, SSLSession session) {  
			        	log.info("Warning: URL Host: " + urlHostName + " vs. "  
			                               + session.getPeerHost());  
			            return true;  
			        }  
			    };
			    trustAllHttpsCertificates();  
			    HttpsURLConnection.setDefaultHostnameVerifier(hv);  
			}
			
			// 打开和URL之间的连接
			HttpURLConnection conn = (HttpURLConnection) realUrl
					.openConnection();
			if (connectParam.getPropertyMap() == null || connectParam.getPropertyMap().size() == 0) {
				connectParam.setPropertyMap(HttpProtetyUtils.getCommonProtety());
			}
			Map<String, String> map = connectParam.getPropertyMap();
			// 设置通用的请求属性
			HttpProtetyUtils.setRequestProperty(conn, map);
			// 设置cookie
			HttpProtetyUtils.setRequestProperty(conn, connectParam.getCookieMap());
			//设置302自动跳转
			conn.setInstanceFollowRedirects(connectParam.isAutoRedirect());
			
			
			// 建立实际的连接
			if (type.equals("get")) {
				call.doGet(conn);
			} else if (type.equals("post")) {
				call.doPost(conn, param);
			}
			doingRequest(conn);
			// 设置请求结果
			int state = conn.getResponseCode();
			connectResult.setStateCode(state);
			// 设置流
			connectResult.setIn(conn.getInputStream());
			// 处理流
			connectResult.dealIn(connectParam.getCharsetCode());
			// 定义BufferedReader输入流来读取URL的响应
			String cookieValue = conn.getHeaderField("Set-Cookie");
			HttpProtetyUtils.setCookie(connectParam.getCookieMap(), cookieValue);
		} catch (Exception e) {
			log.error("发送  "+type+" 请求出现异常！" + e);
			throw e;
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
				call.finallyAction();
				afterRequest();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public abstract class SimpleCall {
		PrintWriter out = null;
		HttpURLConnection conn = null;

		public abstract void doGet(HttpURLConnection conn) throws Exception;

		public abstract void doPost(HttpURLConnection conn, String param)
				throws Exception;

		/** 删除引用 */
		public void finallyAction() {
			if(out != null){
				out.close();
			}
			out = null;
			conn = null;
		}

	}

	/**
	 * 复写该方法，在请求之前执行
	 */
	protected void beforeRequest(){
		
	}
	
	/**
	 * 复写该方法，在conn.connect之后马上执行
	 * @param conn
	 */
	protected void doingRequest(HttpURLConnection conn){
		
	}
	
	/**
	 * 复写该方法，在请求之后执行
	 */
	protected void afterRequest(){
		
	}
	
	
	
}
