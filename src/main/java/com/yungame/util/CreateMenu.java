package com.yungame.util;


import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yungame.model.ClickButton;
import com.yungame.model.ViewButton;


public class CreateMenu {

	public static void createMenus() {
		    ClickButton cbt = new ClickButton();
	        cbt.setKey("image");
	        cbt.setName("选取图片");
	        cbt.setType("pic_photo_or_album");
	        
	        ClickButton zyss = new ClickButton();
	        zyss.setKey("2");
	        zyss.setName("资源搜索");
	        zyss.setType("click");
	        ClickButton kezx = new ClickButton();
	        kezx.setKey("4");
	        kezx.setName("客服中心");
	        kezx.setType("click");
	        ClickButton tqcx = new ClickButton();
	        tqcx.setKey("3");
	        tqcx.setName("天气查询");
	        tqcx.setType("click");
	        
	        ClickButton cxfw = new ClickButton();
	        cxfw.setKey("1");
	        cxfw.setName("查询服务");
	        cxfw.setType("click");
	         
	         
	        ViewButton vbt = new ViewButton();
//	        http://mytest.tunnel.echomod.cn/weixin/uitlview/kuaidi.jsp
//	        https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc74299a311141859&redirect_uri="+urlEncodeUTF8("http://mytest.tunnel.echomod.cn/weixin/uitlview/kuaidi.jsp")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect 若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。 
	        vbt.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc74299a311141859&redirect_uri="+urlEncodeUTF8("http://mytest.tunnel.echomod.cn/weixin/uitlview/kuaidi.jsp")+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect 若提示“该链接无法访问”，请检查参数是否填写错误，是否拥有scope参数对应的授权作用域权限。");
	        vbt.setName("快递查询");
	        vbt.setType("view");
	         
	        JSONArray sub_button = new JSONArray();
	        sub_button.add(cbt);
	        sub_button.add(zyss);
	        sub_button.add(kezx);
	        sub_button.add(cxfw);
	        sub_button.add(tqcx);
	         
	         
	        JSONObject buttonOne = new JSONObject();
	        buttonOne.put("name", "菜单");
	        buttonOne.put("sub_button", sub_button);
	         
	        JSONArray button=new JSONArray();
	        button.add(vbt);
	        button.add(buttonOne);
	        button.add(cbt);
	         
	        JSONObject menujson=new JSONObject();
	        menujson.put("button", button);
	        System.out.println(JSON.toJSONString(menujson, SerializerFeature.DisableCircularReferenceDetect));
	        //这里为请求接口的url   +号后面的是token，这里就不做过多对token获取的方法解释
	        String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+GetAccessTokenThread.access_token.getToken();
	        //获取自定义菜单
	        System.out.println("菜单请求地址"+url);
	        String urlGet = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=mh_5gdEyulhymjUsUhx7pIOtVlgSjFFi4U0VqHiitrhKgYKdt2EXy1O_ixBH7q4OCzG7Fg6KunzZHAhduJ5upwzttjsXyrc_PXZMR-DKxQ8EIDfAIAIMH";
	        try{
	            net.sf.json.JSONObject jsonObject = WeixinUitl.doPostStr(url, JSON.toJSONString(menujson, SerializerFeature.DisableCircularReferenceDetect));
                System.out.println("菜单创建状态"+jsonObject);
	            //	            net.sf.json.JSONObject jsonObject = weixinUitl.doPostStr(urlGet, JSON.toJSONString(menujson, SerializerFeature.DisableCircularReferenceDetect));
//	            System.out.println(jsonObject.toString());
	        }catch(Exception e){
	            System.out.println("请求错误！");
	        }
	     
	        
	    }
	public static String urlEncodeUTF8(String source) {
        String result = source;
        try {
            result = java.net.URLEncoder.encode(source, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
