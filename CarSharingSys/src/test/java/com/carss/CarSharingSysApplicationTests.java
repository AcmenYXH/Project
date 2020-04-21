package com.carss;

import com.carss.entity.JsonResult;
import com.carss.entity.Rentinfo;
import com.carss.entity.RentinfoExample;
import com.carss.service.CarinfoService;
import com.carss.service.RentinfoService;
import com.carss.utils.OrderUtils;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarSharingSysApplicationTests {

	@Autowired
	private RentinfoService rentinfoService;
	@Autowired
	private CarinfoService carinfoService;

	@Test
	public void contextLoads() {
		File directory = new File("");//设定为当前文件夹
		try {
			System.out.println(directory.getCanonicalPath());//获取标准的路径
			String absolutePath = directory.getAbsolutePath();
			System.out.println(absolutePath);//获取绝对路径
			System.out.println(absolutePath.substring(0, absolutePath.lastIndexOf("\\")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试；订单工具类
	 * 获取商家订单号
	 */
	@Test
	public void getTradeIdTest() {
		System.out.println(OrderUtils.getTradeId());
	}

	@Test
	public void getUserRentinfoTest(){
		String isPlay="未支付";
		int userid = 2;
		int rid = 21;
		RentinfoExample rentinfoExample = new RentinfoExample();
		RentinfoExample.Criteria re = rentinfoExample.createCriteria();
		re.andUseridEqualTo(userid).andIsplayEqualTo(isPlay).andRentidEqualTo(rid);
		re.getAllCriteria().clear();
		if (isPlay != null && isPlay != ""){
			re.andIsplayEqualTo(isPlay);
		}
		re.andUseridEqualTo(userid);
		if (rid > 0){
			re.andRentidEqualTo(rid);
		}
		System.out.println(re.toString());
		System.out.println(rentinfoExample);

	}

	@Test
	public void updateNullTest(){
		Rentinfo rentinfo = new Rentinfo();
		rentinfo.setRentid(46);
		rentinfo.setIsplay("已支付");
		System.out.println("对象rentinfo");
		System.out.println(JSONObject.fromObject(rentinfo).toString());
		boolean result = rentinfoService.editRentinfo(rentinfo);
		System.out.println(result);
	}

}
