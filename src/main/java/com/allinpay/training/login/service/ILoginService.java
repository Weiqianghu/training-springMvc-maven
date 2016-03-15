package com.allinpay.training.login.service;

import org.springframework.stereotype.Service;

import com.allinpay.training.login.bean.UserBean;

@Service
public interface ILoginService {
	int login(UserBean userBean);

	UserBean findUserByUsername(String username);
}
