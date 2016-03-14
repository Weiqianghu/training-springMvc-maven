package com.allinpay.training.login.service.impl;

import org.springframework.stereotype.Service;

import com.allinpay.training.global.Constant;
import com.allinpay.training.global.util.InputUtil;
import com.allinpay.training.login.bean.LoginBean;
import com.allinpay.training.login.service.ILoginService;
import com.allinpay.training.login.verifycode.RandomValidateCode;

@Service("loginService")
public class LoginServiceImpl implements ILoginService {

	public int login(LoginBean loginBean) {

		int result = Constant.ERROR;

		if (null == loginBean.getUsername() || "" == loginBean.getUsername() || null == loginBean.getPassword()
				|| "" == loginBean.getPassword() || null == loginBean.getVerifyCode()
				|| null == loginBean.getVerifyCode()) {
			result = Constant.ERROR;
			return result;
		}

		if (!InputUtil.verifyEmail(loginBean.getUsername())) {
			result = Constant.ERROR;
		} else if (!RandomValidateCode.getVerifyCode().toLowerCase().equals(loginBean.getVerifyCode())) {
			result = Constant.VERIFY_CODE_ERROR;
		} else {
			result = Constant.SUCCESS;
		}
		return result;
	}

}
