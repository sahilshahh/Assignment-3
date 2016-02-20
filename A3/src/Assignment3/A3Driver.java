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
		  
		  ArrayList<Item> shoppingCart = new ArrayList<Item>(); 
		  Clothing shirt = new Clothing("Shirt", 1, 1,1);  //delete after testing
		  Clothing shzrts = new Clothing("Shzrts",1,1,1);
		  Clothing watch = new Clothing("watch",1,1,1);
		  Clothing hat = new Clothing ("hat",1,1,1);
		  shoppingCart.add(hat);
		  shoppingCart.add(shirt);
		  shoppingCart.add(shzrts);
		  shoppingCart.add(watch);
		  
		  Clothing shorts = new Clothing("Shorts",1,1,1);
		  Electronics xbox = new Electronics("xbox",1,1,1,"F","TX");
		  
		  
		  insert(shoppingCart, shorts);
		  insert(shoppingCart, hat);
		  insert(shoppingCart, xbox);
		  
		  update(shoppingCart, xbox, 3);
		  update(shoppingCart, shorts, -1);
		  
		  String[] test = input("This is the	 input              function test 111111");
		  
		  int thisisjustfordebuggingpurposes = 0;
		  
				
	}
	  
	  /*********************************************************************************
	  * Method Name: insert                                                            *
	  * Purpose: takes a new item and inserts it into the arraylist(your shopping cart)*
	  *          in alphabetical order. It can add 2 of the same elements, so that     *
	  *          there are 2 different hats      									   *
	  * Returns: None                                                                  *
	  * 																			   *
	  * questions: if it passes in an existing item should i just add it in again or   *
	  * 		  update the current item quantity. what if the prices are different?  *
	  ******************************************************************************/
	  
	  static void insert(ArrayList<Item> shoppingCart, Item input){ //yash
		  Iterator<Item> i = shoppingCart.iterator();
		  int x = 0;
		  boolean added = false;
		  String inputname = input.getName();
		  inputname = inputname.toUpperCase();
		  
			while (i.hasNext() && !added) 
			{
				boolean incremented = false;
				Item temp = i.next();
				String name = temp.getName();
				name = name.toUpperCase();
				
////////////if the shoppingcart word's first letter is greater than inputname's
//////////first letter then add
				if(name.charAt(0) > inputname.charAt(0))
				{
					shoppingCart.add(x, input);
					added = true;
				}
				
///////if first letter less than input's first letter then increment x
				if(name.charAt(0) < inputname.charAt(0))
				{
					x++;
					incremented = true;
				}
				
				
////////////in case they have the same beginning letters, for example shirts and shorts
				if(name.charAt(0)==inputname.charAt(0))
				{
					for(int y = 1; y<name.length();y++)
					{
						
						if( y<inputname.length() && !added)
						{
							if( (name.charAt(y)>inputname.charAt(y)) )
							{
								shoppingCart.add(x, input);
								added = true;
							}
						}
					}
				}
				
///////////increment x if same beginning but shoppingcart name should come before input name
				if(!added && !incremented)
				{
					x++;
				}
			}

/////in case the item to be added is supposed to be the last entry in arraylist
			if(!added)
			{
				shoppingCart.add(shoppingCart.size(), input);
				added = true;
			}
	  }
	  
	  static void search(){ //sahil
		  
	  }
	  
	  static void delete(){ //sahil
		  
	  }
	  
	  /******************************************************************************
	  * Method Name: update                                                         
	  * Purpose: input item and quantity change and it will update the quantity
	  * 		 as long as the change you want to make is >0.                                                          
	  * Returns: None                                               
	  * 
	  * questions: what if current item quantity = 3 but they want to take 1 out?
	  * 			would -1 be a legal input
	  ******************************************************************************/
	  
	  static void update(ArrayList<Item> shoppingCart, Item input, int change){ //yash
		  Iterator<Item> i = shoppingCart.iterator();
		  
		  if(change>0)
		  {
			  while (i.hasNext()) 
			  {
				  Item temp = i.next();
				  
				  if(temp.getName().equals(input.getName()))
				  {
					  int quantity = temp.getQuantity();
					  quantity = quantity + change;
					  temp.setQuantity(quantity);
				  }
			  }
		  }
	  }
	  

	  static void print(){ //sahil
		  
	  }
	  
	  /******************************************************************************
	  * Method Name: input                                                         
	  * Purpose: takes the whole input line string (comes from read file function)
	  * 		 and splits it into different words which are put in an array of strings
	  * 		 without the spaces                                                               
	  * Returns: array of strings with separate words                                                                
	  ******************************************************************************/
	  
	  static String[] input(String input){ //yash
		  
		  String[] inputs = input.split("\\s+");  
		  return inputs;  
		
	  }
	  
	  static boolean checkErrors(){ //sahil
		  return true;
	  }
	  
	  static String file(){ //yash
		  return null;
	  }
	  
	  
}


// TODO Auto-generated method stub

//Open file; file name specified in args (command line)

//Parse input, take appropriate actions.

//Stub for arraylist.


// General code example for how to iterate an array list. You will have to modify this heavily, to suit your needs.

	//This (above) works because of polymorphism: a determination is made at runtime, 
	//based on the inherited class type, as to which method is to be invoked. Eg: If it is an instance
	// of Grocery, it will invoke the calculatePrice () method defined in Grocery.
