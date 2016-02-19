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
		ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		
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
	  
	  static void insert(){ //sahil
		  
	  }
	  
	  static void search(){ //yash
		  
	  }
	  
	  static void delete(){ //sahil
		  
	  }
	  
	  static void update(){ //yash
		  
	  }
	  
	  static void print(){ //sahil
		  
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
