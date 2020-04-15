<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/btn.css" />
	
<style type="text/css">
td{
	padding-top: 8px;
}
#file_upload1 {
	display: none;
}
#file_upload1_label {
	display: inline-block;
	border: 1px solid #aaa;
	width: 120px;
	height: 145px;
	margin-left: 20px;
	text-align: center;
	line-height: 145px;
	cursor: pointer;
}
</style>


</head>

<body style="background-color: #f0f9fd;text-align: center">
	<div style="font-size:25px">修改图书信息</div>
	<hr />
	<div align="center">
	<c:forEach items="${books}" var="b">
	<form action="${pageContext.request.contextPath}/book/update?book.id=${b.id}" method="post" enctype="multipart/form-data">
			<table>
				
				<tr>
					<td>名称：</td>
					<td><input type="text" name="book.book_name" class="el-input__inner" value="${b.book_name}"></td>
					<td rowspan="14" style="width: 300px">
					<td>页数：</td>
					<td><input type="number" name="book.page_count" class="el-input__inner" value="${b.page_count}" ></td>
				</tr>
				<tr>
					<td>所属分类：</td>
					<td>
						<select name="book.cate_id" class="el-select__inner inner2">
							<c:forEach items="${categorys}" var="category">
								<c:if test="${b.cate_id eq category.id}">
									<option value="${category.id}" selected>${category.cate_name}</option>
								</c:if>
								<c:if test="${b.id  ne category.id}">
									<option value="${category.id}">${category.cate_name}</option>
								</c:if>
							</c:forEach>
						</select>
					</td>
					<td>字数：</td>
					<td><input type="number" name="book.word_count" class="el-input__inner" value="${b.word_count}" ></td>
				</tr>
				
				<tr>
					<td>原价：</td>
					<td><input type="number" name="book.price" class="el-input__inner" value="${b.price}"></td>
					<td>封面：</td>
					<td rowspan="3">
						<label id="file_upload1_label" for="file_upload1">
							<img id="uploadimg" src="${pageContext.request.contextPath}${b.src}" alt="" width="120" height="145" />
						</label> 
						<input type="file" name="file"  id="file_upload1"	onchange="upload_review()">
					</td>
				</tr>
				
				<tr>
					<td>当当价：</td>
					<td><input type=number name="book.dd_price" class="el-input__inner" value="${b.dd_price}"></td>
					<td></td>
				</tr>
				<tr>
					<td>库存：</td>
					<td><input type="number" name="book.stock_count" class="el-input__inner" value="${b.stock_count}"></td>
					<td></td>
				</tr>
				<tr>
					<td>作者：</td>
					<td><input type="text" name="book.author" class="el-input__inner" value="${b.author}"></td>
					<td>编辑推荐：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.e_recommend">${b.e_recommend}</textarea></td>
				</tr>
				<tr>
					<td>出版社：</td>
					<td><input type="text" name="book.company" class="el-input__inner" value="${b.company}"></td>
					<td></td>
				</tr>
				<tr>
					<td>出版时间：</td>
					<td><input type="date" name="book.publish_time" class="el-input__inner" value='<fmt:formatDate value="${b.publish_time}" pattern="yyyy-MM-dd"/>'></td>
					<td>内容简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.c_introduction" >${b.c_introduction}</textarea></td>
				</tr>
				<tr>
					<td>版次：</td>
					<td><input type="text" name="book.edition" class="el-input__inner" value="${b.edition}"></td>
					<td></td>
				</tr>
				<tr>
					<td>印刷时间：</td>
					<td><input type="date" name="book.print_time" class="el-input__inner" value='<fmt:formatDate value="${b.print_time}" pattern="yyyy-MM-dd"/>'/></td>
					<td>作者简介：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.author_abstract">${b.author_abstract}</textarea></td>
				</tr>
				<tr>
					<td>印次：</td>
					<td><input type="text" name="book.impression" class="el-input__inner" value="${b.impression}"></td>
					<td></td>
				</tr>
				<tr>
					<td>ISBN：</td>
					<td><input type="text" name="book.isbn" class="el-input__inner" value="${b.isbn}"></td>
					<td>基本目录：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.catalogue" >${b.catalogue}</textarea></td>
				</tr>
				<tr>
					<td>开本：</td>
					<td><input type="text" name="book.format" class="el-input__inner" value="${b.format}"></td>
					<td></td>
				</tr>
				<tr>
					<td>纸张：</td>
					<td><input type="text" name="book.paper" class="el-input__inner" value="${b.paper}"></td>
					<td>媒体评论：</td>
					<td rowspan="2"><textarea class="el-textarea__inner" name="book.m_comments">${b.m_comments}</textarea></td>
				</tr>
				<tr>
					<td>包装：</td>
					<td><input type="text" name="book.pack" class="el-input__inner" value="${b.pack}"></td>
					<td></td>
				</tr>
				
			</table>
			<input type="submit" class="button btn-p" value="提交" />&emsp; 
			<input type="button" class="button btn-p" value="返回上级" onclick="history.go(-1);" />
		</form>
		</c:forEach>
	</div>
	<script>
		function upload_review() {
			var img = document.getElementById("uploadimg");
			var input = document.getElementById("file_upload1");
			var tip = document.getElementById("uploadtip");			

			var file = input.files.item(0);
			var freader = new FileReader();
			freader.readAsDataURL(file);
			freader.onload = function(e) {
				img.src = e.target.result;
				tip.style.display = "none";
			};
		}
	</script>
</body>
</html>

