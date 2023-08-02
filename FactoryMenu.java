import java.util.Scanner;

/*
*	Coliat, Albrecht Aaron Maynard V. - S16B - CCPROG3 MP
*/

/**
*	The public class FactoryMenu is a java program simulating a factory menu.
* 	It has a few options, create either a Regular or Special vending machine, test current vending machine, or exit.
*	The following parameters are used for the things mentioned above.
*/
public class FactoryMenu  {
	/**
	*	regularVending is a RegularVending that holds the current settings of a regular vending machine.
	*/
	private RegularVending regularVending;
	
	/**
	*	SpecialVending is a SpecialVending that holds the current settings of a special vending machine.
	*/
	private SpecialVending specialVending;
	
	
	/**
	*	This method creates a regular vending machine to be used as the current active vending machine.
	*
	*	@return A newly created regular vending machine. 
	*/
	public RegularVending createVendingReg() {
		regularVending = new RegularVending();
        return regularVending;
	}
	
	/**
	*	This method creates a special vending machine to be used as the current active vending machine.
	*
	*	@return A newly created special vending machine. 
	*/
	public SpecialVending createVendingSpe() {
		specialVending = new SpecialVending();
        return specialVending;
	}
	
	/**
	*	This method allows the user to choose between testing the Vending Features or the Maintenance Features.
	*	The testing for either features will continue to run in a loop until the user decides to end it.
	*	Once testing is ended, they will return to the main factory menu. 
	*/
	public void testCurrentVending() {
		boolean looper = true;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Now testing the vending machine!");
		
		do{
			System.out.println();
			System.out.println("Please select an option: ");
			System.out.println("1 Vending Features");
			System.out.println("2 Maintenance Features");
			System.out.println("3 Exit");
			
			int option = scanner.nextInt();
			
			
			switch (option) {
				case 1:
					testVendingFeatures();
					break;
				case 2:
					testMaintenanceFeatures();
					break;
				case 3:
					looper = false;
					System.out.println("Stopping testing.");
					break;
				default:
					System.out.println("Invalid input. Please select from the choices.");
					break;
			}
			scanner.nextLine();
		} while (looper == true);
		scanner.close();
	}
	
	/**
	*	This method allows the user to choose between testing the Vending Features or exiting.
	*	The testing for the features will continue to run in a loop until the user decides to end it.
	*	Once testing is ended, they will return to the menu options to choose which features to test. 
	*/
	public void testVendingFeatures() {
		boolean looper = true;
		Scanner scanner = new Scanner(System.in);
		int[] denominations = {1000, 500, 100, 50, 10, 5, 1};
		
		do {
			System.out.println();
			System.out.println("Please select an option: ");
			System.out.println("1 Test the machine");
			System.out.println("2 Print transaction summary");
			System.out.println("3 Exit");
			
			int option = scanner.nextInt();
			
			switch (option) {
				case 1:
					System.out.println("Enter the payment amount");
					int[] cashPayment = new int[7];
					
					//receives payment in denominations
					for (int i = 0; i < 7; i++) {
						System.out.println("Enter the amount for denomination " + denominations[i] + ": ");
						cashPayment[i] = scanner.nextInt();
					}
					
					System.out.println("Enter the slot number: ");
					int slotIndex = scanner.nextInt() - 1;
					
					boolean confirm = regularVending.transaction(cashPayment, slotIndex);
					
					if (confirm == true) {
						System.out.println("Transaction successful!");
					} else {
						System.out.println("Transaction failed! Please try again.");
					}
					break;
					
				case 2:
					regularVending.printTransactionSummary();
					break;
						
				case 3:
					looper = false;
					System.out.println("Exiting testing for vending features. . .");
					break;
				default:
					System.out.println("Invalid input. Please select from the choices.");
					break;
			}
			scanner.nextLine();
		} while (looper == true);
		scanner.close();
	}
	
