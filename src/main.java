import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
	public static void main(String[] args) {
		ArrayList<Product> items = new ArrayList<Product>();
		//(Str SKU, Str Name, Str Size, double Price)
		//List to contain all products.
		
		boolean success = false;
		//Will only turn true, if Try Statement runs successfully.
		
		/* Goals of try statement:
		 * Goal 1: Access the provided file products.txt
		 * Goal 2: Extract information from products.txt
		 * Goal 3: Organize information into product(Str SKU, Str Name, Str Type, Str Size, double Price)
		 */
		
		try {
			File priceList = new File("products.txt");
			//File reference priceList is created.
			Scanner in = new Scanner(priceList);
			//products.text File is loaded
			String re = "(\\d+)\\s+((\\w+|\\W+)+)\\s+(\\d+\\s+\\w+)\\s+(\\d+.\\d+)";
			//Regex Pattern Container
			Pattern pt = Pattern.compile(re);
			//Pattern Reference, that abides by the rules provided from String re (Line 28-29)
			Matcher match;
			//Matcher Reference
			
			/* While Statement
			 * 1: Visits every word/line of code via in.hasNext()
			 * 2: Will attempt to group information via matcher.
			 * 3: Will attempt to organize information via product.
			 */
			
			while(in.hasNext()) {
				String temp = in.nextLine();
				match = pt.matcher(temp);
				
				/* Matcher Group Order Theory
				 * Ex Line 1: 6187117(0), Popcorn[Whitespace]Butter(1),6 pkg(2), 3.99(3)
				 *           SKU(0),      Name(1),                     Size(2),  Price(3)
				 * In Actual Match:
				 * 0: Prints entire line.
				 * 1: 6187117
				 * 2: Popcorn                          Butter                                             
				 * 3:                                            
				 * 4: 6 pkg
				 * 5: 3.99
				 */
				Product temPro = new Product("","","",0);
				if(match.find()) {
					for(int i = 0; i < match.groupCount()+1; i++) {
						//System.out.println(i + ":" + match.group(i));	
						if(i==1) {
							temPro.setSKU(match.group(i));
						}else if(i == 2) {
							temPro.setName(match.group(i));
						}else if(i == 4) {
							temPro.setSize(match.group(i));
						}else if(i == 5) {
							temPro.setPrice(Double.parseDouble((match.group(i))));
						}
						items.add(temPro);
						temPro = new Product("","","",0);
					}
				}
				
			}
			//System.out.println(items);
			in.close();
			success = true;
			
		} catch(FileNotFoundException e) {
			System.out.println("Error Infinity: File Not Found. 0~0");
		}
		
		if(success) {
			System.out.println("Hello~! Please enter the name you wish to name the receipt~!");
			Scanner in = new Scanner(System.in);
			CheckInput chk = new CheckInput();
			String receiptName = chk.getString();
			if(receiptName.contains(" ")) {
				receiptName.replace(" ", "");	
			}
			
		}
		
	}
}
