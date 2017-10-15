package com.yungame.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.yungame.model.Users;

public class UserInterceptor extends MethodFilterInterceptor {

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Users user = (Users) invocation.getInvocationContext().getSession().get("user");
		if(user == null) {
			System.out.println("校验失败");
			return Action.LOGIN;
		}
		System.out.println("校验成功");
		return invocation.invoke();
	}

}
