package Assignment3;

import java.util.*;

public class A3Driver 
	{

	  public static void main(String[] args) 
	  {
		/* while (file function)
		 * 	instantiate arraylist
		 * 	call input function
		 *  while(checkerror)
		 *  	switch(operation)
		 *  		operations	
		 * */
		  
		  
		// TODO Auto-generated method stub
		
		//Open file; file name specified in args (command line)
		
		//Parse input, take appropriate actions.
		
		//Stub for arraylist.
		  
		//test cases
		ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		Clothing shirt = new Clothing("Shirt", 1, 1,1);  //delete after testing
		Clothing shirt1 = new Clothing("Shirt1", 1, 1,1);  //delete after testing
		Clothing shirt2 = new Clothing("Shirt2", 1, 10,1);  //delete after testing
		shoppingCart.add(shirt);
		shoppingCart.add(shirt1);
		shoppingCart.add(shirt2);
		shoppingCart.add(shirt);
		print(shoppingCart);

		
		// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.
		Iterator<Item> i = shoppingCart.iterator();
		while (i.hasNext()) 
		{
			Item temp = i.next();
			temp.calculatePrice(); 
			temp.printItemAttributes();
			//This (above) works because of polymorphism: a determination is made at runtime, 
			//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
			// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
		}		
	  }
	  
	  static void insert(){ //yash
		  
	  }
	  
	  /******************************************************************************
	  * Method Name: search                                                         *
	  * Purpose: Given the shopping cart and the name of the item, this function    *
	  *          finds the number of items in the shopping cart that match the given*
	  *          name                                                               *
	  * Returns: None                                                               *
	  ******************************************************************************/
	  static void search(ArrayList<Item> shoppingCart, String input){ //sahil
		  Iterator<Item> i = shoppingCart.iterator();
		  int quantity = 0;
		  while (i.hasNext()) 
		  {
			  Item temp = i.next();
			  if (temp.getName().equals(input)){
				  quantity = quantity + temp.getQuantity();
			  }
		  }
		  System.out.print("There are/is " + quantity + " " + input + " in the shopping cart.");
	  }
	  
	  /******************************************************************************
	  * Method Name: delete                                                         *
	  * Purpose: Given the shopping cart and the name of the item, this function    *
	  *          deletes the items in the shopping cart that match the given name   *
	  *          and prints the amount of times that were deleted                   *
	  * Returns: None                                                               *
	  ******************************************************************************/
	  static void delete(ArrayList<Item> shoppingCart, String input){ //sahil
		  Iterator<Item> i = shoppingCart.iterator();
		  ArrayList<Integer> indexlist = new ArrayList<Integer>();
		  int index = 0;
		  int delete = 0;
		  while (i.hasNext()) 
		  {
			  Item temp = i.next();
			  if (temp.getName().equals(input)){
				  indexlist.add(index);
				  delete++;
			  }
			  index++;
		  } 
		  int count =0;
		  Iterator<Item> j = shoppingCart.iterator();
		  while (j.hasNext()) 
		  {			  
		        j.next();
		        if(indexlist.contains(count)){
		            j.remove();
		        }
		        count++;
		  }
		  System.out.print(delete + " " + input + " " + "item/items were/was deleted.");
	  }
	  
	  static void update(){ //yash
		  
	  }
	  
	  /******************************************************************************
	  * Method Name: print                                                          *
	  * Purpose: Given the shopping cart, this function prints out the instance     *
	  *          variables of every item as well as the total price of the item.    *
	  *          It then prints out the total price for the shopping cart           *
	  * Returns: None                                                               *
	  ******************************************************************************/
	  static void print(ArrayList<Item> shoppingCart){ //sahil
			Iterator<Item> i = shoppingCart.iterator();
			double cartprice = 0;
			while (i.hasNext()) 
			{
				Item temp = i.next();
				temp.printItemAttributes();
				double totalprice = temp.calculatePrice();
				cartprice= cartprice + totalprice;
				System.out.print("Total Item Price: $" + totalprice);
				System.out.print("\n");
				System.out.print("\n");
			}
			System.out.print("Total Shopping Cart Price: $" + cartprice);
	  }
	  
	  static String[] input(){ //yash
		return null;  //parse the string into an array
		
	  }
	  
	  static boolean checkErrors(){ //sahil
		  return true;
	  }
	  
	  static String file(){ //yash
		  return null;
	  }
	  
	  
	  
	  

}
