package com.allinpay.training.global.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUtil {
	public static boolean verifyEmail(String email) {
		boolean isExist = false;

		Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Matcher m = p.matcher(email);
		boolean b = m.matches();
		if (b) {
			isExist = true;
		} else {
		}
		return isExist;
	}
}
