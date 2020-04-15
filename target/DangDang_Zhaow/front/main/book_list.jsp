<%@page contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/front/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/front/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/prototype-1.6.0.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/front/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
		$(function(){			
			$(".imgId").mouseover(function(e){
			//1.获取图片大小
			var width = this.width;
			var height = this.height;
				
			//2.获取鼠标的当前位置
			var x = e.pageX + 10;
			var y = e.pageY + 10;
				
			//3.创建一个div
			var div = $("<div id='bigImg'/>").css({
				"position":"absolute",
				"width":width * 3,
				"height":height * 3,
				"top":y,
				"left":x,
				"display":"none",
				"border":"5px solid orange",
				"border-radius" : "15px"
			});
		 //4.创建一个img
			var img = $("<img/>").attr({
				"src":this.src
				}).css({
				"width":width * 3,
				"height":height * 3,		
				"border-radius" : "12px"
			});
		
		  //5.将img放到div当中
			div.append(img);
			
		  //6.将div放入到body中
			$("body").append(div);
			
		  //7.将img展示出来
				div.show(1000);
				}).mousemove(function(e){
				//获取鼠标当前的位置
				var x = e.pageX + 10;
				var y = e.pageY + 10;
				//改变div的位置
				$("#bigImg").css({
				"top":y,
				"left":x
			});
			}).mouseout(function(){
				$("#bigImg").remove();
			});
		});
			 
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
				
		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/front/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<div class='your_position'> 
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/book/showHomePage'>当当图书</a> &gt;&gt;
				<font style='color: #cc3300'><strong>${category.cate_name}</strong> </font>
					<c:forEach items="${category.categorys}" var="cate" >
						<c:if test="${cid == cate.id}">
							&gt;&gt;<font style='color: #cc3300'><strong>${cate.cate_name}</strong> </font>
						</c:if>
					</c:forEach>
							
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<c:if test="${cid==null}">&middot;	
											<a href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}"> 	
										 		&nbsp;<font style='color: #cc3300'><strong>全部(${category.count})</strong></font>&nbsp;	
											</a>&nbsp;	
										</c:if>	
										<c:if test="${cid!=null}">&middot;	
											<a href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}"> 	
										 		&nbsp;全部(${category.count})&nbsp;
											</a>&nbsp;	
										</c:if>		
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类开始-->
							<c:forEach items="${category.categorys}" var="c">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href="${pageContext.request.contextPath}/book/showCateBook?fid=${c.parent_id}&cid=${c.id}">
											<c:if test="${cid==null}">
											 	${c.cate_name}(${c.count})&nbsp;
											</c:if>
											<c:if test="${cid!=null}">   
												<c:if test="${cid ==c.id}">
													 <font style='color: #cc3300'><strong>${c.cate_name}(${c.count})&nbsp;</strong> </font>	
												</c:if>
												<c:if test="${cid !=c.id}">
													 ${c.cate_name}(${c.count})&nbsp;	
												</c:if>	
											</c:if>
										</a>			
									</div>
								</div>
							</li>	
							
							<div class="clear"></div>
							</c:forEach>
							
							<!--2级分类结束-->	
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">
				
				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='' name='select_order' size='1'
							class='list_r_title_ml'>
							<option value="">
								按上架时间 降序
							</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

						<!--分页导航开始-->
						<c:if test="${cid==null}">
								<!-- 首页 -->
							<div class='list_r_title_text3a'>
								<c:if test="${page==1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' /> 
								</c:if>
								<c:if test="${page!=1}">
									<a name='link_page_next' href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&page=1">
										<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
									</a>
								</c:if>
							</div>
								<!--下一页 -->	
							<div class='list_r_title_text3a'>
								<c:if test="${page==1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
								</c:if>
								<c:if test="${page!=1}">
									<a name='link_page_next' href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&page=${page-1}">
										<img src='${pageContext.request.contextPath}/front/images/page_up.gif' />
									</a>
								</c:if>
								
							</div>
				
							<div class='list_r_title_text3b'>
								第${page}页/共${pageCount}页
							</div>
							<!-- 下一页 -->
							<div class='list_r_title_text3a'>
								<c:if test="${page==pageCount}">
									<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' /> 
								</c:if>
								<c:if test="${page!=pageCount}">
									<a name='link_page_next'  href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&page=${page+1}">
										<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
									</a>
								</c:if>
							</div>
							
							<!-- 尾页 -->
							<div class='list_r_title_text3a'>
								<c:if test="${page==pageCount}">
									<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />								
								</c:if>	
								<c:if test="${page!=pageCount}">
									<a name='link_page_next'  href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&page=${pageCount}">
										<img src='${pageContext.request.contextPath}/front/images/page_down.gif' />
									</a>
								</c:if>
							</div>
					</c:if>
					<c:if test="${cid!=null}">
						<!-- 首页 -->
						<div class='list_r_title_text3a'>
							<c:if test="${page==1}">
								<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' /> 
							</c:if>
							<c:if test="${page!=1}">
								<a name='link_page_next' href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&cid=${cid}&page=1">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' /> 
								</a>
							</c:if>
						</div>
						<!--下一页 -->	
						<div class='list_r_title_text3a'>
							<c:if test="${page==1}">
								<img src='${pageContext.request.contextPath}/front/images/page_up_gray.gif' />
							</c:if>
							<c:if test="${page!=1}">
								<a name='link_page_next' href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&cid=${cid}&page=${page-1}">
									<img src='${pageContext.request.contextPath}/front/images/page_up.gif' />
								</a>
							</c:if>
								
						</div>
				
						<div class='list_r_title_text3b'>
							第${page}页/共${pageCount}页
						</div>
						<!-- 下一页 -->
						<div class='list_r_title_text3a'>
							<c:if test="${page==pageCount}">
								<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' /> 
							</c:if>
							<c:if test="${page!=pageCount}">
								<a name='link_page_next'  href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&cid=${cid}&page=${page+1}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' /> 
								</a>
							</c:if>
						</div>
							
						<!-- 尾页 -->
						<div class='list_r_title_text3a'>
							<c:if test="${page==pageCount}">
								<img src='${pageContext.request.contextPath}/front/images/page_down_gray.gif' />								
							</c:if>	
							<c:if test="${page!=pageCount}">
								<a name='link_page_next'  href="${pageContext.request.contextPath}/book/showCateBook?fid=${category.id}&cid=${cid}&page=${pageCount}">
									<img src='${pageContext.request.contextPath}/front/images/page_down.gif' />
								</a>
							</c:if>
						</div>
					</c:if>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<c:forEach items="${books}" var="b">
						<div class="list_r_line"></div>
						<div class="clear"></div>
							<div class="list_r_list">
								<span class="list_r_list_book">
									<a name="link_prd_img" href='${pageContext.request.contextPath}/book/showBookDetails?book.id=${b.id}'>
										<img class="imgId" src="${pageContext.request.contextPath}${b.src}" height=110px;/> 
									</a>
								</span>
								<h2>
									<a name="link_prd_name" href='${pageContext.request.contextPath}/book/showBookDetails?book.id=${b.id}'>${b.book_name}</a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'>${b.author }</a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>${b.company }</a>
								</h4>
								<h4>
									出版时间：<fmt:formatDate value="${b.publish_time}" pattern="yyyy-MM-dd"/> 
								</h4>
								<h5>
									${b.c_introduction}
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥${b.price}</span>
									<span class="red">￥${b.dd_price}</span>
									节省：￥${b.price - b.dd_price}
								</h6>
								<span class="list_r_list_button"> 
								<a href="${pageContext.request.contextPath}/cart/add?book.id=${b.id}"> 
									<img src='${pageContext.request.contextPath}/front/images/buttom_goumai.gif' /> 
								</a>
								<span id="cartinfo"></span>
							</div>
						<div class="clear"></div>
							</c:forEach>
						<!--商品条目结束-->
							
					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->
			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
