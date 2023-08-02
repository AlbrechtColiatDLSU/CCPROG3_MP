/*
*	Coliat, Albrecht Aaron Maynard V. - S16B - CCPROG3 MP
*/

/**
*	The public class Recipe is a java program simulating a Recipe for an ice cream product.
* 	It has all of two for each ingredient which allows for mixes and combos.
*	The following parameters are used for the things mentioned above.
*/
public class Recipe {
	/**
	* 	flavor is a String that holds the name of the first flavor of ice cream.
	*/
	private String flavorOne;
	
	/**
	* 	flavor is a String that holds the name of the second flavor of ice cream.
	*/
	private String flavorTwo;
	
	/**
	* 	topping is a String that holds the name of the first topping type.
	*/
	private String toppingOne;
	
	/**
	* 	topping is a String that holds the name of the second topping type.
	*/
	private String toppingTwo;
	
	/**
	* 	topping is a String that holds the name of the first syrup type.
	*/
	private String syrupOne;
	
	/**
	* 	topping is a String that holds the name of the second syrup type.
	*/
	private String syrupTwo;
	
	/**
	* 	flavor is an int that holds the amount needed for the first flavor of ice cream.
	*/
	private int flavorOneAmt;
	
	/**
	* 	flavor is an int that holds the amount needed for the second flavor of ice cream.
	*/
	private int flavorTwoAmt;
	
	/**
	* 	flavor is an int that holds the amount needed for the first topping type.
	*/
	private int toppingOneAmt;
	
	/**
	* 	flavor is an int that holds the amount needed for the second topping type.
	*/
	private int toppingTwoAmt;
	
	/**
	* 	flavor is an int that holds the amount needed for the first syrup type.
	*/
	private int syrupOneAmt;
	
	/**
	* 	flavor is an int that holds the amount needed for the second syrup type.
	*/
	private int syrupTwoAmt;
	
	/**
	*	This is the constructor for the Recipe class. 
	* 	It doesn't accept parameters since the user will fill it up manually and may have different combinations.
	*/
	public Recipe() {
		this.flavorOne = " ";
		this.flavorTwo = " ";
		this.toppingOne = " ";
		this.toppingTwo = " ";
		this.syrupOne = " ";
		this.syrupTwo = " ";
		this.flavorOneAmt = 0;
		this.flavorTwoAmt = 0;
		this.toppingOneAmt = 0;
		this.toppingTwoAmt = 0;
		this.syrupOneAmt = 0;
		this.syrupTwoAmt = 0;
	}
	
	/**
	*	This is a getter for the flavor name.
	*
	*	@return The name of the ice cream flavor.
	*/
	public String getFlavorOne() {
		return this.flavorOne;
	}
	
	/**
	*	This is a getter for the flavor name.
	*
	*	@return The name of the ice cream flavor.
	*/
	public String getFlavorTwo() {
		return this.flavorTwo;
	}
	
	/**
	*	This is a getter for the topping name.
	*
	*	@return The name of the topping type.
	*/
	public String getToppingOne() {
		return this.toppingOne;
	}
	
	/**
	*	This is a getter for the topping name.
	*
	*	@return The name of the topping type.
	*/
	public String getToppingTwo() {
		return this.toppingTwo;
	}
	
	/**
	*	This is a getter for the syrup name.
	*
	*	@return The name of the syrup type.
	*/
	public String getSyrupOne() {
		return this.syrupOne;
	}
	
	/**
	*	This is a getter for the syrup name.
	*
	*	@return The name of the syrup type.
	*/
	public String getSyrupTwo() {
		return this.syrupTwo;
	}
	
	/**
	*	This is a getter for the amount needed for the flavor.
	*
	*	@return The amount needed for the ice cream flavor.
	*/
	public int getFlavorOneAmt() {
		return this.flavorOneAmt;
	}
	
	/**
	*	This is a getter for the amount needed for the flavor.
	*
	*	@return The amount needed for the ice cream flavor.
	*/
	public int getFlavorTwoAmt() {
		return this.flavorTwoAmt;
	}
	
