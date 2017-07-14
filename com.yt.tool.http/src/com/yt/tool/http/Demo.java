package com.yt.tool.http;


import org.junit.Test;

import com.yt.tool.http.connection.FileConnection;
import com.yt.tool.http.connection.StringConnection;
import com.yt.tool.http.connection.face.IBaseConnection;
import com.yt.tool.http.param.BaseConnectParam;
import com.yt.tool.log.ConnLogFactory;
import com.yt.tool.log.IConnLog;

public class Demo {  
      
	static IConnLog log = ConnLogFactory.getLogger(Demo.class);
    
    @Test
    public void testHeadPost() throws Exception {
    	String param = "";
    	BaseConnectParam connectParam = new BaseConnectParam("http://10.143.173.61:7103/PS/TEST");
    	//删除类property的属性，就无法访问
    	connectParam.getPropertyMap().put("appid", "hello");
		connectParam.getPropertyMap().put("appkey", "word");
    	connectParam.setParam(param);
        IBaseConnection connection = new StringConnection();
        connection.setConnectParam(connectParam);
        connection.post();
        log.info(connection.getResultObj()+"");
	}



    @Test
	public void testStringPost() throws Exception{
    	//http://10.143.60.145:7003/PaymentCenter/payment2OSBControllerRes/singleRefund.json
    	String param = "{\"order\": \"32221\",\"refoundAmt\":\"9.5\",\"remoteip\":\"10.143.172.120\"}";
    	BaseConnectParam connectParam = new BaseConnectParam("http://10.143.60.145:7003/pay/singleRefund.json");
    	connectParam.setParam(param);
        IBaseConnection connection = new StringConnection();
        connection.setConnectParam(connectParam);
        connection.post();
        log.info(connection.getResultObj()+"");
    }
    @Test
    public void testImgGet() throws Exception {
    	BaseConnectParam connectParam = new BaseConnectParam("http://pic.qiantucdn.com/58pic/15/28/06/57458PIC5Zb_1024.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center");
        IBaseConnection connection = new FileConnection("d:\\da.jpg");
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    @Test
    public void testFileGet() throws Exception {
    	BaseConnectParam connectParam = new BaseConnectParam("http://www.webxml.com.cn/files/WeatherWsHelp.pdf");
        IBaseConnection connection = new FileConnection("d:\\WeatherWsHelp.pdf");
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    @Test
    public void testStringGet() throws Exception{
    	BaseConnectParam connectParam = new BaseConnectParam("http://www.baidu.com");
        IBaseConnection connection = new StringConnection();
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    @Test
    public void testStringGet2() throws Exception{
        IBaseConnection connection = new StringConnection();
        connection.setConnectParam("http://www.baidu.com");
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    
} 
