package algorithms;

import java.io.IOException;
import java.util.Scanner;

public class Driver {
	private Scanner input;
	private BruteAutoComplete brute;
	private Boolean bruteBuilt = false;	
	public Driver()
	{
		input = new Scanner(System.in);
	}
	
	public static void main(String[] arg) throws IOException
	{
		Driver app = new Driver();
		app.runMain();
	}
	
	 private int mainMenu(){ // Menu
	    	System.out.println("---MAIN MENU---");
	        System.out.println("Please choose a program");
	        System.out.println("-------");
	        System.out.println("  1) BruteAutoComplete");    
	        System.out.println("  2) QuickAutoComplete");
	        System.out.println("-------");   
	        System.out.println("  0) Exit");
	        System.out.print("==> ");
	        int option = input.nextInt();
	        return option;
	    }
	 
	 private int bruteMenu(){ // Menu
	    	System.out.println("---BRUTE AUTOCOMPLETE---");
	        System.out.println("Please choose a function");
	        System.out.println("-------");
	        System.out.println("  1) Get weight of Term");    
	        System.out.println("  2) Find best match for prefix");
	        System.out.println("  3) Find list of best matches for prefix");
	        System.out.println("-------");   
	        System.out.println("  0) Main Menu");
	        System.out.print("==> ");
	        int option = input.nextInt();
	        return option;
	    }
	
	private void runMain() throws IOException
	{
		int option = mainMenu();
		while (option !=0)
		{
			switch (option)
			{
            case 1:    runBrute();
         	          	break;
            case 2:    runQuick();
                       	break;
            default:    System.out.println("Invalid option entered: " + option);
                        break;
			}
         option = mainMenu();
		}
	}
	
	private void runBrute() throws IOException
	{
		//the boolean bruteBuilt is initialised at the start of the program as "false". 
		if(bruteBuilt == false)
		{
		brute = new BruteAutoComplete();
		}
		//the boolean is changed to true, this increases speed on repeated reruns of the program, as it only has to read the list in from memory once.
		bruteBuilt =  true;
		int option = bruteMenu();
		while (option !=0)
		{
			switch (option)
			{
            case 1:    bruteWeight();
         	          	break;
            case 2:    bruteBest();
                       	break;
            case 3:    bruteList();
           				break;
            default:    System.out.println("Invalid option entered: " + option);
                        break;
			}
         option = bruteMenu();
		}
	}
	
	private void bruteList()throws IOException
	{
		System.out.println("Please enter string: ");
		System.out.println("==>:  ");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("How many matches would you like?: ");
		System.out.println("==>:  ");
		int k = input.nextInt();
		System.out.println(brute.matches(prefix, k));	
	}
	
	private void bruteWeight()throws IOException
	{
		System.out.println("Please enter Term: ");
		System.out.println("==>:  ");
		String term = input.nextLine();
		term = input.nextLine();
		System.out.println(brute.weightOf(term));	
	}
	
	private void bruteBest()throws IOException
	{
		System.out.println("Please enter string: ");
		System.out.println("==>:  ");
		String pref = input.nextLine();
		pref = input.nextLine();
		System.out.println(brute.bestMatch(pref));	
	}
	
	private void runQuick()
	{
		System.out.println("<== To Be Continued");
	}
}
