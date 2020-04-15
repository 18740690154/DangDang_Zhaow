package cn.baizhi.zw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;

public interface BookDAO {
	// 后台:查询图书
	List<Book> queryAllBooks(Book book);

	// 后台:添加图书
	void insertBook(Book book);

	// 后台: 修改图书的信息
	void updateBook(Book book);

	// 后台: 删除图书
	void deleteBook(Book book);

	// 后台,前台:查询每个二级类别的图书
	List<Book> queryByCate_id(Category category);

	// 前台:根据销量排序后查讯图书
	List<Book> queryBooksBySale();

	// 前台:随机查询图书
	List<Book> queryBooksRandom();

	// 前台:根据销量和上架时间查询图书
	List<Book> queryBooksBySaleAndPTime();

	// 前台:根据上架时间查询图书
	List<Book> queryBooksByPTime();

	// 前台:根据类别id查询图书(分页)
	List<Book> queryBooksByCate(@Param("fid") String fid,
			@Param("cid") String cid, @Param("page") Integer page);

	// 前台:根据类别id查询图书的数量
	Integer queryCountByCate(@Param("fid") String fid, @Param("cid") String cid);
}
