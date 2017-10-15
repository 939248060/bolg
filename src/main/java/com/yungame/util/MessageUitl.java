package com.yungame.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;

import com.yungame.model.*;
import net.sf.json.JSONObject;

public class MessageUitl {
	
	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_SHORTVIDEO = "shortvideo";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVENT = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	
	
	/*
	 * xml转换为Map类型
	 */
	public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		
	    Map<String ,String> map = new HashMap<String ,String>();
		
		SAXReader reader = new SAXReader();
		
		InputStream inputStream = request.getInputStream();
		
		Document document = reader.read(inputStream);
		
		Element element = document.getRootElement();
		
		List<Element> elements = element.elements();
		
		for (Element e : elements) {
			map.put(e.getName(),e.getText());
		}
		inputStream.close();
		
		return map;
	}
	
	/*
	 * 把List类型转换为XML
	 */
	public static String textMessagesToXML(TextMessages textMessages) {
		
		XStream xStream = new XStream();
		xStream.alias("xml", textMessages.getClass());
		System.out.println(xStream.toXML(textMessages));
		return xStream.toXML(textMessages);
	}
	
	public static String voiceMessagesToXML(VoiceMessages voiceMessages) {

		XStream xStream = new XStream();
		xStream.alias("xml", voiceMessages.getClass());
		System.out.println(xStream.toXML(voiceMessages));
		return xStream.toXML(voiceMessages);
	}

	public static String imageMessagesToXML(ImageMessages imageMessages) {

		XStream xStream = new XStream();
		xStream.alias("xml", imageMessages.getClass());
		System.out.println(xStream.toXML(imageMessages));
		return xStream.toXML(imageMessages);
	}

	/*
	 * 初始化内容
	 */
	public static String initText(String toUserName, String fromUserName, String content) {
		TextMessages textMessages = new TextMessages();
		textMessages.setContent(content);
		textMessages.setCreateTime(System.currentTimeMillis());
		textMessages.setMsgType(MESSAGE_TEXT);
		textMessages.setFromUserName(toUserName);
		textMessages.setToUserName(fromUserName);
		return MessageUitl.textMessagesToXML(textMessages);
	}
	
	/*
	 * 菜单列表
	 */
	public static String MenuText() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("欢迎关注本订阅号，订阅提供服务如下：\n\n");
		strBuff.append("1.查询服务\n");
		strBuff.append("2.资源搜索服务\n");
		strBuff.append("3.天气查询\n");
		strBuff.append("4.客服中心\n\n");
		strBuff.append("回复？查看菜单\n");
		return strBuff.toString();
	}

	/*
	 * 查询服务
	 */
	public static String firstMenu() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("查询服务\n");
		return strBuff.toString();
	}
	/*
	 * 资源搜索服务
	 */
	public static String secondMenu() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("资源搜索服务\n");
		return strBuff.toString();
	}
	/*
	 * 天气查询
	 */
	public static String thiretMenu(String city) {
		String result = SendHttp.doGet("http://www.sojson.com/open/api/weather/json.shtml","?city="+city);
        JSONObject jsonObject = JSONObject.fromObject(result);
        StringBuffer strbuff = new StringBuffer();
        JSONObject data = jsonObject.getJSONObject("data");
        
		if (data.size() > 0) {
			System.out.println("data的值"+data.toString());
			net.sf.json.JSONArray forecast = data.getJSONArray("forecast");
			String date = (String) jsonObject.getString("date");
			System.out.println("date的值"+date);
			strbuff.append("天气预报\n");
			strbuff.append("时间：" + date.substring(0,4)+"年" + date.substring(4,6)+"月"+ date.substring(6,8)+"日"+ "\n");
			strbuff.append("城市：" + jsonObject.getString("city") + "\n");
			strbuff.append("湿度：" + data.getString("shidu") + "\n");
			if (data.toString().indexOf("pm25") != -1) {
				strbuff.append("PM2.5：" + data.getString("pm25") + "\n");
				strbuff.append("空气质量：" + data.getString("quality") + "\n");
			}
			strbuff.append("温度：" + data.getString("wendu") + "℃\n\n\n");
			for (Object object : forecast) {
				JSONObject jb = (JSONObject) object;
				strbuff.append(jb.get("date") + "天气情况：\n");
				strbuff.append("日出时间：" + jb.get("sunrise") + "\n");
				strbuff.append("日落时间：" + jb.get("sunset") + "\n");
				strbuff.append(jb.get("high") + "\n");
				strbuff.append(jb.get("low") + "\n");
				strbuff.append(""+jb.get("fx") + "  " + jb.get("fl") + " \n");
				strbuff.append("天气情况：" + jb.get("type") + "\n");
				strbuff.append("温馨提示：" + jb.get("notice") + "\n\n");
			}
		}else {
			strbuff.append("你输入的内容有误！！");
		}
         
    	System.out.println(strbuff);
    	return strbuff.toString();
	}
	
	/*
	 * 客服中心
	 */
	public static String fourMenu() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("客服中心\n");
		return strBuff.toString();
	}

	/*
	 * 初始化图片
	 */
	public static String initImage(String toUserName,String fromUserName) {
		ImageMessages imageMessages = new ImageMessages();
		Image image = new Image();
		image.setMediaId("XBi4arvC5rqssvQAU4NrIfqL0k9wDGo_k77PJGsw9PBVd5GqqdgKrQ7uFVRfjWSM");
		imageMessages.setFromUserName(toUserName);
		imageMessages.setToUserName(fromUserName);
		imageMessages.setMsgType(MESSAGE_IMAGE);
		imageMessages.setCreateTime(System.currentTimeMillis());
		imageMessages.setImage(image);
		return MessageUitl.imageMessagesToXML(imageMessages);
	}
	/*
	 * 初始化图片
	 */
	public static String initImage(String toUserName,String fromUserName,String MediaId) {
		ImageMessages imageMessages = new ImageMessages();
		Image image = new Image();
		image.setMediaId(MediaId);
		imageMessages.setFromUserName(toUserName);
		imageMessages.setToUserName(fromUserName);
		imageMessages.setMsgType(MESSAGE_IMAGE);
		imageMessages.setCreateTime(System.currentTimeMillis());
		imageMessages.setImage(image);
		return MessageUitl.imageMessagesToXML(imageMessages);
	}
	/*
	 * 初始化语音
	 */
	public static String initVoice(String toUserName,String fromUserName,String MediaId) {
		VoiceMessages voiceMessage = new VoiceMessages();
		Voice voice = new Voice();
		voice.setMediaId(MediaId);
		voiceMessage.setFromUserName(toUserName);
		voiceMessage.setToUserName(fromUserName);
		voiceMessage.setMsgType(MESSAGE_VOICE);
		voiceMessage.setCreateTime(System.currentTimeMillis());
		voiceMessage.setVoice(voice);
		return MessageUitl.voiceMessagesToXML(voiceMessage);
	}
}
