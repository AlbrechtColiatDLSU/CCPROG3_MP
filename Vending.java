/*
*	Coliat, Albrecht Aaron Maynard V. - S16B - CCPROG3 MP
*/

/**
*	The public class Vending is a super class used for simulating a regular and special vending machine.
* 	It has all of the basic things like slots, the ability to stock items, and cash.
*	As well as a special vending machine's functions such as having complex orders.
*	The following parameters are used for the things mentioned above.
*/
public abstract class Vending  {
	/**
	*	slots is a Slot array that serves as the slots in the vending machine. 
	*	There is only 8 slots in each machine.
	*/
	private Slot[] slots = new Slot[8];
	
	/**
	*	denominations is an int array that holds the possible denominations of cash inside the machine. 
	*	This works with cashStock.
	*/
	private int[] denominations = new int[7];
	
	/**
	*	cashStock is an int array that holds the amount of each denomination inside the machine. 
	*	This works with denominations.
	*/
	private int[] cashStock = new int[7];
	
	/**
	*	profits is an int array that holds the amount of each denomination the machine received from customers. 
	*	This works with denominations.
	*/
	private int[] profits;
	
	/**
	*	activeVend is a boolean that signals if this vending machine is the active one in the factory.
	*/
	private boolean activeVend;
	
	
	
	/**
	*	This is the constructor for the Vending class.
	*	The only values pre-set is the denominations.
	*/
	public Vending() {
		slots = new Slot[8];
		for (int i = 0; i < 8; i++) {
			slots[i] = new Slot();
		}
		
		denominations = new int[] {1000, 500, 100, 50, 10, 5, 1};
		cashStock = new int[] {0, 0, 0, 0, 0, 0, 0};
		profits = new int[] {0, 0, 0, 0, 0, 0, 0};
		activeVend = false;
	}
	
	/**
	*	This is a getter for the slots array.
	*
	*	@return The slots of the vending machine.
	*/
	public Slot[] getSlots() {
		return this.slots;
	}
	
	/**
	*	This is a getter for the denominations array.
	*
	*	@return The denominations available inside the machine.
	*/
	public int[] getDenominations() {
		return this.denominations;
	}
	
	/**
	*	This is a getter for the cash stock array.
	*
	*	@return The available cash inside the machine.
	*/
	public int[] getCashStock() {
		return this.cashStock;
	}
	
	
	/**
	*	This is a getter for the profits array.
	*
	*	@return The cash received inside the machine.
	*/
	public int[] getProfits() {
		return this.profits;
	}
	
	/**
	*	This is a getter for the active vend variable.
	*
	*	@return A true or false value if the machine is active or not.
	*/
	public boolean getActiveVend() {
		return this.activeVend;
	}
	
	
	/**
	*	This is a setter for the slots array.
	*
	*	@param slots is the Slot array to be set.
	*/
	public void setSlots(Slot[] slots) {
		this.slots = slots;
	}
	
	/**
	*	This is a setter for the denominations array.
	*
	*	@param denominations is the int array to be set.
	*/
	public void setDenominations(int[] denominations) {
		this.denominations = denominations;
	}
	
	/**
	*	This is a setter for the cashStock array.
	*
	*	@param cashStock is the int array to be set.
	*/
	public void setCashStock(int[] cashStock) {
		this.cashStock = cashStock;
	}
	
	/**
	*	This is a setter for the profits array.
	*
	*	@param profits is the int array to be set.
	*/
	public void setProfits(int[] profits) {
		this.profits = profits;
	}
	
	/**
	*	This is a setter for the activeVend variable.
	*
	*	@param activeVend is the true or false flag that the user inputs.
	*/
	public void setActiveVend(boolean activeVend) {
		this.activeVend = activeVend;
	}
	
	
	
	/**
	*	This is a method for the user to simulate buying a product from the vending machine.
	*	The first step involves the user entering cash and which item they wish to purchase.
	*	The item is dispensed as well as the calories and change(if necessary) if the conditions are right.
	*
	*	@param cashPayment is an int array of cash that the user pays.
	*	@param slotIndex is which slot will be accessed.
	*	@return A boolean value if it is successful or not.
	*/
	public boolean transaction(int[] cashPayment, int slotIndex) {
		int totalAmount = 0;
		
		//checks if payment valid
		if(cashPayment != null && cashPayment.length > 0) {
			
			//checks if slot chosen is valid
			if (slotIndex >= 0 && slotIndex < slots.length) {
				Slot selectedSlot = slots[slotIndex];
				
				//checks if there's stock to sell
				if(selectedSlot.getCurrentAmt() > 0) {
					int holdPrice = selectedSlot.getPrice();
					int totalPayment = 0;
					
					//tallies payment into an integer
					for (int i = 0; i < denominations.length; i++) {
						int denomination = denominations[i]; 
						int tallyingCash = denomination * cashPayment[i]; 
						totalPayment += tallyingCash; 
					}
					
					//checks payment and price
					if (totalPayment >= holdPrice) {
						selectedSlot.setCurrentAmt(selectedSlot.getCurrentAmt() - 1);
						int change = totalPayment - holdPrice;
						
						System.out.println("Dispensing: " + selectedSlot.getItem());
						System.out.println("Calories: " + selectedSlot.getCalories());
						
						//checks for and displays change
						if (change > 0) {
							int[] changeAmount = new int[7];
							
							for (int i = 6; i >= 0; i--) {
								int denomination = denominations[i];
								int counter = change / denomination;
								changeAmount[i] = counter;
								change -= counter * denomination;
							}
							
							System.out.println("Change: " + change);
							
							for(int i = 0; i < denominations.length; i++) {
								int denomination;
								int changeAmt;
								denomination = denominations[i];
								changeAmt = changeAmount[i];
			
								System.out.println("Denomination: " + denomination + ", Change: " + (changeAmt * denomination));
							}
						}
						
						return true;
					} else {
						System.out.println("Not enough payment!");
						return false;
					}
				} else {
					System.out.println("Sorry out of stock!");
					return false;
				}				
			} else {
				System.out.println("Invalid slot!");
				return false;
			}
		} else {
			System.out.println("Invalid cash payment!");
			return false;
		}
	}
	
