package com.sz.action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.sz.model.Book;
import com.sz.service.BookService;

public class BookAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BookService bookService = new BookService();
	private ArrayList<Book>  books = new ArrayList<Book>();
	private Book book;
	private String info; 
	private String id;
	
	public String BookList()
	{
		books = bookService.getAllBooks();
		System.out.println("BookList actionִ��");
		return "success";
	}
	
	public String BookAdd()
	{
		System.out.println("BookAdd actionִ��");
		String flag="";
		if(bookService.addBook(book))
		{
			info = "�鼮��Ϣ��ӳɹ�";
			flag="success";
		}else
		{
			info = "�鼮��Ϣ���ʧ��";
			flag="fail";
		}
		return flag;
	}
	
	public String BookDelete()
	{
		System.out.println("BookDelete actionִ��");
		String flag="";
		if(bookService.deleteBookById(id))
		{
			flag="success";
		}
		return flag;
	}
	
	public String BookUpdateLoad()
	{
		book = bookService.getBookById(id);
		return "success";
	}
	
	public String BookUpdate()
	{
		System.out.println("BookUpdate actionִ��");
		String flag="";
		if(bookService.updateBook(book))
		{
			info = "�鼮��Ϣ�޸ĳɹ�";
			flag="success";
		}else
		{
			info = "�鼮��Ϣ�޸�ʧ��";
			flag="fail";
		}
		return flag;
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}


	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


}
