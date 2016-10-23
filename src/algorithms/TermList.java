package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class TermList 
{
	private static final String url = "https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt";
	public List<Term> termList = new ArrayList<Term>();

	public TermList() throws IOException
	{
		makeList();
	}
	
	private void makeList() throws IOException 
	{
		BufferedReader in = null;
		
		try
		{
		//Initialising buffered reader
		in = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
		String inputLine;
		String text;
		double weight;
		//This string that includes an empty tab will be used later, to cause the reader to treat each tab as a new line
		String delims = "	";
		//This makes the input reader ignore the first line, as that contains no useful data
		in.readLine();
		inputLine = null;
			//reading the terms/weights
			while((inputLine= in.readLine()) != null)
			{
				String[] dataList = inputLine.split(delims);
				//This changes the weight, which is in string format, into a double format
				weight = Double.parseDouble(dataList[0]);
				text = dataList[1];
				termList.add(new Term (weight, text));		
			}
		}
				finally
				{
					if(in !=null)
					{
						in.close();
					}
				}
	}
}
