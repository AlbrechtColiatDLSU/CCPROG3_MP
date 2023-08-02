/*
*	Coliat, Albrecht Aaron Maynard V. - S16B - CCPROG3 MP
*/

/**
*	The public class RegularVending is a java program simulating a regular vending machine.
* 	It has all of the basic things like slots, the ability to stock items, and cash.
*	The following parameters are used for the things mentioned above.
* 	This extends the Vending super class.
*/
public class SpecialVending extends Vending {
	public SpecialVending() {
		super();
	}
	
	/**
	*	This is a method for the user to simulate buying a product from the vending machine.
	*	The first step involves the user entering cash and which item they wish to purchase.
	*	If the user selects a customized recipe they will be prompted for the amount of ingredients used.
	*	The item is dispensed as well as the calories and change(if necessary) if the conditions are right.
	*
	*	@param cashPayment is an int array of cash that the user pays.
	*	@param slotIndex is which slot will be accessed.
	*	@return A boolean value if it is successful or not.
	*/
	//Check what its buying first
	// if custom send to different menu if not send to usual and double check if slotIndex is right
	// REHAUL SLOTINDEX HAS TO PICK BETWEEN NORMAL TO RECIPES
	@Override
	public boolean transaction(int[] cashPayment, int slotIndex) {
		int totalAmount = 0;
		
		if(slotIndex > 2 && slotIndex < 9) {
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
		} else if(slotIndex > 0 && slotIndex < 3) {
			
		}
	}
}