package cn.baizhi.zw.action;

import java.util.List;

import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.service.CategoryService;
import cn.baizhi.zw.serviceimp.CategoryServiceImp;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	// 后台: 展示所有类别传输的数据
	private List<Category> categorys;

	// 后台:添加类别传输的数据
	private Category category;

	// 后台:展示一级类别所接受的数据
	// 后台:查询一级类别的接受的数据
	private List<Category> showByLevels;

	// 后台: 删除类别传输的数据
	private String message;

	// 后台: 展示所有类别的方法
	public String showAll() {
		CategoryService categoryService = new CategoryServiceImp();
		categorys = categoryService.showAll();
		return "showAllSuccess";
	}

	// 后台: 添加类别的方法
	public String insert() {
		CategoryService categoryService = new CategoryServiceImp();
		categoryService.insertCategory(category);
		System.out.println("+++++++++" + category);
		return "insertSuccess";
	}

	// 后台: 删除类别的方法
	public String delete() {
		CategoryService categoryService = new CategoryServiceImp();
		System.out.println(category);
		message = categoryService.deleteCategory(category);

		return "deleteSuccess";
	}

	// 后台:展示一级类别的方法
	public String showByLevels() {
		CategoryService categoryService = new CategoryServiceImp();
		showByLevels = categoryService.showByLevels(1);
		return "showByLevelsSuccess";
	}

	// 后台:展示二类类别的方法
	public String queryLevels() {
		CategoryService categoryService = new CategoryServiceImp();
		showByLevels = categoryService.showByLevels(2);
		return "queryLevelsSuccess";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Category> getShowByLevels() {
		return showByLevels;
	}

	public void setShowByLevels(List<Category> showByLevels) {
		this.showByLevels = showByLevels;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
