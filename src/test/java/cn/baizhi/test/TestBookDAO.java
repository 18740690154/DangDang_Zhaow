package cn.baizhi.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.baizhi.zw.dao.BookDAO;
import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.util.MyBatisUtil;

public class TestBookDAO {

	@Test
	// 查询所有图书
	public void testQueryAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		Book book = new Book();
		book.setCompany("4");
		List<Book> queryAllBooks = bookDAO.queryAllBooks(book);
		for (Book book1 : queryAllBooks) {
			System.out.println(book1);
		}
	}

	@Test
	// 添加图书
	public void testInsert() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);

		Book book = new Book("101111", "一个陌生女人的来信", "薛莹莹", 56.50, 52.50,
				"青春出版社", new Date(), "1050000", "13246523", new Date(),
				"10521231", 10000, "第三版", "第四次印刷", "8k", "胶版纸", "线装本", 351,
				1050000, 20000, "编辑推荐", "内容简介", "作者简介", "基本目录", "媒体评论",
				"16.jpg", "1");
		bookDAO.insertBook(book);
		MyBatisUtil.commit(sqlSession);
	}

	@Test
	// 修改图书信息
	public void testUpdate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		Book book = new Book();
		book.setId("4b69b974-fe78-445d-af8a-2fe3c5c0b0fa");
		book.setAuthor("板子");
		bookDAO.updateBook(book);
		MyBatisUtil.commit(sqlSession);
	}

	@Test
	// 删除图书信息
	public void testDelete() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		Book book = new Book();
		book.setId("11e85b71-4e73-4192-93bf-fcdabf740b41");
		bookDAO.deleteBook(book);
		MyBatisUtil.commit(sqlSession);
	}

	@Test
	// 查询二级类别的图书信息
	public void testQueryByCate_id() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		Category category = new Category();
		category.setId("4193a069-f922-4648-a31b-343e162a254e");
		List<Book> queryByCate_id = bookDAO.queryByCate_id(category);
		for (Book book : queryByCate_id) {
			System.out.println(book);
		}
		MyBatisUtil.close(sqlSession);
	}

	@Test
	// 通过上架时间和销量展示图书
	public void testqueryBooksBySaleAndPTime() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksBySaleAndPTime = bookDAO
				.queryBooksBySaleAndPTime();
		for (Book book : queryBooksBySaleAndPTime) {
			System.out.println(book);
		}
		MyBatisUtil.close(sqlSession);
	}

	@Test
	// 前台:根据类别id查询图书(分页)
	public void testQueryBooksByCate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksByCate = bookDAO.queryBooksByCate(
				"29bf1e9e-d06a-47b8-b186-7d320fd6418c",
				"4193a069-f922-4648-a31b-343e162a254e", 1);
		for (Book book : queryBooksByCate) {
			System.out.println(book);
		}
		MyBatisUtil.close(sqlSession);
	}
}
