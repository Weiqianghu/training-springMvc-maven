$(function() {
	$('[data-toggle="popover"]').popover()
})

function getParam() {

	var result = {};

	result["email"] = $("#inputEmail").val();
	result["password"] = $("#inputPassword").val();
	result["verifyCode"] = $("#inputVerifyCode").val();
	return result;
}

function checkParam() {

	var ret = false;
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;

	var email = $("#inputEmail").val();
	var password = $("#inputPassword").val();
	var verifyCode = $("#inputVerifyCode").val();
	if (email == undefined || email == '') {
		alert("邮箱不能为空！！！");
		return ret;
	}
	if (!reg.test(email)) {
		alert('邮箱格式不正确,请重新填写!');
		return false;
	}
	if (password == undefined || password == '') {
		alert("密码不能为空！！！");
		return ret;
	}
	if (password.length < 6) {
		alert("密码长度不能小于6位！！！");
		return ret;
	}
	if (verifyCode == undefined || verifyCode == '') {
		alert("验证码不能为空！！！");
		return ret;
	}
	return true;
}

function login() {
	if (!checkParam()) {
		return;
	}
	var jsonObj = getParam();
	// var jsonStr = JSON.stringify(jsonObj);
	$.ajax({
		url : "login",
		type : 'POST',
		data : // "username="+jsonObj["email"]+"&password="+jsonObj["password"]+"&verifyCode="+jsonObj["verifyCode"],
		{
			username : jsonObj["email"],
			password : jsonObj["password"],
			verifyCode : jsonObj["verifyCode"]

		},

		dataType : 'json',
		success : function(data) {
			var data = eval(data);
			if (data.status == 0) {
				alert("登陆成功");
			} else if (data.status == '1') {
				alert("登陆发生错误错误");
			} else if (data.status == '2') {
				// ShowFailure("验证码错误");
				alert("密码错误");
			} else if (data.status == 3) {
				// ShowFailure("验证码错误");
				alert("验证码错误");
			}
		}
	});

}