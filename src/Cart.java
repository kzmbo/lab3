import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
	
	private ArrayList<Amount> purchasedProducts;
	private double total;
	
	
	public Cart() {
		this.purchasedProducts = new ArrayList<Amount>(); //FIXME: Complete this line;
		this.total = 0;//FIXME: complete this line;
	}
	
	public int addProduct(Product p) {
		boolean isNotDuplicate = true;
		for(int i = 0; i < this.purchasedProducts.size(); i++) {
			if(this.purchasedProducts.get(i).product.getSKU().equals(p.getSKU())) {
				isNotDuplicate = false;
				this.purchasedProducts.get(i).updateProductAmount((this.purchasedProducts.get(i).productAmount) + 1);
				int x = (this.purchasedProducts.get(i).productAmount) + 1;
				total += p.getPrice();
				return x;
			}
		}
		if(isNotDuplicate){
			Amount am = new Amount(p, 0);
			this.purchasedProducts.add(am);
			total += p.getPrice();
			return 0;
		}
		return 0;
		//total += p.getPrice();
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