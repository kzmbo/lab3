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
		return this.productSKU;
	}
	
	public String getName() {
		return this.productName;
	}
	
	public String getSize() {
		return this.productSize;
	}
	
	public double getPrice() {
		return this.productPrice;
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

	public String toString() {
		return productSKU + " ";
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("--------------PRODUCT TESTER-----------------");
		Product p = new Product("12354","Cookies", "12 dz", 3.50);
		System.out.println("Printing object: "+p);
		System.out.println("Expected: Cookies                       12 dz     $3.50");
	}

}