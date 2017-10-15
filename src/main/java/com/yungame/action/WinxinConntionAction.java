package com.yungame.action;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.yungame.util.CreateMenu;
import com.yungame.util.GetAccessTokenThread;
import com.yungame.util.WeixinCheckUitl;

@Controller
@Scope("prototype")
public class WinxinConntionAction extends ActionSupport {

	private String signature;
	private String timestamp;
	private String nonce;
	private String echostr;
	
   public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

public String checkWeixin() {
		if(WeixinCheckUitl.checkMotend(signature, timestamp, nonce)) {
		
			System.out.println("校验成功");
			GetAccessTokenThread getAccessTokenThread = new GetAccessTokenThread();
			new Thread(getAccessTokenThread).start();
			try {
				Thread.sleep(10000);
				CreateMenu.createMenus();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	   return echostr;
   }
}
