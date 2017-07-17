package com.yt.tools.http;


import org.junit.Test;

import com.yt.tools.http.connection.YtFileConnection;
import com.yt.tools.http.connection.YtStringConnection;
import com.yt.tools.http.connection.face.IYtBaseConnection;
import com.yt.tools.http.param.YtBaseConnectParam;
import com.yt.tools.log.YtConnLogFactory;
import com.yt.tools.log.IYtConnLog;

public class Demo {  
      
	static IYtConnLog log = YtConnLogFactory.getLogger(Demo.class);
    
    @Test
    public void testHeadPost() throws Exception {
    	String param = "";
    	YtBaseConnectParam connectParam = new YtBaseConnectParam("http://10.143.173.61:7103/PS/TEST");
    	//删除类property的属性，就无法访问
    	connectParam.getPropertyMap().put("appid", "hello");
		connectParam.getPropertyMap().put("appkey", "word");
    	connectParam.setParam(param);
        IYtBaseConnection connection = new YtStringConnection();
        connection.setConnectParam(connectParam);
        connection.post();
        log.info(connection.getResultObj()+"");
	}



    @Test
	public void testStringPost() throws Exception{
    	//http://10.143.60.145:7003/PaymentCenter/payment2OSBControllerRes/singleRefund.json
    	String param = "{\"order\": \"32221\",\"refoundAmt\":\"9.5\",\"remoteip\":\"10.143.172.120\"}";
    	YtBaseConnectParam connectParam = new YtBaseConnectParam("http://10.143.60.145:7003/pay/singleRefund.json");
    	connectParam.setParam(param);
        IYtBaseConnection connection = new YtStringConnection();
        connection.setConnectParam(connectParam);
        connection.post();
        log.info(connection.getResultObj()+"");
    }
    @Test
    public void testImgGet() throws Exception {
    	YtBaseConnectParam connectParam = new YtBaseConnectParam("http://pic.qiantucdn.com/58pic/15/28/06/57458PIC5Zb_1024.jpg!/fw/780/watermark/url/L3dhdGVybWFyay12MS4zLnBuZw==/align/center");
        IYtBaseConnection connection = new YtFileConnection("d:\\da.jpg");
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    @Test
    public void testFileGet() throws Exception {
    	YtBaseConnectParam connectParam = new YtBaseConnectParam("http://www.webxml.com.cn/files/WeatherWsHelp.pdf");
        IYtBaseConnection connection = new YtFileConnection("d:\\WeatherWsHelp.pdf");
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    @Test
    public void testStringGet() throws Exception{
    	YtBaseConnectParam connectParam = new YtBaseConnectParam("http://www.baidu.com");
        IYtBaseConnection connection = new YtStringConnection();
        connection.setConnectParam(connectParam);
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    @Test
    public void testStringGet2() throws Exception{
        IYtBaseConnection connection = new YtStringConnection();
        connection.setConnectParam("http://www.baidu.com");
        connection.get();
        log.info(connection.getResultObj()+"");
    }
    
    
} 
