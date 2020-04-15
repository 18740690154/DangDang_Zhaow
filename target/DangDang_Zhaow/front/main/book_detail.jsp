<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<title>图书详情</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/front/css/book_detail.css"/>
		<link href="${pageContext.request.contextPath}/front/css/public_footer.css" rel="stylesheet" type="text/css" />

	</head>
	<body>
		<br/>
		<div>
			<a href="${pageContext.request.contextPath}/book/showHomePage">回到首页</a>
		
			<h1>
				丛书名：${book.book_name}
			</h1>
			<hr/>
		</div>
		<table width="80%" border="0" align="center" cellspacing="0" cellpadding="5">
			<tr>
				<td rowspan="9" width="20%" valign="top"><img src="${pageContext.request.contextPath}${book.src}" width="240px" height="340px" /></td>
				<td colspan="2">作者：${book.author}></td>
			</tr>
			<tr>
				<td colspan="2">出版社：${book.company}</td>
			</tr>
			<tr>
				
				<td>出版时间：<fmt:formatDate value="${book.publish_time}" pattern="yyyy-MM-dd"/></td>
				<td>字数：${book.word_count}</td>
			</tr>
			<tr>
				<td>版次：${book.edition}</td>
				<td>页数：${book.page_count}</td>
			</tr>
			<tr>
				<td>印刷时间：<fmt:formatDate  value="${book.print_time}" pattern="yyyy-MM-dd"/></td>
				<td>开本：${book.format}</td>
			</tr>
			<tr>
				<td>印次：${book.impression}</td>
				<td>纸张：${book.paper}</td>
			</tr>
			<tr>
				<td>ISBN：${book.isbn}</td>
				<td>销量：<font color="red">${book.sale_count}</font></td>
			</tr>
			<tr>
				<td>所属类别：<font style='color: #cc3300'><strong>${category.cate_name}	</strong>&gt;&gt;${category.category.cate_name}</font>
			</tr>
			<tr>
				<td colspan="2">定价：￥${book.price}&nbsp;&nbsp;&nbsp;&nbsp;
				<font color="red">当当价：￥${book.dd_price}</font>&nbsp;&nbsp;&nbsp;&nbsp;
				节省：￥${book.price - book.dd_price}</td>
			</tr>
			<tr>
				<td colspan="2">
					<a href="${pageContext.request.contextPath}/cart/add?book.id=${book.id}">
						<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' />
					</a>	
				</td>
			</tr>
		</table>
		<hr style="border:1px dotted #666"/>
		<h2>${book.e_recommend}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>${book.e_recommend}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>${book.author_abstract}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>${book.catalogue}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>${book.m_comments}</h2>
		<p>&nbsp;&nbsp;</p>
		<hr style="border:1px dotted #666"/>
		<h2>书摘插图</h2>
		<p>&nbsp;&nbsp;</p>
		
	
		<!--页尾开始 -->
		<div class="public_footer">
			<div class="public_footer_bottom">
				<div class="public_footer_icp" style="line-height: 48px;">
					Copyright (C) 当当网 2004-2008, All Rights Reserved
					<a href="#" target="_blank"><img src="../images/bottom/validate.gif" border="0" align="middle" /> </a>
					<a href="#" target="_blank" style="color: #666;">京ICP证041189号</a>
				</div>
			</div>
		</div>
		<!--页尾结束 -->
	</body>
</html>
