package cn.han.domain;

/**
 * 
 * @ClassName: Book
 * @Description:  BookBean
 * @author Heaven
 * @date 2017-2-19 下午6:39:36
 * @version v1.0
 */

public class Book {
	private int id;
	private String author;
	private String name;
	private String price;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", name=" + name
				+ ", price=" + price + "]";
	}
}
