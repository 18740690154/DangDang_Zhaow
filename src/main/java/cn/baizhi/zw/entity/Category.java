package cn.baizhi.zw.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
	private String id; // id
	private String cate_name; // 类别名
	private Integer count; // 子类别的数量
	private String parent_id; // 夫类别id
	private Integer levels; // 级别

	private Category category;

	private List<Category> categorys;

	public Category() {
		super();
	}

	public Category(String id, String cate_name, Integer count,
			String parent_id, Integer levels, Category category) {
		super();
		this.id = id;
		this.cate_name = cate_name;
		this.count = count;
		this.parent_id = parent_id;
		this.levels = levels;
		this.category = category;
	}

	public Category(String id, String cate_name, Integer count,
			String parent_id, Integer levels, Category category,
			List<Category> categorys) {
		super();
		this.id = id;
		this.cate_name = cate_name;
		this.count = count;
		this.parent_id = parent_id;
		this.levels = levels;
		this.category = category;
		this.categorys = categorys;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cate_name == null) ? 0 : cate_name.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result
				+ ((categorys == null) ? 0 : categorys.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((levels == null) ? 0 : levels.hashCode());
		result = prime * result
				+ ((parent_id == null) ? 0 : parent_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (cate_name == null) {
			if (other.cate_name != null)
				return false;
		} else if (!cate_name.equals(other.cate_name))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (categorys == null) {
			if (other.categorys != null)
				return false;
		} else if (!categorys.equals(other.categorys))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (levels == null) {
			if (other.levels != null)
				return false;
		} else if (!levels.equals(other.levels))
			return false;
		if (parent_id == null) {
			if (other.parent_id != null)
				return false;
		} else if (!parent_id.equals(other.parent_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", cate_name=" + cate_name + ", count="
				+ count + ", parent_id=" + parent_id + ", levels=" + levels
				+ ", category=" + category + ", categorys=" + categorys + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getParent_id() {
		return parent_id;
	}

	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getLevels() {
		return levels;
	}

	public void setLevels(Integer levels) {
		this.levels = levels;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

}
