package com.yungame.util;

import com.yungame.model.AccessToken;
import net.sf.json.JSONObject;

public class GetAccessTokenThread implements Runnable {

	public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

	public static final String AppID = "wxc74299a311141859";

	public static final String AppSecret = "c187763f4d30c9b520a431c660339b00";

	public static AccessToken access_token = new AccessToken();

	
	public void run() {
		while (true) {
			try {
				String url = ACCESS_TOKEN_URL.replace("APPID", AppID).replaceAll("APPSECRET", AppSecret);
				String jsonString = SendHttp.doGet(url, "");
				System.out.println("access_token的值" + jsonString);
				JSONObject jsonObject = JSONObject.fromObject(jsonString);
				System.out.println(url);
				access_token.setToken(jsonObject.getString("access_token"));
				access_token.setExpires(Integer.parseInt(jsonObject.getString("expires_in")));
				System.out.println("获取access_token成功！！");
				Thread.sleep(7200000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
