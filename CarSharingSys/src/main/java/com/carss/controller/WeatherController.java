package com.carss.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carss.service.WeatherService;

import net.sf.json.JSONObject;

@RestController
public class WeatherController {
	@Autowired
	private WeatherService weatherService;

	@PostMapping("weather")
	public Map<String,Object> show(String usercity) {
		System.out.println("usercity:"+usercity);
		JSONObject obj=weatherService.showWeather(usercity);
		System.out.println(obj);
		Map<String,Object> map=new HashMap<String, Object>();
		String result=obj.getString("resultcode");
		System.out.println("连接状况码："+result);
		/*如果状态码是200说明返回数据成功*/
		if(result!=null&&result.equals("200")){
			result=obj.getString("result");
			System.out.println(result);
			//此时result中数据有多个key,可以对其key进行遍历,得到对个属性
			obj=JSONObject.fromObject(result);
			System.out.println(obj);
			//今日温度对应的key是today
			result=obj.getString("today");
			System.out.println(result);
			obj=JSONObject.fromObject(result);
			System.out.println(obj);
			//今日温度对应当key是temperature
			System.out.println("对应城市："+obj.getString("city"));
			System.out.println("今日温度:"+obj.getString("temperature"));
			System.out.println("天气更新于"+obj.getString("date_y"));
			System.out.println("今日是"+obj.getString("week"));
			System.out.println("今日天气:"+obj.getString("weather"));
			map.put("weather",obj.getString("city")+"\t\t今日天气:\t"+obj.getString("weather")+"\t\t"+obj.getString("temperature"));
			System.out.println("今日风向;"+obj.getString("wind"));
			System.out.println("洗澡指数:"+obj.getString("dressing_index"));
			map.put("uv_index", "紫外线强度:\t"+obj.getString("uv_index"));
			System.out.println("洗澡建议:"+obj.getString("dressing_advice"));
			System.out.println("太阳紫外线强度:"+obj.getString("uv_index"));
			System.out.println("游泳指数:"+obj.getString("wash_index"));
			System.out.println("出外旅游指数："+obj.getString("travel_index"));
			map.put("travel_index", "出外指数:\t"+obj.getString("travel_index"));
		 	System.out.println("晨练建议："+obj.getString("exercise_index"));
		   }
		return map;

	}
	
}
