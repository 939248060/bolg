package com.yungame.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class WeixinCheckUitl {
	
	 private static final String Token = "lichaoqiang";
	 
     public static boolean checkMotend(String signature, String timestamp, String nonce) {
    	 
    	 String [] arr = new String[] {Token,timestamp,nonce};
    	 //排序
    	 Arrays.sort(arr);
    	 
    	 //拼接成字符串
    	 StringBuffer StrBuff = new StringBuffer();
    	 for (String string : arr) {
			StrBuff.append(string);
		}
    	 
    	 String sortSignature = getSha1(StrBuff.toString());
    	 if(signature.equals(sortSignature)) {
    		 return true;
    	 }else {
    		 return false;
    	 }
    
     }
     //sha1加密
     public static String getSha1(String str){
    	    if (null == str || 0 == str.length()){
    	        return null;
    	    }
    	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
    	            'a', 'b', 'c', 'd', 'e', 'f'};
    	    try {
    	        MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
    	        mdTemp.update(str.getBytes("UTF-8"));
    	         
    	        byte[] md = mdTemp.digest();
    	        int j = md.length;
    	        char[] buf = new char[j * 2];
    	        int k = 0;
    	        for (int i = 0; i < j; i++) {
    	            byte byte0 = md[i];
    	            buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
    	            buf[k++] = hexDigits[byte0 & 0xf];
    	        }
    	        return new String(buf);
    	    } catch (NoSuchAlgorithmException e) {
    	        e.printStackTrace();
    	        return null;
    	    } catch (UnsupportedEncodingException e) {
    	        e.printStackTrace();
    	        return null;
    	    }
    	}

}
