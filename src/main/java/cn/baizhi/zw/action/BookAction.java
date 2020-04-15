package cn.baizhi.zw.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.baizhi.zw.entity.Book;
import cn.baizhi.zw.entity.Category;
import cn.baizhi.zw.service.BookService;
import cn.baizhi.zw.service.CategoryService;
import cn.baizhi.zw.serviceimp.BookServiceImp;
import cn.baizhi.zw.serviceimp.CategoryServiceImp;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {

	// 后台: 展示所有的图书接受的数据
	// 前台：展示二级类别下的图书接受的数据
	// 前台展示二级类别下的图书
	private List<Book> books;

	// 后台:添加图书接受的数据
	// 前台:购买图书接受的数据
	private Book book;

	// 前台:展示一级类别及其二级类别所接受的数据
	// 后台:修改图书所接受的数据
	private List<Category> categorys;

	// 后台:上传图片所接受的数据
	private String fileFileName;
	private File file;
	private String saveFile;

	// 后台:模糊查询所接受的数据
	private String key;
	private String content;

	// 前台:首页展示所接受的数据
	private List<Book> saleBooks;// 通过销量展示图书
	private List<Book> timeBooks;// 通过上架时间展示图书
	private List<Book> randomBooks;// 随机展示图书
	private List<Book> saleAndPTimeBooks;// 通过上架时间和销量展示图书

	// 前台：二级页面的展示接受的数据
	// 后台: 展示二级类别下的图书接受的数据
	private Category category;

	// 前台: 二级页面的展示接受的数据
	private String fid;
	private String cid;
	private Integer page;
	private Integer pageCount;

	// 后台:展示所有的图书的方法
	public String showAll() {
		BookService bookService = new BookServiceImp();
		books = bookService.showAll(book);

		return "showAllSuccess";

	}

	// 后台:添加图书的方法
	public String insert() throws IOException {
		// 上传图片
		String realPath = ServletActionContext.getServletContext().getRealPath(
				saveFile);
		System.out.println("保存的文件夹" + realPath);
		FileUtils.copyFile(file, new File(realPath + "/" + fileFileName));
		book.setSrc(saveFile + "/" + fileFileName);
		// 添加图书
		BookService bookService = new BookServiceImp();
		System.out.println(book);
		bookService.insertBook(book);

		return "insertSuccess";
	}

	// 后台:展示要修还的图书信息
	public String showUpdate() {
		// 查询要修改的图书信息
		BookService bookService = new BookServiceImp();
		books = bookService.showAll(book);
		// 展示二级的类别
		CategoryService categoryService = new CategoryServiceImp();
		categorys = categoryService.showByLevels(2);

		return "showUPdateSuccess";
	}

	// 后台: 修改图书的信息
	public String update() throws IOException {
		BookService bookService = new BookServiceImp();
		// 判断是否修改图书的封面
		if (file != null) {
			// 上传图片
			String realPath = ServletActionContext.getServletContext()
					.getRealPath(saveFile);
			// 通过流传输图片
			FileUtils.copyFile(file, new File(realPath + "/" + fileFileName));
			book.setSrc(saveFile + "/" + fileFileName);
			System.out.println(book);
			// 修改图书信息

			bookService.updateBook(book);
		} else {
			// 修改图书信息
			bookService.updateBook(book);
		}
		return "updateSuccess";
	}

	// 后台: 模糊查询的方法
	public String queryLike() {
		BookService bookService = new BookServiceImp();
		Book book = new Book();
		if ("name".equals(key)) {
			book.setBook_name(content);
			books = bookService.showAll(book);
			System.out.println("相似的书名有" + books);
		}
		if ("author".equals(key)) {
			book.setAuthor(content);
			books = bookService.showAll(book);
			System.out.println("相似的作者名有" + books);
		}
		if ("company".equals(key)) {
			book.setCompany(content);
			books = bookService.showAll(book);
			System.out.println("相似的出版社有" + books);
		}

		return "queryLikeSuccess";
	}

	// 后台:删除图书的方法
	public String delete() {
		BookService bookService = new BookServiceImp();
		bookService.deleteBook(book);

		return "deleteSuccess";
	}

	// 前台：首页展示的方法
	public String showHomePage() {

		BookService bookService = new BookServiceImp();
		// 通过销量展示图书
		saleBooks = bookService.queryBooksBySale();
		// 通过上架时间展示图书
		timeBooks = bookService.queryBooksByPTime();
		// 随机展示图书
		randomBooks = bookService.queryBooksRandom();
		// 通过上架时间和销量展示图书
		saleAndPTimeBooks = bookService.queryBooksBySaleAndPTime();

		System.out.println("通过上架时间和销量展示图书" + saleAndPTimeBooks);

		// 展示一级类别及其二级类别
		CategoryService categoryService = new CategoryServiceImp();
		categorys = categoryService.queryAllCate(category);
		System.out.println("展示一级类别及其二级类别" + categorys);
		return "showHomePageSuccess";
	}

	// 二级页面的展示的方法
	public String showCateBook() {

		// 展示类别
		CategoryService categoryService = new CategoryServiceImp();
		Category cate = new Category();
		cate.setId(fid);
		category = categoryService.queryCate(cate);

		if (page == null) {
			page = 1;
		}
		// 展示图书
		BookService bookService = new BookServiceImp();
		books = bookService.queryBooksByCate(fid, cid, page);
		for (Book b : books) {
			System.out.println(b);
		}
		// 前台:根据类别id查询(求出总页数)
		pageCount = bookService.queryBookPageCount(fid, cid);
		return "showCateBookSuccess";
	}

	// 前台:详情页面图书展示
	public String showBookDetails() {

		// 根据图书id查询图书类别
		CategoryService categoryService = new CategoryServiceImp();
		category = categoryService.queryCateByBookId(book);
		// 根据图书id查根询图书信息
		BookService bookServic = new BookServiceImp();
		List<Book> books = bookServic.showAll(book);
		for (Book b : books) {
			book = b;
		}
		return "showBookDetailsSuccess";
	}

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getSaveFile() {
		return saveFile;
	}

	public void setSaveFile(String saveFile) {
		this.saveFile = saveFile;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public List<Book> getSaleBooks() {
		return saleBooks;
	}

	public void setSaleBooks(List<Book> saleBooks) {
		this.saleBooks = saleBooks;
	}

	public List<Book> getRandomBooks() {
		return randomBooks;
	}

	public void setRandomBooks(List<Book> randomBooks) {
		this.randomBooks = randomBooks;
	}

	public List<Book> getTimeBooks() {
		return timeBooks;
	}

	public void setTimeBooks(List<Book> timeBooks) {
		this.timeBooks = timeBooks;
	}

	public List<Book> getSaleAndPTimeBooks() {
		return saleAndPTimeBooks;
	}

	public void setSaleAndPTimeBooks(List<Book> saleAndPTimeBooks) {
		this.saleAndPTimeBooks = saleAndPTimeBooks;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
