package cn.baizhi.test;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.service.CategoryService;
import cn.baizhi.zw.serviceimp.CategoryServiceImp;

public class TestCategoryService {
	// 查询所有类别
	@Test
	public void testShowAll() {
		CategoryService categoryService = new CategoryServiceImp();
		List<Category> showAll = categoryService.showAll();
		for (Category category : showAll) {
			System.out.println(category);
		}
	}

	// 添加类别
	@Test
	public void testInsert() {
		CategoryService categoryService = new CategoryServiceImp();
		Category category = new Category();
		String string = UUID.randomUUID().toString();
		System.out.println(string);
		category.setId(string);
		category.setCate_name("言情");
		category.setLevels(1);
		categoryService.insertCategory(category);
	}

	// 查询所有类别
	@Test
	public void testQueryByLevels() {
		CategoryService categoryService = new CategoryServiceImp();
		List<Category> showByLevels = categoryService.showByLevels(1);
		for (Category category : showByLevels) {
			System.out.println(category);
		}
	}
}