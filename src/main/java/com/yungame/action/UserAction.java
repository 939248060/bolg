package com.yungame.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;
import com.yungame.model.Users;
import com.yungame.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;
	
	public Users user;
	
	public List<Users> userList;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String addUser() {
		userService.add(user);
		return "addUser_main";
	}
	public String selectUser() {		
		System.out.println("selectUser执行之前");
		Users user = (Users) request.getSession().getAttribute("user");
		if(user != null) {
			this.user = userService.select(user.getId());
		}
		System.out.println("selectUser执行之后");	
		return "selectUser";
	}

	public String loginUser() {
		System.out.println(user.toString());
		List<Users> userList = userService.select(user);
		if(userList != null && userList.size() > 0) {
			request.getSession().setAttribute("user", userList.get(0));
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
			return Action.LOGIN;
		}		
		return "loginUser_main";
	}
	
	public String outloginUser() {
		request.getSession().setAttribute("user", null);
		return "outloginUser_main";
	}
	
	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user; 
	}

	public List<Users> getUserList() {
		return userList;
	}

	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	
	
}
