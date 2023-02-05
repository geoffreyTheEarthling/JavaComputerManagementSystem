// -----------------------------------------------------
// Assignment 2
// Geoffrey Jeu
// Written by: Geoffrey Jeu 2210758
// -----------------------------------------------------

// Class Program is used to interact with the user and save the data entered. 
// The user is offered 5 choices: enter new computers and change computer information both require a password, 
// display all computers by a specific brand, display all computers under a certain price, and the last choice is quit the program.


import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		final String PASSWORD = "password";
		int list = 1;
		int counter;
		int option;
		int i = 0;
		Computer[] inventory;
		
		// Welcoming the user:
		System.out.println("== WELCOME TO YOUR CSA: COMPUTER STORE APPLICATION ==\n");
		System.out.print("Please, enter the maximum number of computers that your store can contain: ");
		int maxComputers = sc.nextInt();		
		// Declaring length of array inventory where objects of class Computer will be stored:
		inventory = new Computer[maxComputers]; 
		
		System.out.println("=========================================================================");
		
		do {
			counter=0;
			displayMenu();
			option = sc.nextInt();
			String entry;
			int choice=0;
			
			switch (option) {
			case 1:	// Entering new computers
				int quantity;
				do {
					System.out.print("Please, enter password: ");
					entry = sc.next();
					if(!entry.equals(PASSWORD)) {
						counter++; // Counting how many times a wrong password is entered
						System.out.println("Wrong password");
					} else {
						do {
							System.out.print("How many computers do you want to enter: ");
		     				quantity = sc.nextInt();	
		     				for(i=0; i<inventory.length; i++)
		     		        {
		     					if(inventory[i] == null) {
		     						counter++; // Counting how many indices have no Computer objects stored
		     					} 		     		           
		     		        }		     				
		     				if(quantity > counter) {
		     					System.out.println("Error! The maximum number of computers you can enter is " + counter);
		     					counter = 0;
		     				}else {
		     					for (int j = 1; j <= quantity; j++) {
		     						System.out.println("\n== COMPUTER " + j + " ==");
									System.out.print("Brand: ");
									String brand = sc.next();
									System.out.print("Model: ");
									String model = sc.next();
									System.out.print("Serial number: ");
									long SN = sc.nextLong();
									System.out.print("Price: ");
									double price = sc.nextDouble();
									// Storing computer information into array inventory:
									inventory[list] = new Computer(brand, model, SN, price);	
									list++;
								}		     														
							}		     					
		     				System.out.println();
						}while(quantity > counter);
					} 
				} while(counter < 3 ); // If password is wrong 3 times, user comes back to main menu							
				break;
				
			case 2: // Change information of a computer
				int compNumber;
				String opt="";
				do {
					System.out.print("Please, enter password: ");
					entry = sc.next();
					if(!entry.equals(PASSWORD)) {
						counter++;
						System.out.println("Wrong password");
					} else {		
							System.out.print("Please, enter computer number you wish to update or -1 to quit: ");
							compNumber = sc.nextInt();
							if (compNumber == -1) {
								break;
							}
							else if (inventory[compNumber] == null) {
								System.out.println("There is no computer registered at number " + compNumber);
								System.out.println("Type 'y' to enter another number or 'q' to quit: ");
								opt = sc.next().toLowerCase();
							} else {
								System.out.println();
								// Display information of computer that user wants to access:
								System.out.println(inventory[compNumber].toString());
								System.out.println();
								do {
									System.out.println("\nWhat information would you like to change?");
									System.out.println("    1.  Brand");
									System.out.println("    2.  Model");
									System.out.println("    3.  SN");
									System.out.println("    4.  Price");
									System.out.println("    5.  Quit");
									System.out.print("Enter your choice> ");
									choice = sc.nextInt();
									switch (choice) {
									case 1: // Modifying brand of computer
										System.out.print("Please, enter brand: ");
										String brandMod = sc.next();
										// Registering modification using constructor:
										inventory[compNumber] = new Computer(brandMod, inventory[compNumber].getModel(), 
												inventory[compNumber].getSN(), inventory[compNumber].getPrice());
										// Displaying computer information after modification:
										System.out.println(inventory[compNumber].toString());
										break;
									case 2: // Modifying model of computer
										System.out.print("Please, enter model: ");
										String modelMod = sc.next();
										// Registering modification using constructor:
										inventory[compNumber] = new Computer(inventory[compNumber].getBrand(), modelMod, 
												inventory[compNumber].getSN(), inventory[compNumber].getPrice());
										// Displaying computer information after modification:
										System.out.println(inventory[compNumber].toString());
										break;
									case 3: // Modifying serial number of computer
										System.out.print("Please, enter serial number: ");
										long snMod = sc.nextLong();
										// Registering modification using constructor:
										inventory[compNumber] = new Computer(inventory[compNumber].getBrand(), 
												inventory[compNumber].getModel(), snMod, inventory[compNumber].getPrice());
										// Displaying computer information after modification:
										System.out.println(inventory[compNumber].toString());
										break;
									case 4: // Modifying price of computer
										System.out.print("Please, enter price: ");
										double priceMod = sc.nextDouble();
										// Registering modification using constructor:
										inventory[compNumber] = new Computer(inventory[compNumber].getBrand(), 
												inventory[compNumber].getModel(), inventory[compNumber].getSN(), priceMod);
										// Displaying computer information after modification:
										System.out.println(inventory[compNumber].toString());
										break;
									case 5:	// Quit				 					
										break;
									default:
										System.out.println("Please, enter a number between 1 and 5.");
										break;
									}
								}while(choice !=5);
							}					
					  } 
				}while(counter < 3);				
				break;
			case 3: // Display all computers by a specific brand
				System.out.print("Please, enter brand name: ");
				String brandName = sc.next();
				System.out.println();
				// Calling method to display all computers by specific name:
				findComputersByName(inventory, brandName);	
				break;
			case 4: // Display all computers under a certain price
				System.out.print("Please, enter a value: ");
				double value = sc.nextDouble();
				System.out.println();
				// Calling method to display all computers under a specific value:
				findCheaperThan(inventory, value);
				break;
			case 5: // Quit
				System.out.println("Thank you for using CSA! The application is now closed.");
				System.exit(0);
				break;
			default:
				System.out.println("Error! Please enter an option between 1 and 5");
				break;
			}
		} while (option != 5);
		
		
		sc.close();
		
	}

	private static void findCheaperThan(Computer[] arr, double value) {
		for (Computer element : arr) {
			if (element == null) {}
			else if (element.getPrice() < value) {
	        System.out.println(element.toString() + "\n");
			}
		}	
		
	}

	private static void findComputersByName(Computer[] arr, String brandName) {

		for (Computer element : arr) {
			if (element == null) {}
			else if (element.getBrand().equalsIgnoreCase(brandName)) {
	        System.out.println(element.toString() + "\n");
			}
		}	
	}

	private static void displayMenu() {
		System.out.println("\nWhat do you want to do?");
		System.out.println("   1. Enter new computers (password required)");
		System.out.println("   2. Change information of a computer (password required)");
		System.out.println("   3. Display all computers by a specific brand");
		System.out.println("   4. Display all computers under a certain price");
		System.out.println("   5. Quit");
		System.out.print("Please enter your choice > ");
			
	}

	
}
