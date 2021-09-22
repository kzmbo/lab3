import java.util.ArrayList;
import java.util.Scanner;


public class Product {
	
	//private int productID;
	private String productSKU;
	private String productName;
	private String productSize;
	private double productPrice;
	
	/**
	 * creates a Product object with given name, size, and price
	 * @param productName - the name of this product 
	 * @param productSize - the size of this product as a string
	 * @param productPrice  - the price of this product as a double
	 * **/
	public Product(String productSKU, String productName, String productSize, double productPrice) {
		this.productSKU = productSKU;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
	}
	
	
	public String getSKU() {
		return "TODO: Implement and document getSKU()";
	}
	
	public String getName() {
		return "TODO: Implement and document getName()";
	}
	
	public String getSize() {
		return "TODO: Implement and document getSize()";
	}
	
	public double getPrice() {
		System.out.println("TODO: Implement and document getName()");
		return 0;
	}
	
	public void setSKU(String productSKU) {
		this.productSKU = productSKU;
	}
	
	public void setName(String productName) {
		this.productName = productName;
	}
	
	public void setSize(String productSize) {
		this.productSize = productSize;
	}
	
	public void setPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	

	
	/**
	 * overrides equals() so that two Product objects are considered equal if the
	 * strings representing their SKU numbers are equal
	 * */
	public boolean equals(Object other) {
		
		Product otherProduct = (Product) other;
		
		if(this.productSKU.equals(otherProduct.getSKU())) {
			return true;
		}
		
		return false;
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("--------------PRODUCT TESTER-----------------");
		Product p = new Product("12354","Cookies", "12 dz", 3.50);
		System.out.println("Printing object: "+p);
		System.out.println("Expected: Cookies                       12 dz     $3.50");
	}

}
