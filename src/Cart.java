import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	
	private ArrayList<Amount> purchasedProducts;
	private double total;
	
	
	public Cart() {
		
		this.purchasedProducts = new ArrayList<Amount>(); //FIXME: Complete this line;
		this.total = 0;//FIXME: complete this line;
	}
	
	public void addProduct(Product p) {
		boolean val = true;
		for(int i=0; i<this.purchasedProducts.size(); i++) {
			if(this.purchasedProducts.get(i).pro.getSKU().equals(p.getSKU())) {
				val = false;
				this.purchasedProducts.get(i).updateProAmount((this.purchasedProducts.get(i).proAmount)+1);
			}
		}
		if(val) {
			Amount am = new Amount(p, 0);
			this.purchasedProducts.add(am);
		}
		
		total += p.getPrice();
	}
	
	
	public double getTransactionTotal() {
		System.out.println("You're total is: $" + total);
		return total;
	}
	
	/**
	* returns a formatted string containing the entire 
	* representation of the receipt for this cart,
	* including store name, list of items with subtotals,
	* grand total, payment, and change.
	* @return a String 
	*/
	public String toString() {
		System.out.println(purchasedProducts);
		return "";
	}

}