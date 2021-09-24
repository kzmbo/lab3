
public class Amount {
	public Product pro;
	public int proAmount;
	
	public void updateProAmount(int proAmount) {
		this.proAmount = proAmount;
		//System.out.println("New amount!: " + this.proAmount);
	}
	
	public void updatePro(Product pro) {
		this.pro = pro;
	}
	
	public Amount(Product pro, int proAmount) {
		this.proAmount = proAmount;
		this.pro = pro;
	}
}
