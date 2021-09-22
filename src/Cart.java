import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	
	private ArrayList<Product> purchasedProducts;
	private double total;
	
	public Cart() {
		this.purchasedProducts = null;//FIXME: Complete this line;
		this.total = 0;//FIXME: complete this line;
	}
	
	public void addProduct(Product p) {
		// FIXME: complete the implementation of this method.
		
	}
	
	
	public double getTransactionTotal() {
		// FIXME: complete the implementation of this method.
	}
	
	/**
	* returns a formatted string containing the entire 
	* representation of the receipt for this cart,
	* including store name, list of items with subtotals,
	* grand total, payment, and change.
	* @return a String 
	*/
	public String toString() {
		return "FIXME: return the correct string";
	}

}