	/**
	*	This is a getter for the amount needed for the topping type.
	*
	*	@return The amount needed for the topping type.
	*/
	public int getToppingOneAmt() {
		return this.toppingOneAmt;
	}
	
	/**
	*	This is a getter for the amount needed for the topping type.
	*
	*	@return The amount needed for the topping type.
	*/
	public int getToppingTwoAmt() {
		return this.toppingTwoAmt;
	}
	
	/**
	*	This is a getter for the amount needed for the syrup type.
	*
	*	@return The amount needed for the syrup type.
	*/
	public int getSyrupOneAmt() {
		return this.syrupOneAmt;
	}
	
	/**
	*	This is a getter for the amount needed for the syrup type.
	*
	*	@return The amount needed for the syrup type.
	*/
	public int getSyrupTwoAmt() {
		return this.syrupTwoAmt;
	}
	
	/**
	*	This is a setter for the flavor name.
	*
	*	@param flavorOne The name of the ice cream flavor.
	*/
	public void setFlavorOne(String flavorOne) {
		this.flavorOne = flavorOne;
	}
	
	/**
	*	This is a setter for the flavor name.
	*
	*	@param flavorTwo The name of the ice cream flavor.
	*/
	public void setFlavorTwo(String flavorTwo) {
		this.flavorTwo = flavorTwo;
	}
	
	/**
	*	This is a setter for the topping name.
	*
	*	@param toppingOne The name of the topping type.
	*/
	public void setToppingOne(String toppingOne) {
		this.toppingOne = toppingOne;
	}
	
	/**
	*	This is a setter for the topping name.
	*
	*	@param toppingTwo The name of the topping type.
	*/
	public void setToppingTwo(String toppingTwo) {
		this.toppingTwo = toppingTwo;
	}
	
	/**
	*	This is a setter for the syrup name.
	*
	*	@param syrupOne The name of the syrup type.
	*/
	public void setSyrupOne(String syrupOne) {
		this.syrupOne = syrupOne;
	}
	
	/**
	*	This is a setter for the syrup name.
	*
	*	@param syrupTwo The name of the syrup type.
	*/
	public void setSyrupTwo(String syrupTwo) {
		this.syrupTwo = syrupTwo;
	}
	
	/**
	*	This is a setter for the amount needed for the ice cream flavor.
	*
	*	@param flavorOneAmt The amount needed for the ice cream flavor.
	*/
	public void setFlavorOneAmt(int flavorOneAmt) {
		this.flavorOneAmt = flavorOneAmt;
	}
	
	/**
	*	This is a setter for the amount needed for the ice cream flavor.
	*
	*	@param flavorTwoAmt The amount needed for the ice cream flavor.
	*/
	public void setFlavorTwoAmt(int flavorTwoAmt) {
		this.flavorTwoAmt = flavorTwoAmt;
	}
	
	/**
	*	This is a setter for the amount needed for the topping type.
	*
	*	@param toppingOneAmt The amount needed for the topping type.
	*/
	public void setToppingOneAmt(int toppingOneAmt) {
		this.toppingOneAmt = toppingOneAmt;
	}
	
	/**
	*	This is a setter for the amount needed for the topping type.
	*
	*	@param toppingTwoAmt The amount needed for the topping type.
	*/
	public void setToppingTwoAmt(int toppingTwoAmt) {
		this.toppingTwoAmt = toppingTwoAmt;
	}
	
	/**
	*	This is a setter for the amount needed for the topping type.
	*
	*	@param syrupOneAmt The amount needed for the topping type.
	*/
	public void setSyrupOneAmt(int syrupOneAmt) {
		this.syrupOneAmt = syrupOneAmt;
	}
	
	/**
	*	This is a setter for the amount needed for the topping type.
	*
	*	@param syrupTwoAmt The amount needed for the topping type.
	*/
	public void setSyrupTwoAmt(int syrupTwoAmt) {
		this.syrupTwoAmt = syrupTwoAmt;
	}
}