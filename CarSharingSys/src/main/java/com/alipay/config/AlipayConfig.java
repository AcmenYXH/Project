package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

    /**
     * natapp内网映射的地址
     */
    public static final String NATAPP_URL = "http://9ftk27.natappfree.cc/";

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2016102300746553";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFIfJs+ypB/sVUcrbrFYxDr/FaO4Yg1UDyZ1g1Rj2TrTaB2JTYC/N3vfy/HJZ7e+A+fokU0Ms23r0QSk7iz6ApBI1tCqE75jVTF5y86Cn1Wr+FwKGsROfel5z1UNFJlXmB0vv4kYBIha7AhGySVGbBULGFH5tHDw/QwMZPV+No5wMuGhm47X2OcENSqxxcfGfVPwKtCZR+0OlMEYGTvQ66vmFZAtKWSj5I+Pz28pwFu4/mOqtyPS+tP8F/0cjrLiyMExdqlFtAAh+fGZeEbCxSQbYmKKBPvumdjejbet8oFo2fW1zulQUvT+qZJfIQt4bEz9CEoRS964g/E7lVMaArAgMBAAECggEALZGRCPxvWmd5443gTlbxy7lNQzVck6Bquo3lA1cnfIStQ4R+bfSpQTMmb8O5PksIVlu5UAaniAB1dj35AmlOyLtmLQyWY4pIdkh+vao5smF9bKqiq/Rp6Sa78rvW5vjivi0ZUdt7rVcUmZC6GNwKz+Bu4sIOxCPDphBV0JKkpCLvsxTqzAE6SCHW06MUWkVAGxBuD9hdALnGhPEhivo7TryHTJCQU6IcIqgYXYEqnO/k1CSikL5+X69JIyrkykI864++zhxu5pDSKi98ev5qD200/10f2iz7x5PJpG0WrLSis98osHSzSPe4nRL4cN7WE/f0r80wPOXcFO3qYE6RAQKBgQDEhRW28xJi68RyY8HcNNYGzPbTpYGlwDPHgnaung+BMCwhsonKM4D5QY5wDI50e39Edi6j3X7sT2DZphl5XBY4ImjA8hJ5EhSdO+Kg/qu/0i53mJWz5plIRAese9vUayeku1P+7+37bM1TkA2+j66ZxBKQ3mMNwOtN5YebEL3lHQKBgQCtbXAkUH3of0qv0iFmKkd+PoHHrUFNxgXcDOU/1NvcUg9CGlTqBumXghKYibBjFog8DbPCUM4ounlIDPvH1MPg5mqtC7v7tWradLmgN6ig7hkJdOYyQwU+JdrDlWkMooKjCrfLX9LRi/iHdcorbQx/mH/MKPW3/dgjCXTA+yD/5wKBgBybUuHi2FZWA66zHtEzT8SFqZh9izXZmK/+KdCZaaBgpsvw9WXdwXSHOnjNGx+RqqEIoxlvcL5tf6evKh4kbYeWWrFbi5zcKOwKf57384Bk1CbMq14Yv09pt8Q/82wkfQzZyAxgWMA0wl7bpWSL/dqcVCeKd9jUsGwScX79HOdxAoGAFtOauQznJZzrhazQvJPACTvM9S02tTflOYtw+S/ZKGycmYTBvHPgdxKlw/ILh19F2zGqgV8FY5L3t6YN1cWJaqapT9GFkqHUSKCodhAdX+E25mm+issLe5yb6LZXt1QEgdU9T8VzCCW2No4oaALYbEr0NzkE7oy40BPEjEoBk+0CgYEAuRXEVIw/dS2uhbwpwALBKy9UsYdiGlIF2uXiBKgfC+7UDADGGse86r8OTyjTN3G2F0UcqmX/vAP9pmSpFk7B5JSD3wmEP+6yDxG8O6KqI9XhLaTMO5sE/z5zYfrT76LZPIvIL/3/AkTpZpZgS1FO1ACQXm3dJw+SHXxvKyHczdM=";

    /**
     * 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsUIvsRPANoE/lG5RSyFqgs/Oe8AoTbTn8E4WqgF2CP5Oyy7EVw5WHQDtW26O8bC/9FJktVtaW7K/LDTKKA2kr0ZwOnuyVPskVblUGH31O0ETBJ9HFL1nfOqbaHGLPUHlrserZxpT0LhrIyz4QLjqNM07EObKCy16e+8A08gJu6QW5UqPp30aeQg6M5Hv/F9Q7EtlZL264Tz1mi4tOnniPCCPmLnSbvi/3r4ci+IyWGspzeDaW+l3QhIk8Ccp45lusgFj26ZGg822KHN4DPAiGFl8b8bKsOrub0zxKU/tO5Ej7EnkqsmdAjval65xPyjdHmHzeAFIUce+7H6sQGcXowIDAQAB";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     *
     * 这里是使用natapp的内网映射完成回调
     */
    public static String notify_url = NATAPP_URL+"pay/notifyUrl";

    /**
     * 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
     *
     * 这里是使用natapp的内网映射完成回调
     */
    public static String return_url = NATAPP_URL+"pay/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\MyWorkSpace\\Idea";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

