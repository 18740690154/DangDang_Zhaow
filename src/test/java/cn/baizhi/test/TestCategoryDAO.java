package cn.baizhi.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.baizhi.zw.dao.CategoryDAO;
import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.util.MyBatisUtil;

public class TestCategoryDAO {
	// 查询所有类别
	@Test
	public void testQueryAll() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		List<Category> queryAll = categoryDAO.queryAll();
		MyBatisUtil.close(sqlSession);
		for (Category category : queryAll) {
			System.out.println(category);
		}
	}

	// 添加类别
	@Test
	public void testInsert() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category category = new Category();
		category.setId("50");
		category.setCate_name("111");
		category.setLevels(1);
		categoryDAO.insertCategory(category);
		MyBatisUtil.commit(sqlSession);
	}

	// 查询所有一级类别
	@Test
	public void testQuerybyLevels() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		List<Category> queryByLevels = categoryDAO.queryByLevels(1);
		for (Category category : queryByLevels) {
			System.out.println(category);
		}

	}

	// 删除类别
	@Test
	public void testDelete() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category category = new Category();
		category.setId("b868a6b1-79c5-4c4a-9a93-e6353bf49cef");
		categoryDAO.deleteCategory(category);
		MyBatisUtil.commit(sqlSession);
	}

	// 查询每个一级类别的二级类别
	@Test
	public void testQueryById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category category = new Category();
		category.setId("820a1d97-c917-4c72-8126-faebb5115494");
		List<Category> queryById = categoryDAO.queryById(category);
		for (Category category1 : queryById) {
			System.out.println(category1);
		}
		MyBatisUtil.close(sqlSession);
	}

	// 前台:展示一级类别及其二级类别
	@Test
	public void testQueryAllCate() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category cate = new Category();
		cate.setId("11");
		List<Category> queryAllCate = categoryDAO.queryAllCate(cate);
		for (Category category : queryAllCate) {
			System.out.println(category);
		}
		MyBatisUtil.close(sqlSession);
	}

	// 前台:通过图书id查询类别
	@Test
	public void testCateByBookId() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Book book = new Book();
		book.setId("101");
		Category queryCateByBookId = categoryDAO.queryCateByBookId(book);
		System.out.println(queryCateByBookId);
		MyBatisUtil.close(sqlSession);
	}
}