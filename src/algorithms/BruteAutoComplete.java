package algorithms;

import java.io.IOException;
import java.util.ArrayList;
public class BruteAutoComplete implements AutoComplete {
	TermList terms;
	private ArrayList<String> results;

	public BruteAutoComplete() throws IOException{
		terms = new TermList();
	}
   
	// Returns the weight of the term, or 0.0 if no such term.
	@Override
	public double weightOf(String term) 
	{
		//checks to make sure term entered was not null
		if(term != null)
		{
			//checks all 10,000 words against entered term
			for(int i = 0; i<terms.termList.size(); i++)
			{
				if(term.equalsIgnoreCase(terms.termList.get(i).getText()))
				{
					return terms.termList.get(i).getWeight();
				}
				
			}
		}
		
		return 0;
	}

    // Returns the highest weighted matching term, or null if no matching term.
	@Override
	public String bestMatch(String prefix) 
	{
		if(prefix != null)
		{
			for(int i = 0; i<terms.termList.size(); i++)
			{
				if(terms.termList.get(i).getText().startsWith(prefix.toLowerCase()))
				{
					return terms.termList.get(i).getText();
				}
			}
		}
		return null;
	}

    // Returns the highest weighted k matching terms (in descending order of weight), as an
    // iterable.
    // If fewer than k matches, return all matching terms (in descending order
    // of weight).
	@Override
	public Iterable<String> matches(String prefix, int k) {
		results = new ArrayList<String>();
		if(prefix == null)
		{
			return null;
		}
		if(k<terms.termList.size() && k>0)
		{
			for(int i = 0; results.size()<k && i<terms.termList.size(); i++)
			{
				if(terms.termList.get(i).getText().startsWith(prefix.toLowerCase()) && results.size()<k)
				{
					results.add(terms.termList.get(i).getText());
				}
			}
		}
		if(results.size()==0)
		{
			return null;
		}
		return results;
	}

}
