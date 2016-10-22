package algorithms;

public class BruteAutoComplete implements AutoComplete {
	TermList terms;
   
	// Returns the weight of the term, or 0.0 if no such term.
	@Override
	public double weightOf(String term) {
	if(term != null)
	{
		for(int i = 0; i<terms.termList.size(); i++)
		{
			if(term == terms.termList.get(i).getText())
			{
				return terms.termList.get(i).getWeight();
			}
		}
	}
		return 0.00;
	}

    // Returns the highest weighted matching term, or null if no matching term.
	@Override
	public String bestMatch(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

    // Returns the highest weighted k matching terms (in descending order of weight), as an
    // iterable.
    // If fewer than k matches, return all matching terms (in descending order
    // of weight).
	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
