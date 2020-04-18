package com.carss;

import com.carss.utils.OrderUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarSharingSysApplicationTests {

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

}
