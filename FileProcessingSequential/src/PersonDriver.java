// Using the perosn class to create
// a system to store information about people 
// in a file called person.txt

import java.io.*;
import java.util.Scanner;

public class PersonDriver 
{
	
	public static void main(String[] args) 
	{		
		Scanner scan = new Scanner(System.in);			
				
		String choice = " ";
		//loop as long as the person doesn't choose Q to quit.
		while (choice.charAt(0) != 'q')
		{
			printMenu();  //prints the menu
			choice = scan.nextLine();
			choice = choice.toLowerCase();
			executeMenuChoice(choice.charAt(0));  //calls the appropriate menu action
		}

		scan.close();
	}
	
	public static void printMenu()
	{
		System.out.println("\n-----Please choose from the following -----");
		System.out.println("\t(Q)uit");
		System.out.println("\t(D)isplay list of people");
		System.out.println("\t(A)dd a person");	
		System.out.println("--------------------------------------------");
	}
	
	public static void executeMenuChoice(char choice)
	{
		switch (choice)
		{
		case 'q': 
			System.out.println("Thank you. Goodbye.");
			break;
		case 'd':
			displayPeople();
			break;
		case 'a':			
			savePersonToFile();			
			break;				
		}
	}
	
	public static Person enterPersonData()
	{
		Scanner keyboard = new Scanner(System.in);
		Person p = new Person();
		System.out.println("Enter a value for ID: ");
		p.setID(keyboard.nextInt()); //note we could/should do some validation here...
		keyboard.nextLine(); //clear the endline.
		System.out.println("Enter a value for NAME: ");
		p.setName(keyboard.nextLine());
		System.out.println("Enter a value for AGE: ");
		p.setAge(keyboard.nextInt());  //note we could/should do some validation here...
		keyboard.nextLine(); //clear the endline.
		System.out.println("Enter a value for OCCUPATION: ");
		p.setOccupation(keyboard.nextLine());		
		
		return p;
	}
	
	public static void displayPeople()
	{
		//***********************************************************
		//TODO: Read existing people from file and display to screen
				Scanner inputStream = null;
					try
				{
					inputStream = new Scanner(new File("person.txt"));
						
					while(inputStream.hasNextLine())
						{
							int id = inputStream.nextInt();
							int age = inputStream.nextInt();
							String name = inputStream.next();
							String occupation = inputStream.next();
							
							System.out.println(id + " " + age + " " + name + " " + occupation);
						}
				}
				
					catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
		//***********************************************************
	}
	
	public static void savePersonToFile()
	{
		//***********************************************************
		//TODO: Save to file.
		Person p = enterPersonData();
		
		PrintWriter outputStream = null;
		
		try
		{
			outputStream = new PrintWriter(new FileOutputStream("person.txt", true));
			outputStream.print("\n" + p.getID() + " " + p.getAge() + " " + p.getName() + " " + p.getOccupation());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			outputStream.close();
		}
		//***********************************************************
	}

}