package algorithms;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class TermList 
{
	private static final String url = "https://moodle.wit.ie/pluginfile.php/2952941/mod_resource/content/0/wiktionary.txt";
	private ArrayList<Term> termList;

	public TermList(String urlstring) throws IOException
	{
		BufferedReader in = null;
		try{
		termList = new ArrayList<Term>();
		in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
		String inputLine;
		while((inputLine= in.readLine()) != null)
			termList.add(inputLine);
		}
				finally{
					if(in !=null)
						in.close();
				}
			}
	public MakeTerm(String inputLine)
	{
		
	
	}
 
	
	
}
