package com.gys.sm.item.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;
/**
 * 不同项目之间的http调用,
 * 通过调用httpPost和httpGet方法实现
 * @author gys
 *
 */
public class HttpClientUtils {
    /**
     * post请求
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static JSONObject httpPost(String url,JSONObject jsonParam){
        //post请求返回结果
    	CloseableHttpClient httpClient = HttpClients.createDefault();  
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(),"utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
            url = URLDecoder.decode(url, "UTF-8");
            int status=result.getStatusLine().getStatusCode();
            /**请求发送成功，并得到响应**/
            if (status== HttpStatus.SC_OK) {
                String str = "";
                    /**读取服务器返回过来的json字符串数据**/
                    str = EntityUtils.toString(result.getEntity());
                    /**把json字符串转换成json对象**/
                    jsonResult = JSONObject.fromObject(str);
            }else {
                System.out.println("post请求提交失败:" + url+";错误状态:"+status);
            }
        } catch (IOException e) {
        	System.out.println("post请求提交失败:" + url);
        	e.printStackTrace();
        }
        return jsonResult;
    }
 
 
    /**
     * 发送get请求
     * @param url    路径
     * @return
     */
    public static JSONObject httpGet(String url){
        //get请求返回结果
        JSONObject jsonResult = null;
        try {
        	CloseableHttpClient httpClient = HttpClients.createDefault();  
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            int status=response.getStatusLine().getStatusCode();
            /**请求发送成功，并得到响应**/
            if ( status== HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity());
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.fromObject(strResult);
                url = URLDecoder.decode(url, "UTF-8");
            } else {
                System.out.println("get请求提交失败:" + url+";错误状态:"+status);
            }
        } catch (IOException e) {
        	System.out.println("get请求提交失败:" + url);
        	e.printStackTrace();
        }
        return jsonResult;
    }
    
    /**
     * demo
     * @param args
     */
    public static void main(String[] args) {
    	Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "ssssssssssssssss");
		map.put("age", 26);
		/**
		 * 发送post请求和get请求;
		 * 接收方式参考gys中的GysAcceptHttpClient.java类
		 */
		JSONObject res1=httpPost("http://192.168.6.234:8080/sm/httpClient/post.do", JSONObject.fromObject(map));
		JSONObject res2=httpGet("http://192.168.6.234:8080/sm/httpClient/get.do?name=gys&age=26");
		System.out.println(res1.toString());
		System.out.println(res2.toString());
	}
    
    
}
