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
	
	public String addUser() throws IOException {	
		
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
//		String realpath="\\images";
        System.out.println("realpath: "+realpath);
        String newName = System.currentTimeMillis()+"."+imageContentType.substring(imageContentType.indexOf("/")+1, imageContentType.length());
        if (image != null) {
            File savefile = new File(new File(realpath),newName );
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            FileUtils.copyFile(image, savefile);
            user.setHeadUrl(request.getContextPath()+"/images"+"/"+newName);
            ActionContext.getContext().put("message", "文件上传成功");
        }
       
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
		Users user = userService.select(this.user.getId());
		if(user != null) {
			this.user = user;
			return "editUser";
		}		
		return "editUser_main";	
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
