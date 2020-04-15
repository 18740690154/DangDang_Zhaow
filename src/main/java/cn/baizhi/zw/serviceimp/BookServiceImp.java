package cn.baizhi.zw.serviceimp;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import cn.baizhi.zw.dao.BookDAO;
import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.service.BookService;
import cn.baizhi.zw.util.MyBatisUtil;

public class BookServiceImp implements BookService {
	// 后台:展示所有的图书
	@Override
	public List<Book> showAll(Book book) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryAllBooks = bookDAO.queryAllBooks(book);
		MyBatisUtil.close(sqlSession);
		return queryAllBooks;
	}

	// 后台:添加图书

	@Override
	public void insertBook(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
			String uuid = UUID.randomUUID().toString();
			book.setId(uuid);
			book.setSale_count(0);
			bookDAO.insertBook(book);
			MyBatisUtil.commit(sqlSession);

		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
		}
	}

	// 后台: 修改图书的信息
	@Override
	public void updateBook(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
			bookDAO.updateBook(book);
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
		}
	}

	// 后台: 删除图书
	@Override
	public void deleteBook(Book book) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
			bookDAO.deleteBook(book);
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
		}
	}

	// 前台:通过销售量查询图书
	@Override
	public List<Book> queryBooksBySale() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksBySale = bookDAO.queryBooksBySale();
		MyBatisUtil.close(sqlSession);
		return queryBooksBySale;
	}

	// 前台:随机展示图书
	@Override
	public List<Book> queryBooksRandom() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksRandom = bookDAO.queryBooksRandom();
		MyBatisUtil.close(sqlSession);
		return queryBooksRandom;

	}

	// 前台: 通过上架时间展示图书

	@Override
	public List<Book> queryBooksBySaleAndPTime() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksBySaleAndPTime = bookDAO
				.queryBooksBySaleAndPTime();
		MyBatisUtil.close(sqlSession);
		return queryBooksBySaleAndPTime;

	}

	// 前台:通过上架时间和销售量展示图书
	@Override
	public List<Book> queryBooksByPTime() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		List<Book> queryBooksByPTime = bookDAO.queryBooksByPTime();
		MyBatisUtil.close(sqlSession);
		return queryBooksByPTime;
	}

	// 前台:根据类别id查询图书
	@Override
	public List<Book> queryBooksByCate(String fid, String cid, Integer page) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);

		List<Book> queryBooksByCate = bookDAO.queryBooksByCate(fid, cid, page);
		MyBatisUtil.close(sqlSession);
		return queryBooksByCate;

	}

	// 前台:根据类别id查询(求出总页数)
	@Override
	public Integer queryBookPageCount(String fid, String cid) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		Integer bookCount = bookDAO.queryCountByCate(fid, cid);
		MyBatisUtil.close(sqlSession);
		int pageCount = 0;
		if (bookCount % 3 == 0) {
			pageCount = bookCount / 3;
		} else {
			pageCount = bookCount / 3 + 1;
		}
		return pageCount;
	}
}
