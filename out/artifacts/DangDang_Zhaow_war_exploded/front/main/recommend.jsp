<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
		<!--编辑推荐图书开始-->
			<div class=second_c_02_b1>
			<c:forEach items="${randomBooks}" var="books">	
			<div class=second_c_02_b1_1>
				<a href='${pageContext.request.contextPath}/book/showBookDetails?book.id=${books.id}' target='_blank'>
					<img class="imgId"  src="${pageContext.request.contextPath}${books.src}" width="70" height="120" border=0 /> 
				</a>
			</div>
			
				<div class=second_c_02_b1_2>
				<h3>
					<a href='${pageContext.request.contextPath}/book/showBookDetails?book.id=${books.id}' target='_blank' title='输赢'>${books.book_name}</a>
				</h3>
				<h4>
					作者：${books.author} 著
					<br />
					出版社：${books.company}&nbsp;&nbsp;&nbsp;&nbsp;
					出版时间：${books.publish_time}
				</h4>
				<h5>
					简介
				</h5>
				<h6>
					定价：￥${books.price}&nbsp;&nbsp;
					当当价：￥${books.dd_price}
					销量：<font color="red">${books.sale_count }</font>
				</h6>
				<div class=line_xx></div>
			</div>
			</c:forEach>
		</div>
		<!--编辑推荐图书结束-->
	</div>
</div>
