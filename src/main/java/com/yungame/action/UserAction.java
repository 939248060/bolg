package com.yungame.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;
import com.yungame.model.Users;
import com.yungame.service.UserService;
import com.yungame.util.UploadUitl;

@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@Autowired  
	private UserService userService;
	
	public Users user;
	
	public List<Users> userList;
	
	private File image; //上传的文件
    private String imageFileName; //文件名称
    private String imageContentType; //文件类型
    
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String addUser(){
		user.setHeadUrl(UploadUitl.uploadPic(request, image, imageFileName, imageContentType)); 
		userService.add(user);
		return "addUser_main";
	}
	public String selectUser() {		
		Users user = (Users) request.getSession().getAttribute("user");
		if(user != null) {
			this.user = userService.select(user.getId());
		}
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
		request.getSession().removeAttribute("user");
		return "outloginUser_main";
	}
	
	public String editUser() {
		Users u = (Users) request.getSession().getAttribute("user");
		Users user = userService.select(u.getId());
		if(user != null) {
			this.user = user;
			return "editUser";
		}		
		return "editUser_main";	
	}
	
	public String updateUser() {
		Users u = (Users) request.getSession().getAttribute("user");
		Users user = userService.select(u.getId());
		user.setAddress(this.user.getAddress());
		if(image != null && imageFileName != null && imageContentType != null)
		user.setHeadUrl(UploadUitl.uploadPic(request, image, imageFileName, imageContentType));
		user.setJob(this.user.getJob());
		user.setTel(this.user.getTel());
		user.setMail(this.user.getMail());
		user.setSex(this.user.getSex());
		user.setMotto(this.user.getMotto());
		int isUpdate = userService.update(user);
		if (isUpdate == 1) {
			return "updateUser_UserInfos";
		}
		return "updateUser_main";
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
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	
	
}
