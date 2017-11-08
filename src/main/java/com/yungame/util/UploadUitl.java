package com.yungame.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.yungame.model.Users;

public class UploadUitl {

	public static String uploadPic(HttpServletRequest request ,File image , String imageFileName, String imageContentType) {
		String realpath = ServletActionContext.getServletContext().getRealPath("/images");
        //D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
//		String realpath="\\images";
        System.out.println("realpath: "+realpath);
        String newName = System.currentTimeMillis()+"."+imageContentType.substring(imageContentType.indexOf("/")+1, imageContentType.length());
        if (image != null) {
            File savefile = new File(new File(realpath),newName );
            if (!savefile.getParentFile().exists())
                savefile.getParentFile().mkdirs();
            try {
				FileUtils.copyFile(image, savefile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            ActionContext.getContext().put("message", "文件上传成功");
            return request.getContextPath()+"/images"+"/"+newName;
        }
		return "";
		
	}
}
