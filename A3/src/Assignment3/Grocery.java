package Assignment3;

public class Grocery extends Item {

	//variables, constructor here
	protected boolean perishable;
	
	protected Grocery(String itemname, double itemprice, int itemquantity, double itemweight, String itemperish) {
		super(itemname, itemprice, itemquantity, itemweight);
		if (itemperish.equals("P")){
			perishable = true;
		}
		else{
			perishable = false;
		}
	}
	
	//override calculatePrice() if necessary; Implement print methods as necessary	
	// Only re-implement stuff you cannot get from the superclass (Item)
	
	double calculatePrice(){
		double final_price = 0;
		double shipping = 0;
		if (perishable = true){
			shipping = (.2*weight*quantity)*.2;
		}
		else{
			shipping = (.2*weight*quantity);
		}
		final_price = price + shipping;
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
		System.out.print("Name: " + name + "\n");
		System.out.print("Price: " + price + "\n");
		System.out.print("Weight: " + weight + "\n");
		System.out.print("Quantity: " + quantity + "\n");
		System.out.print("Perishable" + perishable + "\n");
	}
	
}
