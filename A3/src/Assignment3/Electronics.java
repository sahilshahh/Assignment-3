package Assignment3;

public class Electronics extends Item 
{
	// Variables, constructors etc. here.
	
	protected boolean fragile;
	protected boolean salestax;
	protected String state;
	
	protected Electronics(String itemname, double itemprice, int itemquantity, double itemweight, String fragileitem, String itemstate) {
		super(itemname, itemprice, itemquantity, itemweight);
		state = itemstate;
		if (fragileitem.equals("F")){
			fragile = true;
		}
		else{
			fragile = false;
		}
		if (itemstate.equals("TX")||itemstate.equals("NM")||itemstate.equals("VA")||itemstate.equals("AZ")||itemstate.equals("AK") ){
			salestax = true;
		}
		else{
			salestax = false;
		}
	}
	
	//Implement calculate price/print methods as necessary
	
	double calculatePrice () 
	{
		double final_price = 0;
		// Insert price calculation here
		double shipping =0;
		double salestax1 = 0;
		if (fragile){
			shipping = (.2*weight*quantity)*.2;
		}
		else{
			shipping = (.2*weight*quantity);
		}
		if (salestax){			//if true no sales tax
			salestax1 =0;
		}
		else{
			salestax1 = .1 * price;
		}
		final_price = price + shipping + salestax1;
		return final_price;
	}
	
	void printItemAttributes () 
	{
		//Print all applicable attributes of this class
		System.out.print("Name: " + name + "\n");
		System.out.print("Price: " + price + "\n");
		System.out.print("Weight: " + weight + "\n");
		System.out.print("Quantity: " + quantity + "\n");
		System.out.print("Fragile" + fragile + "\n");
		System.out.print("State" + state + "\n");
	}

}