	/**
	*	This method allows the user to choose between testing the Maintenance Features or exiting.
	*	The testing for the features will continue to run in a loop until the user decides to end it.
	*	Once testing is ended, they will return to the menu options to choose which features to test. 
	*/
	public void testMaintenanceFeatures() {
		boolean looper = true;
		Scanner scanner = new Scanner(System.in);
		int[] denominations = {1000, 500, 100, 50, 10, 5, 1};
		
		do {
			System.out.println();
			System.out.println("Please select an option: ");
			System.out.println("1 Stock an item");
			System.out.println("2 Restock an item");
			System.out.println("3 Refill cash stock");
			System.out.println("4 Print transaction summary");
			System.out.println("5 Exit");
			
			int option = scanner.nextInt();
			
			switch (option) {
				
				case 1:
					//receiving user input for stocking an item
					System.out.println("Enter slot to stock.");
					int stockSlotIndex = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the item name.");
					String stockItemName = scanner.nextLine();
					System.out.println("Enter the calories.");
					int stockCalories = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the price.");
					int stockPrice = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the amount to stock.");
					int stockCurrentAmt = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Sold individually?");
					boolean stockIndividualSell = scanner.nextBoolean();
					scanner.nextLine();
					stockSlotIndex -= 1;
					
					boolean stockSuccess = regularVending.stockItem(stockSlotIndex, stockItemName, stockCalories, stockPrice, stockCurrentAmt, stockIndividualSell);
					if (stockSuccess) {
						System.out.println("Item stocked successfully!");
					} else {
						System.out.println("Failed to stock the item.");
					}
					break;
					
				case 2:
					//receiving user input for restocking an item
					System.out.println("Enter the slot to restock.");
					int restockSlotIndex = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the amount to restock.");
					int restockCurrentAmt = scanner.nextInt();
					scanner.nextLine();
					restockSlotIndex -= 1;
					
					boolean restockSuccess = regularVending.restockItem(restockSlotIndex, restockCurrentAmt);
					if (restockSuccess) {
						System.out.println("Item restocked!");
					} else {
						System.out.println("Failed to restock the item!");
					}
					break;
					
				case 3:
				
					//receiving user input for refilling cash stocks
					System.out.println("1 1000");
					System.out.println("2 500");
					System.out.println("3 100");
					System.out.println("4 50");
					System.out.println("5 10");
					System.out.println("6 5");
					System.out.println("7 1");
					System.out.println("Enter the denomination to refill.");
					int cashIndex = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter the amount to restock.");
					int refillAmount = scanner.nextInt();
					scanner.nextLine();
					cashIndex -= 1;
					
					boolean refillSuccess = regularVending.refillCashStock(cashIndex, refillAmount);
					if (refillSuccess) {
						System.out.println("Cash stock refilled successfully!");
					} else {
						System.out.println("Failed to refill the cash stock.");
					}
					break;
					
				case 4:
					regularVending.printTransactionSummary();
					break;
				
				case 5:
					looper = false;
					break;
					
				default:
					System.out.println("Invalid input. Please select from the choices.");
					break;
			}
			scanner.nextLine();
		} while (looper == true);
		
		scanner.close();
	}
	
	/**
	*	This method closes the Factory Menu by stopping the loop.
	*
	*	@return Will always returns a false to break the loop.
	*/
	public boolean exit() {
		return false;
	}
	
	/**
	*	The main Factory Menu runs in a continues cycle to allow the user to keep picking options.
	*	It will only end once the user selects exit, wherein a variable for the loop is switched to end the program. 
	*
	*	@param args is needed for the main.
	*/
	public static void main(String args[]) {
		FactoryMenu factoryMenu = new FactoryMenu();
		boolean looper = true;
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.println();
			System.out.println("Welcome to Vendor's Vexing Venders!");
			System.out.println("1 Create Regular Vending Machine.");
			System.out.println("2 Create Special Vending Machine. (WIP)");
			System.out.println("3 Test Current Vending Machine.");
			System.out.println("4 Exit");
			System.out.println("Enter choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
				switch (choice) {
					case 1:
						factoryMenu.createVendingReg();
						break;
				
					case 2:
						factoryMenu.createVendingSpe();
						break;
				
					case 3:
						factoryMenu.testCurrentVending();
						break;
				
					case 4:
						looper = factoryMenu.exit();
						break;
					
					default:
						System.out.println("Invalid input. Please select from the choices.");
						break;
						
				}
				scanner.nextLine();
			} while (looper == true);
			scanner.close();
		}
}


