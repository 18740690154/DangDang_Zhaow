<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>生成订单 - 当当网</title>
		<link href="${pageContext.request.contextPath}/front/css/login.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/page_bottom.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){
				$("#address").change(function(){
					var id = $("#address").val(); 	 
					location.href="${pageContext.request.contextPath}/address/queryAddressByid?id="+id;
				});  
				
				//检查收件人姓名
				$("#receiveName").blur(function(){ checkName();  });
				//检查详细地址
				$("#fullAddress").blur(function(){ checkDetail();  });
				//检查邮政编码
				$("#postalCode").blur(function(){ checkZip();  });
				//检查电话
				$("#phone").blur(function(){ checkPhone();  });
				//提交表单
				$("form").submit(function(){ return checkForm();  });	
			});
			
			var chName =false;
			var chDetail =false;
			var chZip =false;
			var chPhone =false;
			
			function checkName(){
				var name = $("#receiveName").val();
				if (name=="") {
					$("#nameinfo").html("收件人姓名不能为空");
				}else {
					if (name.length >=2) {
						$("#nameinfo").html("验证成功").css("color","green");
						chName = true;
					}else{
						$("#nameinfo").html("收件人姓名格式不正确");
					}
				}
			}
			function checkDetail(){
				var detail =$("#fullAddress").val();
				if (detail=="") {
					$("#detailinfo").html("收件人详细地址不能为空");
				}else {
					if (detail.length >=3) {
						$("#detailinfo").html("验证成功").css("color","green");
						chDetail = true;
					}else{
						$("#nameinfo").html("收件人详细地址格式不正确");
					}
				}
			}
			
			function checkZip(){
				var zip =$("#postalCode").val();
				if (zip=="") {
					$("#zipinfo").html("收件人邮编不能为空");
				}else{
					if (zip.length==6) {
						$("#zipinfo").html("验证成功").css("color","green");
						chZip = true;
					}else{
						$("#zipinfo").html("收件人邮编长度不正确");
					}	
				}
			}
			
			function checkPhone(){
				var zip =$("#phone").val();
				if (zip=="") {
					$("#phoneinfo").html("收件人电话不能为空");
				}else{
					if (zip.length==11) {
						$("#phoneinfo").html("验证成功").css("color","green");
						chPhone = true;
					}else{
						$("#phoneinfo").html("收件人电话长度不正确");
					}	
				}
			}
			
		    function checkForm(){
		    	checkName();
		    	checkDetail();
		    	checkZip();
		    	checkPhone();
		    	if (chName && chDetail && chZip && chPhone) {
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
			生成订单骤: 1.确认订单 >
			<span class="red_bold"> 2.填写送货地址</span> > 3.订单成功
		</div>
		<div class="fill_message">
			<p>
				选择地址：
				<select id="address" name="${address.id}">
					<option value="">
						填写新地址
					</option>
					<c:forEach items="${addresses}" var="address">
						<c:if test="${address.id == id }">
							<option value="${address.id}" selected="selected" >
								${address.detail}
							</option>	
						 </c:if>
						 
						 <c:if test="${address.id != id }">
						 <option value="${address.id}">
								${address.detail}
							</option>	
						 </c:if>
					</c:forEach>
				</select>
			</p>
			<form name="ctl00" method="post" action="${pageContext.request.contextPath}/address/insertAddress" id="f">
				<input type="hidden" name="address.id" value="${address.id}"  id="addressId" />

				<table class="tab_login">
					<tr>
						<td valign="top" class="w1">
							收件人姓名：
						</td>
						<td>
							<input type="text" class="text_input" name="address.name" id="receiveName" value="${address.name}"/>
							<div class="text_left" id="nameValidMsg">
								<p>
									请填写有效的收件人姓名
								</p>
									<span id="nameinfo" style="color:red"></span>
								
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							收件人详细地址：
						</td>
						<td>
							<input type="text" name="address.detail" class="text_input" id="fullAddress" value="${address.detail}" />
							<div class="text_left" id="addressValidMsg">
								<p>
									请填写有效的收件人的详细地址
								</p>
								<span id="detailinfo" style="color:red"></span>
								
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							邮政编码
						</td>
						<td>
							<input type="text" class="text_input" name="address.zip_code" id="postalCode" value="${address.zip_code}"/>
							<div class="text_left" id="codeValidMsg">
								<p>
									请填写有效的收件人的邮政编码
								</p>
								<span id="zipinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					<tr>
						<td valign="top" class="w1">
							电话
						</td>
						<td>
							<input type="text" class="text_input" name="address.phone" id="phone" value="${address.phone}"/>
							<div class="text_left" id="phoneValidMsg">
								<p>
									请填写有效的收件人的电话
								</p>
								<span id="phoneinfo" style="color:red"></span>
							</div>
						</td>
					</tr>
					
				</table>

				<div class="login_in">
					<a href="order_info.jsp">
						<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="取消" />
					</a>			
				<input id="btnClientRegister" class="button_1" name="submit" type="submit" value="下一步" />
				</div>
			</form>
		</div>
		<%@include file="../common/foot1.jsp"%>
	</body>
</html>

