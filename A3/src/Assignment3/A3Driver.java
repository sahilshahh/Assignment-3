package Assignment3;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
		  
		
		  ArrayList<String> fileinput = new ArrayList<String>();
		  fileinput = file(args[0]);
		  
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
	  
	  
	  /*********************************************************************************
	  * Method Name: insert                                                            
	  * Purpose: takes a new item and inserts it into the arraylist(your shopping cart)
	  *          in alphabetical order. It can add 2 of the same elements, so that     
	  *          there can be 2 different hats      									   
	  * Returns: None                                                                  
	  * 																			   
	  * questions: 1. if it passes in an existing item should i just add it in again or   
	  * 		  update the current item quantity. what if the prices are different?  
	  * 
	  * 		 2. is Hat the same as hat? i did a toupperCase when comparing the strings
	  * 			
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
					System.out.println("The item " + input.getName()+ " was added to the shoppingcart");
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
								System.out.println("The item " + input.getName()+ " was added to the shoppingcart");
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
				System.out.println("The item " + input.getName()+ " was added to the shoppingcart");
			}
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
					  System.out.println("The item " + temp.getName()+" had "+change+" added to its quantity");
				  }
			  }
		  }
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
	  
      /******************************************************************************
	  * Method Name: input                                                         
	  * Purpose: takes the whole input line string(comes from read file function)
	  * 		   and splits it into different words which are put in an array of 
	  * 		   strings without the spaces                                                               
	  * Returns: array of strings with separate words                                                                
	  ******************************************************************************/		  
	  static String[] input(String input){ //yash
			  
		  String[] inputs = input.split("\\s+");  
		  return inputs;  
			
	  }
	  
	  
	  /******************************************************************************
	  * Method Name: checkErrors                                                    *
	  * Purpose: Checks if the input string has any errors                          *
	  * Returns: None                                                               *
	  ******************************************************************************/
	  static boolean checkErrors(String[] transaction){ //sahil
		  if (transaction[0].equals("insert")){
			  if(transaction[1].equals("clothing")){
				  double amount = Double.parseDouble(transaction[3]);
				  if (amount > 0){
					  int amount1 = Integer.parseInt(transaction[4]);
					  if (amount1 >0){
						  double amount2 = Double.parseDouble(transaction[5]);
						  if (amount2 > 0){
							  return true;
						  }
						  else{
							  return false;
						  }
					  }
					  else{
						  return false;
					  }
				  }
				  else{
					  return false;
				  }
			  }
			  if(transaction[1].equals("grocery")){
				  double amount = Double.parseDouble(transaction[3]);
				  if (amount > 0){
					  int amount1 = Integer.parseInt(transaction[4]);
					  if (amount1 >0){
						  double amount2 = Double.parseDouble(transaction[5]);
						  if (amount2 > 0){
							  if (transaction[6].equals("NP")|| transaction[6].equals("P")){
								  return true;
							  }
							  else{
								  return false;
							  }
						  }
						  else{
							  return false;
						  }
					  }
					  else{
						  return false;
					  }
				  }
				  else{
					  return false;
				  }
			  }
			  if(transaction[1].equals("electronics")){
				  double amount = Double.parseDouble(transaction[3]);
				  if (amount > 0){
					  int amount1 = Integer.parseInt(transaction[4]);
					  if (amount1 >0){
						  double amount2 = Double.parseDouble(transaction[5]);
						  if (amount2 > 0){
							  if (transaction[6].equals("F")|| transaction[6].equals("NF")){
								  return true;
							  }
							  else{
								  return false;
							  }
						  }
						  else{
							  return false;
						  }
					  }
					  else{
						  return false;
					  }
				  }
				  else{
					  return false;
				  }
			  }
			  else{
				  return false;
			  }
		  }
		  else if (transaction[0].equals("search")){
			  return true;
		  }
		  else if (transaction[0].equals("delete")){
			  return true;
		  }
		  else if (transaction[0].equals("update")){
			  int amount = Integer.parseInt(transaction[2]);
			  if (amount > 0){
				  return true;
			  }
			  else{
				  return false;
			  }
		  }
		  else if (transaction[0].equals("print")){
			  return true;
		  }
		  else {
			  return false;
		  }
	  }
	  
	  
	  /******************************************************************************
	   * Method Name: file                                                         
	   * Purpose: opens the file and then reads each line until there are no
	   * 		   more lines to read and stores each line as its own
	   *           element in an arraylist.                                                            
	   * Returns: arraylist of every line in the input file, each line is
	   * 		  it's own element in arraylist                                                               
	   ******************************************************************************/
	  static ArrayList<String> file(String filename) //yash
	  {
		  
		  ArrayList<String> inputlines = new ArrayList<String>();
		  
		  try 
			{
				FileReader freader = new FileReader(filename);
				BufferedReader reader = new BufferedReader(freader);
				
				for (String s = reader.readLine(); s != null; s = reader.readLine()) 
				{
					inputlines.add(s);
				}
		
				reader.close();
				return inputlines;
			} 
			catch (FileNotFoundException e) 
			{
				System.err.println ("Error: File not found. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			} catch (IOException e) 
			{
				System.err.println ("Error: IO exception. Exiting...");
				e.printStackTrace();
				System.exit(-1);
			}
		  
		  
		  return null;
	  }
	  
	  

}
