<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<c:forEach items="${saleBooks}" var="saleBook">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/book/showBookDetails?book.id=${saleBook.id}" target='_blank'>
				<img class="imgId" src="${pageContext.request.contextPath}${saleBook.src}" border=0 /> 
			</a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/book/showBookDetails?book.id=${timeBook.id}" target="_blank">${saleBook.book_name}</a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥${saleBook.price}
		</div>
		<div class="price">
			当当价：￥${saleBook.dd_price}
		</div>
		<div class="price">
			销量：<font color="red">${saleBook.sale_count}</font>
		</div>
		
	</div>	
	<div class="book_c_xy_long"></div>
	
	</c:forEach>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>