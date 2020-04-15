package cn.baizhi.zw.dao;

import java.util.List;

import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;

public interface CategoryDAO {
	// 后台: 查询所有类别
	List<Category> queryAll();

	// 后台: 根据级别查询类别
	List<Category> queryByLevels(Integer levels);

	// 后台: 添加类别
	void insertCategory(Category category);

	// 后台:删除类别
	void deleteCategory(Category category);

	// 后台，前台: 查询每个一级类别中的二级类别
	List<Category> queryById(Category category);

	// 前台:展示一级类别及其二级类别
	List<Category> queryAllCate(Category category);

	// 前台:根据id展示一级类别及其二级类别
	Category queryCate(Category category);

	// 前台:根据id查询图书的类别
	Category queryCateByBookId(Book book);

}
