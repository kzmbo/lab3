import java.util.ArrayList;

public class Amount {
	public Product product;
	public int productAmount;

	public Amount(Product product, int proAmount) {
		this.productAmount = proAmount;
		this.product = product;
	}
	
	public void updateProductAmount(int proAmount) {
		this.productAmount = proAmount;
		//System.out.println("New amount!: " + this.proAmount);
	}
	
	public void updatePro(Product product) {
		this.product = product;
	}

	public int getAmount(){
		return this.productAmount;
	}

}
