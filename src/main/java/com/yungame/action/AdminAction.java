package com.yungame.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class AdminAction extends ActionSupport {

	public String adminMess() {
		System.out.println("后台方法执行了");
		return "adminMess";
	}
}
