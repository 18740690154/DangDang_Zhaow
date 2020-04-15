<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>用户注册 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			function changeImage (){
		    	$("#imgVcode").prop("src","${pageContext.request.contextPath}/getCode?"+new Date().getTime());
			}
			$(function(){
				//检查邮箱
				  $("#txtEmail").blur(function(){ checkEmail();});
				//检查昵称
				  $("#txtNickName").blur(function(){ checkName();});
				//检查密码
				  $("#txtPassword").blur(function(){	checkPswd();});	
				//检查再次输入的密码
				  $("#txtRepeatPass").blur(function(){ checkRepswd();});	
				//检查验证码
				  $("#txtVerifyCode").blur(function(){ checkCode(); });
				//表单提交
				  $("form").submit(function(){ return checkForm();  });	 
			});
			 var chEmail =false;
			 var chName =false;
			 var chPswd =false;
			 var chRepswd =false;
			 var chCode =false;
			function checkEmail(){
				var email = $("#txtEmail").val();
				if (email=="") {
					$("#emailinfo").html("邮箱不能为空");
				}else {
					var s=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					if (s.test(email)) {
						$("#emailinfo").html("验证成功").css("color","green");
						chEmail =true;
					}else{
						$("#emailinfo").html("邮箱格式不正确");
					}
				}
			}
			function checkName(){
				var name = $("#txtNickName").val();
				if(name==""){
					$("#nameinfo").html("昵称不能为空");
				}else{
					if (name.length>=5) {
						$("#nameinfo").html("验证成功").css("color","green");
						chName="true";
					}else{
						$("#nameinfo").html("昵称长度不够，最少5位");
					}
				}
				
			}
			function checkPswd(){
				var pswd =$("#txtPassword").val();
				if (pswd=="") {
					$("#passwordinfo").html("密码不能为空");
				}else{
					if (pswd.length ==6) {
					$("#passwordinfo").html("验证成功").css("color","green");
					chPswd = true;	
					}else{
					$("#passwordinfo").html("密码长度错误");
					}
				}
			}
			function checkRepswd(){
				var repswd = $("#txtRepeatPass").val();
				if (repswd=="") {
					$("#password1info").html("密码不能为空");
				}else{
					var pswd =$("#txtPassword").val();
					if (pswd==repswd) {
						$("#password1info").html("验证成功").css("color","green");
						chRepswd =true;	
					}else{
						$("#password1info").html("两次输入的密码不一致");	
					}
				}
			}
			function checkCode(){
			    var code = $("#txtVerifyCode").val();
				if (code=="") {
					$("#numberinfo").html("验证码不能为空");
				}else{	
					if (code.length==4) {
						$("#numberinfo").html("验证成功").css("color","green");
						chCode = true;
					}else {
						$("#numberinfo").html("验证码长度不正确");
					}
					
				}
			}
			 
			function checkForm(){
				checkEmail();
				checkName();
				checkPswd();
				checkRepswd();
				checkCode();
				
				if(chEmail && chName && chPswd && chRepswd && chCode){
					return true;
				}else{
					return false;
				}
			}
		</script>
	
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>
		<div class="login_step">
			注册步骤:
			<span class="red_bold">1.填写信息</span> > 2.验证邮箱 > 3.注册成功
		</div>
		<div class="fill_message">
			<form name="ctl00" method="post"  action="${pageContext.request.contextPath}/user/regist" id="f">
				<h2>
					以下均为必填项   </br>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${message}
				</h2> 
						
				<table class="tab_login" >
					<tr>
	
						<td valign="top" class="w1">
							请填写您的Email地址：
						</td>
						<td>
						<input name="user.email" type="text" id="txtEmail" class="text_input"/>
							<div class="text_left" id="emailValidMsg">
								<p>
									请填写有效的Email地址，在下一步中您将用此邮箱接收验证邮件。
								</p>
									<span id="emailinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置您在当当网的昵称：
						</td>
						<td>
							<input name="user.nick_name" type="text" id="txtNickName" class="text_input" />
							<div class="text_left" id="nickNameValidMsg">
								<p>
									您的昵称可以由小写英文字母、中文、数字组成，
								</p>
								<p>
									长度4－20个字符，一个汉字为两个字符。
								</p>
								<span id="nameinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							设置密码：
						</td>
						<td>
							<input name="user.password" type="password" id="txtPassword" class="text_input" />
							<div class="text_left" id="passwordValidMsg">
								<p>
									您的密码可以由大小写英文字母、数字组成，长度6－20位。
								</p>
								<span id="passwordinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							再次输入您设置的密码：
						</td>
						<td>
							<input name="pswd" type="password" id="txtRepeatPass" class="text_input"/>
							<div class="text_left" id="repeatPassValidMsg">
								<p>
									请输入相同的密码	
								</p>
							<span id="password1info" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							验证码：
						</td>
						<td>
							<img class="yzm_img" id='imgVcode' src="${pageContext.request.contextPath}/getCode" onlick="changeImage()" />
							<input name="imgCode" type="text" id="txtVerifyCode" class="yzm_input"/>
							<div class="text_left t1">
								<p class="t1">
									<span id="vcodeValidMsg">请输入图片中验证码。</span>
									<span id="numberinfo" style="color:red"></span>
									<a href="javascript:changeImage()" id="changeImg">看不清楚？换个图片</a>
								</p>
							</div>
						</td>
					</tr>
				</table>

				<div class="login_in">

					<input id="btnClientRegister" class="button_1" name="submit"  type="submit" value="注 册"/>
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

