import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	public static HashMap<String, String> productsToAdd = new HashMap<String, String>();

	public static void main(String[] args) throws FileNotFoundException {
		//static ArrayList<String> productsToAdd;
		File priceList = new File("./src/products.txt");
		//File reference priceList is created.
		// NOTE: depending on whether you're using replit or an IDE, be sure to verify that the directory is correct.

		CheckInput check = new CheckInput();
		//Credit to Prof. Cleary

		Scanner inputFile = new Scanner(priceList);
		//products.text File is loaded

		/* Matcher Group Order Theory
		 * Ex Line 1: 6187117(0), Popcorn[Whitespace]Butter(1),6 pkg(2), 3.99(3)
		 *           SKU(0),      Name(1),                     Size(2),  Price(3)
		 * In Actual Match:
		 * 0: Prints entire line.
		 * 1: 6187117
		 * 2: Popcorn
		 * 3: Butter
		 * 4: 6 pkg
		 * 5: 3.99
		 */
		String re = "(\\d+)\\s+((?>\\S+\\s)+)\\s+((?>\\S+\\s)+)\\s+(\\d+\\s\\w+)\\s+(\\d+\\.\\d+)";
		Pattern pt = Pattern.compile(re);
		//Pattern Reference, that abides by the rules provided from String re (Line 28-29)

		Matcher match;
		//Matcher Reference

		String currentSKU = "";
		//String used to get the SKU input from the user.


		System.out.println("Hello~! Please enter the name you wish to name the receipt~!");
		String receiptName = check.getString();

		
		PrintWriter fileOut;
		try {
			fileOut = new PrintWriter(receiptName + ".txt");
		} catch(Exception e) {
			fileOut = new PrintWriter("./src/receipt.txt");
		}
		//PrintWriter reference fileOut is created.
		// NOTE: depending on whether you're using replit or an IDE, be sure to verify that the directory is correct.


		fileOut.println(receiptName);
		fileOut.println("Items\t\t\t\tSubtotal");
		//Writes name and makes two column for Items and Subtotal
		//TODO: add a column for quantity.

		System.out.println("Enter the SKU that you want to add to your cart [Enter Q to pay]: ");
		currentSKU = check.getString();
		//Prompts the user to enter a SKU so that they can add it in their cart.

		Product currentProduct = new Product("","","",0);
		Amount currentAmount = new Amount(currentProduct, 0);
		Cart cart = new Cart();
		//create new objects for product and cart

		// This loop will continue to run unless the user inputs q.
		while(!(currentSKU.equalsIgnoreCase("q"))) {
			priceList = new File("./src/products.txt");
			inputFile = new Scanner(priceList);
			boolean foundMatchingSKU = false;
			int amountDuplicateSKU = 0;

			// This loop compares all SKU in the products.txt with what the user inputted.
			// It will continue to run until the inputted SKU matches with the one in the product.txt
			while(inputFile.hasNextLine()) {
				String temp = inputFile.nextLine();
				match = pt.matcher(temp);
				if(match.find()) {
					for(int i = 0; i < match.groupCount()+1; i++) {
						if (i == 1 && match.group(i).equals(currentSKU)) {
							currentProduct = new Product(match.group(1), match.group(2), match.group(4), Double.parseDouble(match.group(5)));
							//System.out.println(currentProduct.getSKU() + " " + currentProduct.getName() +  " " + currentProduct.getSize() + " " + currentProduct.getPrice()); FOR DEBUGGING PURPOSES
							amountDuplicateSKU = cart.addProduct(currentProduct);
							currentAmount = new Amount(currentProduct, amountDuplicateSKU);
							foundMatchingSKU = true;
							// if there's a matching sku, this boolean will be compared immediately in order for the program to run as intended
							break;
						}
					}
				}
			}


			// if we found the matching SKU, write it to the output file (receipt.txt)
			// if not, nothing get written to the output file. it also prints out "try again"
			if(foundMatchingSKU){
				double subtotal = Math.round( (currentProduct.getPrice() * currentAmount.getAmount()) * 100.0 ) / 100.0;
				productsToAdd.put(currentProduct.getSKU(), currentProduct.getName() + "\t\t\t" + currentAmount.getAmount() + "(@" + currentProduct.getPrice() + ")" + "\t$" +  subtotal);
			}else {
				System.out.println("Try Again!");
			}

			System.out.println("Enter another SKU that you want to add to your cart [Enter Q to pay]: ");
			currentSKU = check.getString();
			inputFile.close();
		}

		for (String i : productsToAdd.values()) { fileOut.println(i); }

		// Closes the program by writing the total of all the products in the cart.
		// closes the output file.
		double total = Math.round( (cart.getTransactionTotal()) * 100.0 ) / 100.0;
		fileOut.println("Total: $" + total);
		fileOut.close();
		System.out.println("You're total is: " + total);
		double owed = total;
		double userPayment;
		while(owed > 0) {
			System.out.println("Please enter the amount you would like to pay: ");
			userPayment = CheckInput.getDouble();
			owed = Math.round((owed - userPayment)* 100.0)/100.0;
			System.out.println("Your new total is: $" + owed);
		}
		owed *= -1;
		int choice;
		System.out.println("Thanks for the tip of: $" + owed + ". We really appreciate it!");
		System.out.println("1. Huh!?");
		System.out.println("2. Wait..WHAT!?");
		System.out.println("3. No!! WAiT!!");
		System.out.println("4. Use infinity gauntlet.");
		choice = CheckInput.getIntRange(1, 4);
		if(choice == 4) {
			System.out.println("*snap*");
			System.out.println("The clerk has vanished. You monster... Your change is: $" + owed);
		}
		else {
			System.out.println("Sorry, no refunds...");
		}
		
	}
}