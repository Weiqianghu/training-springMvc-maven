package com.allinpay.training.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.allinpay.training.global.Constant;
import com.allinpay.training.login.bean.UserBean;
import com.allinpay.training.login.dao.UserDao;
import com.allinpay.training.login.service.ILoginService;

@Service("loginService")
@Transactional
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private UserDao dao;

	public int login(UserBean userBean) {

		int result = Constant.ERROR;
		UserBean findUserBean = findUserByUsername(userBean.getUsername());

		if (findUserBean == null || !findUserBean.getPassword().equals(userBean.getPassword())) {
			result = Constant.PASSWORD_ERROR;
		} else {
			result = Constant.SUCCESS;
		}
		return result;
	}

	public UserBean findUserByUsername(String username) {
		return dao.findByUsername(username);
	}

}
