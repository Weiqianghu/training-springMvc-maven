package com.allinpay.training.login.dao;

import org.springframework.stereotype.Repository;

import com.allinpay.training.login.bean.UserBean;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<String, UserBean> implements UserDao {

	public UserBean findByUsername(String username) {
		return getByKey(username);
	}

}
