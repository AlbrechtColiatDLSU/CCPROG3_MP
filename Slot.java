/*
*	Coliat, Albrecht Aaron Maynard V. - S16B - CCPROG3 MP
*/

/**
*	The public class Slot is a java program simulating a slot in a vending machine.
* 	It has all of the basic things like .
*	The following parameters are used for the things mentioned above.
*/
public class Slot  {
	/**
	*	item is a String that holds the name of the item currently inside the slot.
	*/
	private String item;
	
	/**
	*	calories is an int that holds the current calories of the item inside the slot.
	*/
	private int calories;
	
	/**
	*	price is an int that holds the current price of the item inside the slot.
	*/
	private int price;
	
	/**
	*	currentAmt is an int that holds the current stock of an item.
	*/
	private int currentAmt;
	
	/**
	*	amtOnRestock is an int that holds the stock of an item when it was restocked.
	*/
	private int amtOnRestock;
	
	/**
	*	individual sell is a boolean that controls which items can be sold individually by a special vending machine.
	*/
	private boolean individualSell;
	
	
	
	/**
	*	This is the constructor for the Slot class. 
	* 	It doesn't accept parameters since there is naturally 8 slots that the user will fill in on their own.
	*/
	public Slot() {
		this.item = " ";
		this.calories = 0;
		this.price = 0;
		this.currentAmt = 0;
		this.amtOnRestock = 0;
		this.individualSell = true;
	}
	
	/**
	*	This is a getter for the item variable.
	*
	*	@return The item name.
	*/
	public String getItem() {
		return this.item;
	}
	
	/**
	*	This is a getter for the calories variable.
	*
	*	@return The calories.
	*/
	public int getCalories() {
		return this.calories;
	}
	
	/**
	*	This is a getter for the price variable.
	*
	*	@return The price.
	*/
	public int getPrice() {
		return this.price;
	}
	
	/**
	*	This is a getter for the current amount variable.
	*
	*	@return The current amount.
	*/
	public int getCurrentAmt() {
		return this.currentAmt;
	}
	
	/**
	*	This is a getter for the amount on restock variable.
	*
	*	@return The amount on restock.
	*/
	public int getAmtOnRestock() {
		return this.amtOnRestock;
	}
	
	/**
	*	This is a getter for the individual sell variable.
	*
	*	@return The individual sell.
	*/
	public boolean getIndividualSell() {
		return this.individualSell;
	}
	
	/**
	*	This is a setter for the item variable.
	*
	*	@param item The name of the item the user inputs.
	*/
	public void setItem(String item) {
		this.item = item;
	}
	
	/**
	*	This is a setter for the calories variable.
	*
	*	@param calories The amount of calories the user inputs.
	*/
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	/**
	*	This is a setter for the price variable.
	*
	*	@param price The price the user inputs.
	*/
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	*	This is a setter for the current amount variable.
	*
	*	@param currentAmt The current amount that the user inputs or the system modifies.
	*/
	public void setCurrentAmt(int currentAmt) {
		this.currentAmt = currentAmt;
	}
	
	/**
	*	This is a setter for the amount on restock variable.
	*
	*	@param amtOnRestock The amount on restock the user inputs.
	*/
	public void setAmtOnRestock(int amtOnRestock) {
		this.amtOnRestock = amtOnRestock;
	}
	
	/**
	*	This is a setter for the individual sell variable.
	*
	*	@param individualSell The true or false flag that the user inputs.
	*/
	public void setIndividualSell(boolean individualSell) {
		this.individualSell = individualSell;
	}
}