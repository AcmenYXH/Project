package com.carss.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: yangxh8
 * @Date: 2020-04-18 11:07:07
 * @Description:
 */
public class OrderUtils {

    public static String getTradeId(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        Date d1 = new Date();
        String result="";
        Random random=new Random();
        for(int i=0;i<4;i++){
            result+=random.nextInt(10);
        }
        String tradeId = newDate+result;
        return tradeId;
    }
}
