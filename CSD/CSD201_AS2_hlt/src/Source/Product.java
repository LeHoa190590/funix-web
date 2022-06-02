package Source;

import java.io.Serializable;

public class Product implements Serializable{
	String bcode;
	String title;
	int quanlity;
	double price;
	
	public Product() {
		String bcode;
		String title;
		int quanlity;
		double price;
	}
	
	public Product(String bcode, String title, Integer quanlity, double price) {
		this.bcode = bcode;
		this.title = title;
		this.quanlity = quanlity;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return (this.bcode+" | "+this.title+" | "+this.quanlity+" | "+this.price);
	}
}
