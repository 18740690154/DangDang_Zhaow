<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>登录 - 当当网</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				//检查邮箱
				$("#txtEmail").blur(function(){ checkEmail();  });
				//检查密码
				$("#txtPassword").blur(function(){ checkPassword(); });
				//表单提交
				  $("form").submit(function(){ return checkForm();  });
			});
			var chEmail = false;
			var chPswd =false;
			function checkEmail (){
				var email =  $("#txtEmail").val();
				if (email=="") {
					$("#emailinfo").html("邮箱不能为空");
				}else{
					var s=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
					if (s.test(email)) {
						$("#emailinfo").html("验证成功").css("color","green");
						chEmail =true;
					}else{
						$("#emailinfo").html("邮箱格式不正确");
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
			
			function checkForm(){
				checkEmail();
				checkPswd();
			
				if(chEmail &&  chPswd){
					return true;
				}else{
					return false;
				}
			}
			
		</script>
	</head>
	<body>
		<%@include file="../common/head1.jsp"%>

		<div class="enter_part">

			<%@include file="../common/introduce.jsp"%>

			<div class="enter_in">
				<div class="bj_top"></div>
				<div class="center">
					<div style="height: 30px; padding: 5px; color: red" id="divErrorMssage">
							<span style="color: red">${message}</span>
					</div>
					<div class="main">
						
						<h3>
							登录当当网 
						</h3>
						<form method="post" action="${pageContext.request.contextPath}/user/login" id="ctl00">
							<ul>
								<li>
									<span>请输入Email地址：</span>
									<input type="text" name="user.email" id="txtEmail" class="textbox" />
									
								</li>
								<li>
									<span id="emailinfo" style="color:red"></span> 
								</li>
								<li>
									<span class="blank">密码：</span>
									<input type="password" name="user.password" id="txtPassword" class="textbox" />
									
								</li>
								<li>
									<span id="passwordinfo" style="color:red"></span>
								</li>
								<li>
									<input type="submit" id="btnSignCheck" class="button_enter" value="登 录" />
								</li>
							</ul>
							<input type="hidden" name="uri" value="${uri}" />
						</form>
					</div>
					<div class="user_new">
						<p>
							您还不是当当网用户？
						</p>
						<p class="set_up">
							<a href="${pageContext.request.contextPath}/front/user/register_form.jsp">创建一个新用户&gt;&gt;</a>
						</p>
					</div>
				</div>
			</div>
		</div>

		<%@include file="../common/foot1.jsp"%>

	</body>
</html>

