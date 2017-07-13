package com.yt.tool.utils;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * inputStream流处理方法
 * @author crwua
 *
 */
public class In2ResultUtils {

	/**
	 * in流转string
	 * @param in
	 * @param charsetCode
	 * @return
	 * @throws Exception
	 */
	public static String in2String(InputStream in,String charsetCode) throws Exception{
		BufferedReader br = null;
		try{
			String result = "";
			br = new BufferedReader(new InputStreamReader(in,
					charsetCode ));
			String line;
			while ((line = br.readLine()) != null) {
				result += line + "\n";
			}
			return result;
		}catch(Exception e){
			throw e;
		}finally{
			//当br关闭，in也会关闭，不过还是一个个的来
			if(br != null){
				br.close();
			}
			if(in != null){
				in.close();
			}
		}
		
		
	}
	/**
	 * in流转文件，且自动关闭
	 * @param inputStream
	 * @param filePath
	 * @throws Exception
	 */
	public static void in2File(InputStream inputStream , String filePath ) throws Exception{
		in2File(inputStream,filePath,true);
	}
	
	/**
	 * in流转File，参数决定是否关闭in流
	 * @param inputStream
	 * @param filePath
	 * @param autoClose 自动关闭in流
	 * @throws Exception
	 */
	public static void in2File(InputStream inputStream , String filePath , boolean autoClose) throws Exception{
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(filePath);
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);

			}
		} catch (Exception e) {
			throw e;
		} finally {

			if (autoClose && inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
	
	
}
