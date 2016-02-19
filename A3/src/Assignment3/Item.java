package Assignment3;

public class Item 
{
//Declare variables for this class. Think about its type: public, protected or private?
	protected String name;
	protected double price;
	protected int quantity;
	protected double weight;
// You will need a constructor (Why?). Create it here.
	
	protected Item(String itemname, double itemprice, int itemquantity, double itemweight)
	{
		name = itemname;
		price = itemprice;
		quantity = itemquantity;
		weight = itemweight;
	}
	
	double calculatePrice () 
	{
		double final_price = 0;
		// Insert price calculation here
		double shipping = .2*weight*quantity;
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
	}

}
