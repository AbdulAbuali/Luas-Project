import java.util.Scanner;
import java.text.DecimalFormat;

public class Application {
	static DecimalFormat money = new DecimalFormat("€0.00");
	static Scanner input = new Scanner(System.in);
	static double price = 0.00;
	static double totalTakings = 0.00;
	static double singleAdult = 1.00;
	static double singleChild = 0.50;
	static int totalSoldTickets;
	static int sinleAdultSold;
	static int returnAdultSold;
	static int singleChildSold;
	static int returnChildSold;
	static double totalSold;
	
	public static void main(String[] args)
	{
		menu();
	}
	
	public static void menu()
	{
		System.out.println("Press 1 for Standard ticket");
		System.out.println("Press 2 for Flexi ticket");
		String choice = input.next();
		
		switch(choice)
		{
		case"1":
		{
			String chosenTicket = "sTicket";
			destination(chosenTicket);
			break;
		}
		case"2":
		{
			String chosenTicket = "fTicket";
			destination(chosenTicket);
			break;
		}
		case"a":
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
	
	public static void destination(String chosenTicket) 
	{
		System.out.println("Please press 1 for first zone");
		System.out.println("Please press 2 for second zone");
		System.out.println("Please press 3 for third zone");
		String chosenZone = input.next();
		ticketType(chosenTicket, chosenZone);
	}
	
	public static void ticketType(String cTicket, String cZone)
	{
		System.out.println("Please select ticket Type.");
		System.out.println("1 for single adult ticket");
		System.out.println("2 for return adult ticket");
		System.out.println("3 for single child ticket");
		System.out.println("4 for return child ticket");
		String chosenTicketType = input.next();
		
		ticketQuantity(cTicket, cZone, chosenTicketType);
	}
	
	public static void ticketQuantity(String cTicket, String cZone, String cTicketType)
	{
		System.out.println("Please enter ticket quantity");
		int quantity = input.nextInt();
		
		payment(cTicket, cZone, cTicketType, quantity);
	}
	
	public static void payment(String cTicket, String cZone, String cTicketType, int quantity)
	{	
		switch (cTicketType)
		{
			case"1":
			{
				cTicketType = "Single Adult";
				price = singleAdult;
				break;
			}
			case"2":
			{
				cTicketType = "Return Adult";
				price = singleAdult * 1.5;
				break;
			}
			case"3":
			{
				cTicketType = "Single Child";
				price = singleChild;
				break;
			}
			case"4":
			{
				cTicketType = "Return Child";
				price = singleChild * 1.5;
				break;
			}
			default:
			{
				System.out.println("Invalid Chosen Option");
				payment(cTicket, cZone, cTicketType, quantity);
				break;
			}
		}
		
		switch (cZone)
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
					payment(cTicket, cZone, cTicketType, quantity);
					break;
				}
		}
		
		price = price * quantity;
		
		output(cTicket, cZone, cTicketType, quantity, price);
	}
	
	public static void output(String cTicket, String cZone, String cTicketType, int quantity, double price)
	{
		System.out.println("--------------------------------------------------");
		System.out.println("Ticket Type:\t" + cTicketType);
		System.out.println("Zones:\t\t" + cZone);
		System.out.println("Price:\t\t" + money.format(price));
		System.out.println("--------------------------------------------------");
		System.out.println("Please enter payment");
		
		double cash = input.nextDouble();
		
		while(cash<price)
		{
			System.out.println("Balance Remaining: \t �" + money.format((price-cash)));
			cash = cash + input.nextDouble();
		}
		
		System.out.println("Transaction Successful. Change is:\t" + money.format((cash - price)));
		totalTakings = totalTakings+price;
		
	}
	
	public static void admin()
	{
		
	}

}