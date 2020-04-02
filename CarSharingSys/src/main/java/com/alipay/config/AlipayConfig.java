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
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016092200567084";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDORvG1I2V1zuhb6DRuKpz1pHHc58tUHnKOj58wGcfGq26k3ReOuRTKsJONcATPoqkheSo2/FJErr56cSVTOu5g6mmnOkWoGKKtwEVxY55tw68T1s28Sw4ODdCSqBrq/6heacuA7Vy6PTU+YAYULi9z7St3FxJM/kJGVJVLarY4NqDAnE2bZarBxbWc3jrL5SqT/eJ3aqv2cxDByP7qUp8DhVXvFnzvNHO4f4dixdEDO4hSNo+HpolGsTV8oO1VCBNSP3uoBAI/VxI/g8tA+Xpej8QOyAmcfsJKYmB91lMMnO1989x0INftyo5mKAHSJpsUcxqMqejuOMpixSLyEOsrAgMBAAECggEAQlIe/n097s2yeXJEATOkOXpAvaStBAOyE1Hr/ZwcViziKxGGtHWfULfLCQt+EIAc3s1FHF6t2LVSOq3MMWFeKTzU8VZT9QLOswyBhz5fPq1OyhMjHKoI/83DRJPV6759FLXxHyexy5NIXiCjc7ORwDT955E8ahLJnjEtuwy5P4MFDrVHow3LMsjt028Lup0l9FrapYMgf1QezUbmXv4+iWdvqL3HwGI1wr9Pnu+E4//C3F4P+9wuVYNUtqRVX3b51kGeFXP81/7JiFxpcvSQeG7Kw9ZtbJXsvgziy3f5Eun3VJjpz2NHhIUO6a6uEC3ubF0RB6yM+xPtRe8B7CPHCQKBgQDorewMYRqdODQFqdnR//XZr6J+r/vnv9SZ3iWwtcbwsKoA7B4pWoTnDvQCDoKFLmXGK4yZmTuBnIi522ucBZKpicg0Yh1MCoGfX/P3nBNSfJqUfe3uKKjKWEkn9YLWhNJb1aWAiTeigaMomkhi+ZOb7fj6PWPocfxyGnq26E4QZQKBgQDi85gV3+V7F/h89C9kV4htjvksix0ZG5p3NmECr5ZXeMy3MFGCXbwGb60xyXEvxaokzXbFXwErfB2xBtNFk5aW7Ws79grXJ9/2tGIvCiPL8ruemot8PARpZaft96RJF1w5o+3pg+Um5OyQo2ioGwTzYtdqqsmuaJEktbql1L6sTwKBgHbk6EkrFT5hCbQbJoJ4GFgztwSlSEMTcr9tFDVHrXAv1a7C+GaJKoAm0+h5IZiMLNUmS6Hw+scwBW1zAXmoH1kiXnrl57KDa9jUXwWXawgrQ5G9B2c6v4Ult7wDZ+fV1ue2M+uKMjOHqqeErphkj1iOMTstQ2/zTtu/TBVKfxlBAoGBAIy85MZD5yoTblwGjVEbWxYdwHWX+z5zuLFOvpAM1R1/YuwDAbjnac9P98ZVFmS6nk1eQNYamT4fJMZ/5gpSgOMtbf9sD8LnDmMN74keL56s8x5i1jb/fPjjOmU+2dkdrGpuNv5FdZhOBEmZnDALOWG5HL8gFBuc6s0qCQoHSQrPAoGBAIGIAymBS3olF9Dl+YOGW2U6OUGEKtk5OkUU69N4LhEYrRV3/u0FI31WW2ZCO+hRTTdxAto6z9gu7IIVwJRCcrKU7beOIVNB5a/9jUt03HipkJEDTDxsef+smY/Jmw40jguKVE4pcZysn2XodxTpSvOKwsGri63ZTjaT+a78ZIli";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA6NYU0CeaF/XoUT5mrRBmC10dmvKbbUeImEPdsPsJNkAkK4NwLjCXJMXWe5mh6yhvY68D3+rueK9sANBxhNQ9exB/Eb10etv40GL9YtxGwe1nSEL14jM9OLpjLNpXXMbwf19aduft5ZfmXZXZCGjZND4Bo2ZT5F6wz3KM/G4u7omOBQKce94mVsiCHA6QEZ+COhc1QFiAumtz5Ay5qRxJdfgm00WnCTSBVk7Uiq+HF7smrP+KyZVDzDmBIGzZXcQlw6aqdI7oeeDOVJx+11vyyx6GfVLAdbv1EDylGVIOPx27H6a1BUNGUt0p9FA9IuxBbp47siAF4Tz+vUzCKAKy4wIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/bikesharing/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/bikesharing/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


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

