package cn.baizhi.zw.service;

import java.util.List;

import cn.baizhi.zw.entity.Book;

public interface BookService {
	// 后台: 展示所有的图书
	List<Book> showAll(Book book);

	// 后台:添加图书
	void insertBook(Book book);

	// 后台: 修改图书的信息
	void updateBook(Book book);

	// 后台: 删除图书
	void deleteBook(Book book);

	// 前台:根据销量排序后查讯图书
	List<Book> queryBooksBySale();

	// 前台:随机查询图书
	List<Book> queryBooksRandom();

	// 前台:根据销量和上架时间查询图书
	List<Book> queryBooksBySaleAndPTime();

	// 前台:根据上架时间查询图书
	List<Book> queryBooksByPTime();

	// 前台:根据类别id查询图书(分页)
	List<Book> queryBooksByCate(String fid, String cid, Integer page);

	// 前台:根据类别id查询图书(求出总页数)
	Integer queryBookPageCount(String fid, String cid);
}
