package cn.baizhi.zw.entity;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
	private String id; // id
	private String book_name; // 书名
	private String author; // 作者
	private Double price; // 价格
	private Double dd_price; // dd价格
	private String company; // 出版社
	private Date publish_time; // 印刷时间
	private String publish_count; // 印刷数量
	private String isbn; // isbn
	private Date print_time; // 出版时间
	private String print_count; // 出版数量
	private Integer sale_count; // 销售量
	private String edition; // 版次
	private String impression; // 印次
	private String format; // 开本
	private String paper; // 纸张
	private String pack; // 包装
	private Integer page_count; // 页数
	private Integer word_count; // 字数
	private Integer stock_count; // 库存
	private String e_recommend; // 编辑推荐
	private String c_introduction; // 内容简介
	private String author_abstract; // 作者简介
	private String catalogue; // 基本目录
	private String m_comments; // 媒体评论
	private String src; // 封面图片路径
	private String cate_id; // 所属类别

	private Category category; // 类别对象

	public Book() {
		super();
	}

	public Book(String id, String book_name, String author, Double price,
			Double dd_price, String company, Date publish_time,
			String publish_count, String isbn, Date print_time,
			String print_count, Integer sale_count, String edition,
			String impression, String format, String paper, String pack,
			Integer page_count, Integer word_count, Integer stock_count,
			String e_recommend, String c_introduction, String author_abstract,
			String catalogue, String m_comments, String src, String cate_id) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.dd_price = dd_price;
		this.company = company;
		this.publish_time = publish_time;
		this.publish_count = publish_count;
		this.isbn = isbn;
		this.print_time = print_time;
		this.print_count = print_count;
		this.sale_count = sale_count;
		this.edition = edition;
		this.impression = impression;
		this.format = format;
		this.paper = paper;
		this.pack = pack;
		this.page_count = page_count;
		this.word_count = word_count;
		this.stock_count = stock_count;
		this.e_recommend = e_recommend;
		this.c_introduction = c_introduction;
		this.author_abstract = author_abstract;
		this.catalogue = catalogue;
		this.m_comments = m_comments;
		this.src = src;
		this.cate_id = cate_id;
	}

	public Book(String id, String book_name, String author, Double price,
			Double dd_price, String company, Date publish_time,
			String publish_count, String isbn, Date print_time,
			String print_count, Integer sale_count, String edition,
			String impression, String format, String paper, String pack,
			Integer page_count, Integer word_count, Integer stock_count,
			String e_recommend, String c_introduction, String author_abstract,
			String catalogue, String m_comments, String src, String cate_id,
			Category category) {
		super();
		this.id = id;
		this.book_name = book_name;
		this.author = author;
		this.price = price;
		this.dd_price = dd_price;
		this.company = company;
		this.publish_time = publish_time;
		this.publish_count = publish_count;
		this.isbn = isbn;
		this.print_time = print_time;
		this.print_count = print_count;
		this.sale_count = sale_count;
		this.edition = edition;
		this.impression = impression;
		this.format = format;
		this.paper = paper;
		this.pack = pack;
		this.page_count = page_count;
		this.word_count = word_count;
		this.stock_count = stock_count;
		this.e_recommend = e_recommend;
		this.c_introduction = c_introduction;
		this.author_abstract = author_abstract;
		this.catalogue = catalogue;
		this.m_comments = m_comments;
		this.src = src;
		this.cate_id = cate_id;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", book_name=" + book_name + ", author="
				+ author + ", price=" + price + ", dd_price=" + dd_price
				+ ", company=" + company + ", publish_time=" + publish_time
				+ ", publish_count=" + publish_count + ", isbn=" + isbn
				+ ", print_time=" + print_time + ", print_count=" + print_count
				+ ", sale_count=" + sale_count + ", edition=" + edition
				+ ", impression=" + impression + ", format=" + format
				+ ", paper=" + paper + ", pack=" + pack + ", page_count="
				+ page_count + ", word_count=" + word_count + ", stock_count="
				+ stock_count + ", e_recommend=" + e_recommend
				+ ", c_introduction=" + c_introduction + ", author_abstract="
				+ author_abstract + ", catalogue=" + catalogue
				+ ", m_comments=" + m_comments + ", src=" + src + ", cate_id="
				+ cate_id + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((author_abstract == null) ? 0 : author_abstract.hashCode());
		result = prime * result
				+ ((book_name == null) ? 0 : book_name.hashCode());
		result = prime * result
				+ ((c_introduction == null) ? 0 : c_introduction.hashCode());
		result = prime * result
				+ ((catalogue == null) ? 0 : catalogue.hashCode());
		result = prime * result + ((cate_id == null) ? 0 : cate_id.hashCode());
		result = prime * result
				+ ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result
				+ ((dd_price == null) ? 0 : dd_price.hashCode());
		result = prime * result
				+ ((e_recommend == null) ? 0 : e_recommend.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((impression == null) ? 0 : impression.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime * result
				+ ((m_comments == null) ? 0 : m_comments.hashCode());
		result = prime * result + ((pack == null) ? 0 : pack.hashCode());
		result = prime * result
				+ ((page_count == null) ? 0 : page_count.hashCode());
		result = prime * result + ((paper == null) ? 0 : paper.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((print_count == null) ? 0 : print_count.hashCode());
		result = prime * result
				+ ((print_time == null) ? 0 : print_time.hashCode());
		result = prime * result
				+ ((publish_count == null) ? 0 : publish_count.hashCode());
		result = prime * result
				+ ((publish_time == null) ? 0 : publish_time.hashCode());
		result = prime * result
				+ ((sale_count == null) ? 0 : sale_count.hashCode());
		result = prime * result + ((src == null) ? 0 : src.hashCode());
		result = prime * result
				+ ((stock_count == null) ? 0 : stock_count.hashCode());
		result = prime * result
				+ ((word_count == null) ? 0 : word_count.hashCode());
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
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (author_abstract == null) {
			if (other.author_abstract != null)
				return false;
		} else if (!author_abstract.equals(other.author_abstract))
			return false;
		if (book_name == null) {
			if (other.book_name != null)
				return false;
		} else if (!book_name.equals(other.book_name))
			return false;
		if (c_introduction == null) {
			if (other.c_introduction != null)
				return false;
		} else if (!c_introduction.equals(other.c_introduction))
			return false;
		if (catalogue == null) {
			if (other.catalogue != null)
				return false;
		} else if (!catalogue.equals(other.catalogue))
			return false;
		if (cate_id == null) {
			if (other.cate_id != null)
				return false;
		} else if (!cate_id.equals(other.cate_id))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (dd_price == null) {
			if (other.dd_price != null)
				return false;
		} else if (!dd_price.equals(other.dd_price))
			return false;
		if (e_recommend == null) {
			if (other.e_recommend != null)
				return false;
		} else if (!e_recommend.equals(other.e_recommend))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (impression == null) {
			if (other.impression != null)
				return false;
		} else if (!impression.equals(other.impression))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (m_comments == null) {
			if (other.m_comments != null)
				return false;
		} else if (!m_comments.equals(other.m_comments))
			return false;
		if (pack == null) {
			if (other.pack != null)
				return false;
		} else if (!pack.equals(other.pack))
			return false;
		if (page_count == null) {
			if (other.page_count != null)
				return false;
		} else if (!page_count.equals(other.page_count))
			return false;
		if (paper == null) {
			if (other.paper != null)
				return false;
		} else if (!paper.equals(other.paper))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (print_count == null) {
			if (other.print_count != null)
				return false;
		} else if (!print_count.equals(other.print_count))
			return false;
		if (print_time == null) {
			if (other.print_time != null)
				return false;
		} else if (!print_time.equals(other.print_time))
			return false;
		if (publish_count == null) {
			if (other.publish_count != null)
				return false;
		} else if (!publish_count.equals(other.publish_count))
			return false;
		if (publish_time == null) {
			if (other.publish_time != null)
				return false;
		} else if (!publish_time.equals(other.publish_time))
			return false;
		if (sale_count == null) {
			if (other.sale_count != null)
				return false;
		} else if (!sale_count.equals(other.sale_count))
			return false;
		if (src == null) {
			if (other.src != null)
				return false;
		} else if (!src.equals(other.src))
			return false;
		if (stock_count == null) {
			if (other.stock_count != null)
				return false;
		} else if (!stock_count.equals(other.stock_count))
			return false;
		if (word_count == null) {
			if (other.word_count != null)
				return false;
		} else if (!word_count.equals(other.word_count))
			return false;
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDd_price() {
		return dd_price;
	}

	public void setDd_price(Double dd_price) {
		this.dd_price = dd_price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(Date publish_time) {
		this.publish_time = publish_time;
	}

	public String getPublish_count() {
		return publish_count;
	}

	public void setPublish_count(String publish_count) {
		this.publish_count = publish_count;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Date getPrint_time() {
		return print_time;
	}

	public void setPrint_time(Date print_time) {
		this.print_time = print_time;
	}

	public String getPrint_count() {
		return print_count;
	}

	public void setPrint_count(String print_count) {
		this.print_count = print_count;
	}

	public Integer getSale_count() {
		return sale_count;
	}

	public void setSale_count(Integer sale_count) {
		this.sale_count = sale_count;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getImpression() {
		return impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getPaper() {
		return paper;
	}

	public void setPaper(String paper) {
		this.paper = paper;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Integer getPage_count() {
		return page_count;
	}

	public void setPage_count(Integer page_count) {
		this.page_count = page_count;
	}

	public Integer getWord_count() {
		return word_count;
	}

	public void setWord_count(Integer word_count) {
		this.word_count = word_count;
	}

	public Integer getStock_count() {
		return stock_count;
	}

	public void setStock_count(Integer stock_count) {
		this.stock_count = stock_count;
	}

	public String getE_recommend() {
		return e_recommend;
	}

	public void setE_recommend(String e_recommend) {
		this.e_recommend = e_recommend;
	}

	public String getC_introduction() {
		return c_introduction;
	}

	public void setC_introduction(String c_introduction) {
		this.c_introduction = c_introduction;
	}

	public String getAuthor_abstract() {
		return author_abstract;
	}

	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}

	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public String getM_comments() {
		return m_comments;
	}

	public void setM_comments(String m_comments) {
		this.m_comments = m_comments;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getCate_id() {
		return cate_id;
	}

	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
