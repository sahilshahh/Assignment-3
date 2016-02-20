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
		//is the given price the price of all items or price of only one
		double totalprice = price * quantity;
		final_price = totalprice + shipping;
		return final_price;
	}
	

	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
		System.out.print("Name: " + name + "\n");
		System.out.print("Price: $" + price + "\n");
		System.out.print("Weight: " + weight + "\n");
		System.out.print("Quantity: " + quantity + "\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	
	
}
