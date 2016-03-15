package com.allinpay.training.login.dao;

import com.allinpay.training.login.bean.UserBean;;

public interface UserDao {
	UserBean findByUsername(String username);
}
