package cn.baizhi.zw.service;

import java.util.List;

import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;

public interface CategoryService {
	// 后台:展示所有类别
	List<Category> showAll();

	// 后台: 添加类别
	void insertCategory(Category category);

	// 后台:根据级别查询类别
	List<Category> showByLevels(Integer levels);

	// 后台: 删除类别
	String deleteCategory(Category category);

	// 前台:展示一级类别及其二级类别
	List<Category> queryAllCate(Category category);

	// 前台:根据id展示一级类别及其二级类别
	Category queryCate(Category category);

	// 前台:通过图书id展示图书的类别
	Category queryCateByBookId(Book book);
}
