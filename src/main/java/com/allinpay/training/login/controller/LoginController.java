package com.allinpay.training.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.allinpay.training.global.Constant;
import com.allinpay.training.global.util.InputUtil;
import com.allinpay.training.login.bean.UserBean;
import com.allinpay.training.login.service.ILoginService;
import com.allinpay.training.login.service.RandomValidateCode;

@Controller
public class LoginController {

	@Autowired
	private ILoginService loginService;

	@ResponseBody
	@RequestMapping(value = "/login")
	public String login(UserBean userBean, HttpServletRequest request, HttpServletResponse response) {
		int result = Constant.ERROR;

		if (null == userBean.getUsername() || "" == userBean.getUsername() || null == userBean.getPassword()
				|| "" == userBean.getPassword() || null == userBean.getVerifyCode()
				|| null == userBean.getVerifyCode()) {
			result = Constant.ERROR;
		} else if (!InputUtil.verifyEmail(userBean.getUsername())) {
			result = Constant.ERROR;
		} else if (!RandomValidateCode.getVerifyCode().toLowerCase().equals(userBean.getVerifyCode())) {
			result = Constant.VERIFY_CODE_ERROR;
		} else {
			result = loginService.login(userBean);
		}

		JSONObject object = new JSONObject();
		object.put("status", result);
		return object.toString();
	}
}
