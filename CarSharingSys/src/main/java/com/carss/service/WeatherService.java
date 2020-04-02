package com.carss.service;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-04 21:42:56
 * @description: 天气服务
 */
@Service
public class WeatherService {

    /**
     * 显示天气
     * @return 返回JSONObject对象
     */
    public JSONObject showWeather(String usercity) {
        // TODO Auto-generated method stub
        String charset ="UTF-8";
//        String citynames = "揭阳";
        //appkey
//        String urlname="http://v.juhe.cn/weather/index?format=2&cityname=%E5%8E%A6%E9%97%A8&key=ff59f5169a3ad9990f41c24cd8d05748";
//        可用链接
//        String urlname="http://v.juhe.cn/weather/index?format=2&cityname="+usercity+"&key=dc8ad03947d7bfc9cc347a805dddc41a";
        String urlname="http://v.juhe.cn/weather/index?format=2&cityname="+usercity+"&key=ff59f5169a3ad9990f41c24cd8d05748";
        //得到JSON字符串
        String jsonResult = get(urlname, charset);
        return JSONObject.fromObject(jsonResult);
    }
    /**
     *
     * @param urlAll:请求接口
     * @param charset:字符编码
     * @return 返回json结果
     */
    public String get(String urlAll,String charset){
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        //模拟浏览器
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
        try {
            URL url = new URL(urlAll);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(30000);
            connection.setConnectTimeout(30000);
            connection.setRequestProperty("User-agent",userAgent);
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(
                    is, charset));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
