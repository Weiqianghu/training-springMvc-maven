package com.allinpay.training.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.allinpay.training.login.bean.LoginBean;
import com.allinpay.training.login.service.ILoginService;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public String login(LoginBean loginBean, HttpServletRequest request, HttpServletResponse response) {
		int result = loginService.login(loginBean);

		JSONObject object = new JSONObject();
		object.put("status", result);
		return object.toString();
	}
}
