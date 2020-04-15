package cn.baizhi.zw.serviceimp;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;

import cn.baizhi.zw.dao.BookDAO;
import cn.baizhi.zw.dao.CategoryDAO;
import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.service.CategoryService;
import cn.baizhi.zw.util.MyBatisUtil;

public class CategoryServiceImp implements CategoryService {
	// 后台: 展示所有类别
	@Override
	public List<Category> showAll() {

		// 通过工具获取sqlsession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 通过sqlSession对象获取DAO实现类对象
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		// 调用DAO方法
		List<Category> queryAll = categoryDAO.queryAll();

		return queryAll;
	}

	// 后台:添加类别
	@Override
	public void insertCategory(Category category) {
		SqlSession sqlSession = null;
		try {
			// 通过工具获取sqlsession对象
			sqlSession = MyBatisUtil.getSqlSession();
			// 通过sqlSession对象获取DAO实现类对象
			CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
			// 获取uuid
			String string = UUID.randomUUID().toString();
			category.setId(string);
			// 设置数量count属性，初始值为0
			category.setCount(0);
			// 判断是否存在父类id
			if (category.getParent_id() != null) {
				// 存在，级别为1
				category.setLevels(2);
			} else {
				// 不存在，级别为2
				category.setLevels(1);
			}
			// 调用DAO方法
			categoryDAO.insertCategory(category);
			// 手动commit并关闭资源
			MyBatisUtil.commit(sqlSession);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			MyBatisUtil.rollback(sqlSession);
		}

	}

	// 后台: 根据级别查询类别
	@Override
	public List<Category> showByLevels(Integer levels) {

		// 通过工具获取sqlsession对象
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 通过sqlSession对象获取DAO实现类对象
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		// 调用DAO层方法，查询所有一级类别
		List<Category> queryByLevels = categoryDAO.queryByLevels(levels);
		MyBatisUtil.close(sqlSession);
		return queryByLevels;
	}

	// 后台:删除类别

	@Override
	public String deleteCategory(Category category) {
		String message = null;
		SqlSession sqlSession = null;
		try {
			// 通过工具获取sqlsession对象
			sqlSession = MyBatisUtil.getSqlSession();
			// 通过sqlSession对象获取DAO实现类对象
			CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
			// 判断类别的级别
			if (category.getLevels() == 2) {
				// 二级类别
				BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
				List<Book> books = bookDAO.queryByCate_id(category);
				// 判断二级类别下是否存在图书
				if (books.size() == 0) {
					// 调用删除方法
					categoryDAO.deleteCategory(category);
					message = "删除成功";
				} else {
					message = "该二级类别下存在图书，无法删除";
				}
			} else {
				// 一级类别，查询对应的二级类别
				List<Category> queryById = categoryDAO.queryById(category);
				// 判断对应的二级类别集合长度是否为0
				if (queryById.size() == 0) {
					// 长度为0,掉用删除方法直接删除
					categoryDAO.deleteCategory(category);

					System.out.println("一级类别中没有二级类别的被删除了");
					message = "删除成功";
				} else {
					message = "该类别中有二级类别，无法删除";
				}
			}
			MyBatisUtil.commit(sqlSession);
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			MyBatisUtil.rollback(sqlSession);
			e.printStackTrace();
			return null;
		}

	}

	// 前台:展示一级类别及其二级类别
	@Override
	public List<Category> queryAllCate(Category category) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		List<Category> categories = categoryDAO.queryAllCate(category);
		MyBatisUtil.close(sqlSession);
		return categories;
	}

	// 前台:根据id展示一级类别及其二级类别
	@Override
	public Category queryCate(Category category) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category queryCate = categoryDAO.queryCate(category);

		BookDAO bookDAO = sqlSession.getMapper(BookDAO.class);
		// 查询一级类别下的图书数量
		Integer count = bookDAO.queryCountByCate(queryCate.getId(), null);
		// 为一级类别的count重新赋值
		queryCate.setCount(count);
		// 遍历一级类别中的二级类别集合
		for (Category cate : queryCate.getCategorys()) {
			// 查询二级类别下的图书数量
			Integer count2 = bookDAO.queryCountByCate(queryCate.getId(),
					cate.getId());
			// 为一级类别的count重新赋值
			cate.setCount(count2);
		}
		MyBatisUtil.close(sqlSession);
		return queryCate;
	}

	// 前台:通过图书id展示图书的类别
	@Override
	public Category queryCateByBookId(Book book) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		CategoryDAO categoryDAO = sqlSession.getMapper(CategoryDAO.class);
		Category queryCateByBookId = categoryDAO.queryCateByBookId(book);
		MyBatisUtil.close(sqlSession);
		return queryCateByBookId;
	}

}
