import java.util.Scanner;

public class Demo
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

		int selection=6 ;

		Customer customer;
		customer = new Customer("Nick Chiotis","6912345678","something@yahoo.com",1997,5,13);
		customer = new Customer("Martha Pontika ","6900002783","mpmp@gmail.com",1980,3,20);
		customer = new Customer("Argyro Sioziou","6956837466","argyro@hotmail.com",1965,7,5);

		Insurance insurance;
		Insurance ins1 = new Insurance(500,2014,5,15,1);
		Insurance ins2 = new Insurance(300,2016,4,20,1);
		Insurance ins3 = new Insurance(550,2015,7,3,2);
		Insurance ins4 = new Insurance(600,2015,10,9,2);
		Insurance ins5 = new Insurance(600,2015,10,9,3);

		ins1.getPayment().payIns(14,6,2014);
		ins2.getPayment().payIns(15,4,2016);
		ins3.getPayment().payIns(15,6,2016);
		ins4.getPayment().payIns(10,11,2015);

		while( selection != 0 )
		{
			System.out.println("====================================================");
			System.out.println("                        MENU                        ");
			System.out.println("====================================================");
			System.out.println("         Please select action:                      \n");
			System.out.println("                                                    ");
			System.out.println("         0. Exit MENU                               \n");
			System.out.println("         1. Print all customers                     \n");
			System.out.println("         2. Print all insurances                    \n");
			System.out.println("         3. Print a customer's insurances           \n");
			System.out.println("         4. Create new insurance                    \n");
			System.out.println("         5. Make a payment                          \n");
			System.out.println("----------------------------------------------------\n\n\n");

			selection = input.nextInt();


			if ( selection == 1 )
			{
				Customer.printCust();
				System.out.print("\n\n\n\n");
			}


			if ( selection == 2 )
			{
				Insurance.printIns();
				System.out.print("\n\n\n\n");
			}


			if ( selection == 3 )
			{
				int cusCode;
				System.out.print("Please enter the customer's code you'd like to search: ");
				cusCode = input.nextInt();
				while ( Customer.existance(cusCode) == false )
				{
					System.out.print("There is no customer with such code.\nPlease enter the right code: ");
					cusCode = input.nextInt();
				}
				Insurance.insDetails(cusCode);
				System.out.print("\n\n\n\n");
			}


			if ( selection == 4 )
			{
				int code;
				String trash;
				System.out.print("To create an insurance please enter the customer's code if the customer is already registed or enter 0 to register a new customer: ");
				code = input.nextInt();
				trash = input.nextLine();

				if ( code == 0 )
				{
					String name;
					String phone;
					String email;
					int bYear;
					int bMonth;
					int bDay;
					System.out.print("Please enter new customer's name: ");
					name = input.nextLine();
					System.out.print("Please enter new customer's phone number: ");
					phone = input.nextLine();
					System.out.print("Please enter new customer's email: ");
					email = input.nextLine();
					System.out.print("Please enter the year of birth: ");
					bYear = input.nextInt();
					System.out.print("Please enter the month of birth: ");
					bMonth = input.nextInt();
					System.out.print("Please enter the day of birth: ");
					bDay = input.nextInt();
					customer = new Customer (name,phone,email,bYear,bMonth,bDay);
					code = customer.getCode();
				}
				else
				{
					while ( Customer.existance(code) == false )
					{
						System.out.print("There is no customer with such code.\nPlease enter the right code: ");
						code = input.nextInt();
					}
				}

				int duration;
				int sYear;
				int sMonth;
				int sDay;

				System.out.println("\nPlease enter insurance details.");
				System.out.print("Please enter insurance duration in days: ");
				duration = input.nextInt();
				System.out.print("Please enter insurance starting year: ");
				sYear = input.nextInt();
				System.out.print("Please enter insurance starting month: ");
				sMonth = input.nextInt();
				System.out.print("Please enter insurance starting day: ");
				sDay = input.nextInt();
				insurance = new Insurance(duration,sYear,sMonth,sDay,code);

				System.out.println("Insurance has been registered successfully!");
				System.out.print("\n\n\n\n");

			}


			if ( selection == 5)
			{
				int insCode;
				int pYear;
				int pMonth;
				int pDay;
				System.out.print("Please enter the code of the ensurance you want to pay: ");
				insCode = input.nextInt();
				System.out.print("Please enter the year of payment: ");
				pYear = input.nextInt();
				System.out.print("Please enter the month of payment: ");
				pMonth = input.nextInt();
				System.out.print("Please enter the day of payment: ");
				pDay = input.nextInt();

				Insurance.getIns(insCode).getPayment().payIns(pDay,pMonth,pYear);
				System.out.print("\n\n\n\n");
			}


		}
	}
}