	/**
	*	This is a method for the user to simulate stocking a product from the vending machine.
	*	The first step involves the user entering a slot.
	*	If the slot is empty will be stocked. 
	*	If it is occupies it will be changed if the user desires.
	*
	*	@param slotIndex is an int for the slot to be managed that the user inputs.
	*	@param itemName is a string that is the item name.
	*	@param calories is an int for the calories.
	*	@param price is an int for the price.
	*	@param currentAmt is an int for the amount of stock the slot will have.
	*	@param individualSell is a boolean to check if it can be sold individually.
	*		
	*	@return A boolean value if it is successful or not.
	*/
	public boolean stockItem(int slotIndex, String itemName, int calories, int price, int currentAmt, boolean individualSell) {
		//checks if slot chosen is valid
		if (slotIndex >= 0 && slotIndex < slots.length) {
			
			//checks if amount to stock is non negative
			if (currentAmt >= 0) {
				
				//checks if the name is valid before setting values and notifying values are set
				if (itemName != null && !itemName.isEmpty()) {
					slots[slotIndex].setItem(itemName);
					slots[slotIndex].setCalories(calories);
					slots[slotIndex].setPrice(price);
					slots[slotIndex].setCurrentAmt(currentAmt);
					slots[slotIndex].setIndividualSell(individualSell);
				
					System.out.println("Item stocked!");
					System.out.println("Slot: " + (slotIndex + 1));
					System.out.println("Item: " + itemName);
					System.out.println("Calories: " + calories);
					System.out.println("Price: " + price);
					System.out.println("Current Stock: " + currentAmt);
					System.out.println("Can be sold individually: " + individualSell);
				return true;
				} else {
					System.out.println("Item name cannot be empty!");
					return false;
				}
			} else {
				System.out.println("Value cannot be negative!");
				return false;
			}
		} else {
			System.out.println("Slot index invalid!");
			return false;
		}
	}
	
	/**
	*	This is a method for the user to simulate restocking a product from the vending machine.
	*	The user entering a slot and the amount they want the stocks to be.
	*	The item if will be restocked based on what the user will input.
	*
	*	@param slotIndex is an int for the slot to be managed that the user inputs.
	*	@param currentAmt is an int for the amount to restock the slot with.
	*	@return A boolean value if it is successful or not.
	*/
	public boolean restockItem(int slotIndex, int currentAmt) {
		
		//checks if slot chosen is valid
		if (slotIndex >= 0 && slotIndex < slots.length) {
			
			//checks if amount to stock is non negative
			if (currentAmt >= 0) {
				slots[slotIndex].setCurrentAmt(currentAmt);
				System.out.println("Slot " + (slotIndex + 1) + ", restocked with " + currentAmt + "!");
				return true;
			} else {
				System.out.println("Value cannot be negative!");
				return false;
			}
		} else {
			System.out.println("Slot index invalid!");
			return false;
		}
	}
	
	/**
	*	This is a method for the user to simulate restocking a cash denomination from the vending machine.
	*	The first step involves the user entering an index of which denomination to refill.
	*	Then they will input an amount to add.
	*	The slot is refilled.
	*
	*	@param cashIndex is a cash index used to pick which denomination to refill.
	*	@param amount is a value for amount of cash to fill the denomination with.
	*	@return A boolean value if it is successful or not.
	*/
	public boolean refillCashStock(int cashIndex, int amount) {
		
		//checks if slot chosen is valid
		if (cashIndex >= 0 && cashIndex < cashStock.length) {
			
			//checks if amount to refill is non negative
			if (amount >= 0){
				int denomination;
				denomination = denominations[cashIndex];
				System.out.println(denomination + " restocked with " + amount + "!");
				cashStock[cashIndex] = amount;
			
				return true;
			}
		} else {
			System.out.println("Incorrect input!");
			return false;
		}
		return false;
	}
	
	/**
	*	This is a method for the user to display the products bought and the profits of the machine.
	*	The first displayed is the products bought.
	*	Then the second displayed is a list of denominations that the machine had received.
	*/
	public void printTransactionSummary() {
		int totalProfit;
		totalProfit = 0;
		
		//first loop to display contents of profits per denomination
		System.out.println("Showing profits!");
		for(int i = 0; i < profits.length; i++) {
			int denomination;
			int profit;
			denomination = denominations[i];
			profit = profits[i];
			totalProfit = (profit * denomination)+ totalProfit;
			
			System.out.println("Denomination: " + denomination + ", Profit: " + (profit * denomination));
		}
		System.out.println("Total Profit: " + totalProfit);
		
		//second loop shows every single slot in the machine regardless of if it is empty or not
		System.out.println();
		System.out.println("Showing Items!");
		for (int i = 0; i < slots.length; i++) {
			Slot slot = slots[i];
			String itemName = slot.getItem();
			int currentAmt = slot.getCurrentAmt();
			int amtOnRestock = slot.getAmtOnRestock();

			System.out.println("Slot " + (i + 1) + ":");
			System.out.println("Item: " + itemName);
			System.out.println("Current Amount: " + currentAmt);
			System.out.println("Amount on Restock: " + amtOnRestock);
			System.out.println();
		}
	}
}