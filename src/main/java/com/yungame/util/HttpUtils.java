package com.yungame.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpUtils {

	public static String sendPostBuffer(String url1,String JonsonObject) throws UnsupportedEncodingException, IOException {
		System.out.println(url1);
		URL url=new URL(url1);
		HttpURLConnection http = (HttpURLConnection)url.openConnection();
		http.setDoOutput(true);
		http.setDoInput(true);
		http.setRequestMethod("POST");
		http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		http.connect();
		OutputStream os = http.getOutputStream();
		os.write(JonsonObject.getBytes("UTF-8"));
		InputStream inputStream = http.getInputStream();
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String data = bufferedReader.readLine();
		while(data != null) {
			System.out.println(data);
			data += bufferedReader.readLine();
		}
		os.close();
		return data;
	}
}
