package com.yungame.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class AddKefu {

	private static final String url = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ofKkdqC3elGne4X48lp4JIc5S1QL6ZhBYPBa_InRvmmdWkZeJ4Bmn8PMZL2FAzDSwNaWxRywCfThi_-n1DaonxEeB0wAMuRZlSyxbIeSkt3OHlUu9vKMeLzmCUZuNcd9NEXeAJAIZS";
	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
	   String kefu = "{\r\n" + 
	   		"     \"kf_account\" : \"ll10180427@gh_12465807893c\",\r\n" + 
	   		"     \"nickname\" : \"客服1\",\r\n" + 
	   		"}";
	   String result = SendHttp.sendPost(url, kefu);

	   System.out.println("返回的字符串"+result);
	}

}
