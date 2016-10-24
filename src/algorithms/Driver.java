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
		app.run();
	}
	
	 private int menu(){ // Menu
	    	System.out.println("-------");
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
	
	private void run() throws IOException
	{
		int option = menu();
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
         option = menu();
		}
	}
	
	private void runBrute()throws IOException
	{
		//the boolean bruteBuilt is initialised at the start of the program as "false". 
		if(bruteBuilt == false)
		{
		brute = new BruteAutoComplete();
		}
		//the boolean is changed to true, this increases speed on repeated reruns of the program, as it only has to read the list in from memory once.
		bruteBuilt =  true;
		System.out.println("Please enter string: ");
		System.out.println("==>:  ");
		String prefix = input.nextLine();
		prefix = input.nextLine();
		System.out.println("How many matches would you like?: ");
		System.out.println("==>:  ");
		int k = input.nextInt();
		System.out.println(brute.matches(prefix, k));	
	}
	
	private void runQuick()
	{
		System.out.println("<== To Be Continued");
	}
}
