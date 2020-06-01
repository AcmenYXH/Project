package com.carss.controller;

import com.carss.entity.Depositinfo;
import com.carss.entity.DepositinfoExample;
import com.carss.entity.JsonResult;
import com.carss.service.DepositinfoService;
import com.carss.utils.OrderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @Author: yangxh8
 * @Date: 2020-04-26 15:21:57
 * @Description:
 */
@RestController
public class DepositInfoController {

    @Autowired
    private DepositinfoService depositinfoService;

    /**
     * 获取用户押金信息
     * @param userid
     * @return
     */
    @GetMapping("depositInfo")
    public JsonResult getDepositInfo(Integer userid){
        DepositinfoExample depositinfoExample = new DepositinfoExample();
        depositinfoExample.createCriteria().andUseridEqualTo(userid);
        List<Depositinfo> depositinfoList = depositinfoService.getDepositinfo(depositinfoExample);
        if (depositinfoList.size() >0){
            return new JsonResult<Depositinfo>(depositinfoList.get(0));
        }else {
            Depositinfo depositinfo = new Depositinfo();
            depositinfo.setChangeTime(new Date());
            depositinfo.setDepositStatus("000");
            depositinfo.setAmount(200D);
            return new JsonResult<Depositinfo>(depositinfo);
        }
    }
}
