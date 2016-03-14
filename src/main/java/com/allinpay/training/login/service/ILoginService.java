package com.allinpay.training.login.service;

import org.springframework.stereotype.Service;

import com.allinpay.training.login.bean.LoginBean;

@Service
public interface ILoginService {
	int login(LoginBean loginBean);
}
