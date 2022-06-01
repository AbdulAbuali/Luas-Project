import java.util.Scanner;
import java.text.DecimalFormat;

public class Application2 {
	static DecimalFormat money = new DecimalFormat("€0.00");//To make all payments in Decimal format and have the euro sign on them
	static Scanner input = new Scanner(System.in);//Scanner to let the user input values
	//Global variables
	static double price = 0.00;
	static double singleAdult = 1.00;
	static double singleChild = 0.50;
	static int totalSoldTickets = 0;
	static int singleAdultSold = 0;
	static int returnAdultSold = 0;
	static int singleChildSold = 0;
	static int returnChildSold = 0;
	static double totalSold = 0;
	static boolean backToMenu = false;
	static int pin = 0000;
	
	public static void main(String[] args)//The code is going to run from main method
	{
		menu();
	}
	
	public static void menu()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Press 1 to buy Tickets.");
		System.out.println("Press x to exit.");
		String choice = input.next();
		
		switch(choice)
		{
		case"1":
		{
			ticketType();
			break;
		}
		case"a":
		{
			System.out.println("Please enter the PIN code");
			int enteredPin = input.nextInt();
			/*
			if(enteredPin == pin)
			{
				admin();
			}
			else
			{
				System.out.println("Incorrect PIN code")
			}
			*/
			while(enteredPin!=pin)
			{
				System.out.println("Incorrect PIN code");
				enteredPin = input.nextInt();
			}
			admin();
			break;
		}
		case"x":
		{
			admin();
			break;
		}
		default:
		{
			System.out.println("Invalid Chosen Option");
			menu();
			break;
		}
		}
	}
	
	
	public static void ticketType()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Please select ticket Type.\n");
		System.out.println("1 single adult");
		System.out.println("2 return adult");
		System.out.println("3 single child");
		System.out.println("4 return child");
		String ticketType = input.next();
		
		switch (ticketType)
		{
			case"1":
			{
				ticketType = "Single Adult";
				price = singleAdult;
				break;
			}
			case"2":
			{
				ticketType = "Return Adult";
				price = singleAdult * 1.5;
				break;
			}
			case"3":
			{
				ticketType = "Single Child";
				price = singleChild;
				break;
			}
			case"4":
			{
				ticketType = "Return Child";
				price = singleChild * 1.5;
				break;
			}
			default:
			{
				System.out.println("Invalid Chosen Option");
				ticketType();
				break;
			}
		}
		
		destination(ticketType);
	}
	
	public static void destination(String ticketType) 
	{
		System.out.println("--------------------------------------------------");
		System.out.println("1 for first zone");
		System.out.println("2 for second zone");
		System.out.println("3 for third zone");
		String zones = input.next();
		
		switch (zones)
		{
			case"1":
			{
				price = price * 1;
				break;
			}
			case"2":
			{
				price = price * 2;
				break;
			}
			case"3":
			{
				price = price * 3;
				break;
			}
			default:
			{
				System.out.println("Invalid Chosen Option");
				destination(ticketType);
				break;
			}
		}
		
		ticketQuantity(ticketType, zones);
	}
	
	public static void ticketQuantity(String ticketType, String zones)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("How many tickets do you want to buy?");
		String quantityString = input.next();
		int quantity = Integer.parseInt(quantityString);
		
		payment(ticketType, zones, quantity);
	}
	
	public static void payment(String ticketType, String zones, int quantity)
	{	
		
		price = price * quantity;
		
		output(ticketType, zones, quantity);
	}
	
	public static void output(String ticketType, String zones, int quantity)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Ticket Type:\t" + ticketType);
		System.out.println("Zones:\t\t" + zones);
		System.out.println("Quantity:\t" + quantity);
		System.out.println("Price:\t\t" + money.format(price));
		System.out.println("--------------------------------------------------");
		System.out.println("Please enter payment");
		
		double cash = input.nextDouble();
		
		while(cash<price)
		{
			System.out.println("Balance Remaining:\t" + money.format((price-cash)));
			cash = cash + input.nextDouble();
		}
		
		System.out.println("Transaction Successful. Change is:\t" + money.format((cash - price)));
		totalSold = totalSold+price;
		
		totalSoldTickets = totalSoldTickets + quantity;
		if(ticketType.equals("Single Adult"))
		{
			singleAdultSold = singleAdultSold + quantity;
		}
		else if(ticketType.equals("Return Adult"))
		{
			returnAdultSold = returnAdultSold + quantity;
		}
		else if(ticketType.equals("Return Adult"))
		{
			singleChildSold = singleChildSold + quantity;
		}
		else 
		{
			returnChildSold = returnChildSold + quantity;
		}
		
		totalSold = totalSold + price;
		
		System.out.println("--------------------------------------------------");
		System.out.println("Would you like to go back to menu?");
		System.out.println("1 for yes");
		System.out.println("0 for no");
		
		int yesOrNo = input.nextInt();
		
		if (yesOrNo == 1 )
		{
			backToMenu = true;
		}
		else
		{
			backToMenu = false;
		}
		
		if (backToMenu == true)
		{
			menu();
		}
		else
		{
			System.out.println("Thank you for using our service.");
			System.out.println("System shutting down.");
			System.exit(0);
		}
		
	}
	
	public static void admin()
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Total Tickets Sold:\t\t\t" + totalSoldTickets);
		System.out.println("Total Single Adult Tickets Sold:\t" + singleAdultSold);
		System.out.println("Total Rerutn Adult Tickets Sold:\t" + returnAdultSold);
		System.out.println("Total Signle Child Tickets Sold:\t" + singleChildSold);
		System.out.println("Total Rerutn Child Tickets Sold:\t" + returnChildSold);
		System.out.println("Total Sold\t\t\t\t" + totalSold);
		System.out.println("--------------------------------------------------");
		System.out.println("Enter R to go back to menu.");
		String toMenu = input.next().toLowerCase();
		while(!toMenu.equals("r"))
		{
			System.out.println("Incorrect Option");
			toMenu = input.next().toLowerCase();
		}
		menu();
		
	}

}
