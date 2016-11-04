package algorithms;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BruteTest {
	
	private BruteAutoComplete brute;
	private TermList terms;
	private ArrayList<String> results1;
	private ArrayList<String> results2;

	@Before
	public void setUp() throws IOException
	{
		terms = new TermList();
		brute = new BruteAutoComplete();
		//sets up an ArrayList of the top 5 matches for the "th" prefix
		results1 = new ArrayList<String>();
		results1.add(terms.termList.get(0).getText()); //adds the word "the"
		results1.add(terms.termList.get(6).getText()); //adds the word "that"
		results1.add(terms.termList.get(27).getText()); //adds the word "this"
		results1.add(terms.termList.get(32).getText()); //adds the word "they"
		results1.add(terms.termList.get(38).getText()); //adds the word "their"
		//sets up an ArrayList of the top 10 matches for the "we" prefix
		results2 = new ArrayList<String>();
		results2.add(terms.termList.get(33).getText()); //adds the word "were"
		results2.add(terms.termList.get(43).getText()); //adds the word "we"
		results2.add(terms.termList.get(117).getText()); //adds the word "well"
		results2.add(terms.termList.get(135).getText()); //adds the word "went"
		results2.add(terms.termList.get(568).getText()); //adds the word "west"
		results2.add(terms.termList.get(740).getText()); //adds the word "week"
		results2.add(terms.termList.get(1187).getText()); //adds the word "weeks"
		results2.add(terms.termList.get(1285).getText()); //adds the word "wealth"
		results2.add(terms.termList.get(1315).getText()); //adds the word "weather"
		results2.add(terms.termList.get(1347).getText()); //adds the word "weight"

	}
	
	//Testing the weightOf method
	@Test
	public void testWeightOf() 
	{
		assertEquals(5627187200.0, brute.weightOf("the"), 0.01);
		assertEquals(520250100.0, brute.weightOf("her"), 0.01);
		assertEquals(21129900.0, brute.weightOf("mean"), 0.01);
		assertEquals(494696.0, brute.weightOf("insulting"), 0.01);
	}
	
	@Test
	public void testInvalidWeightOf()
	{
		assertEquals(0.0, brute.weightOf("FailureTest"), 0.01);
		assertEquals(0.0, brute.weightOf(""), 0.01);
	}
	
	@Test
	public void testBestMatch()
	{
		assertEquals(terms.termList.get(0).getText(), brute.bestMatch("th"));
		assertEquals(terms.termList.get(19).getText(), brute.bestMatch("her"));
		assertEquals(terms.termList.get(8999).getText(), brute.bestMatch("insultin"));

	}
	
	@Test
	public void testInvalidBestMatch()
	{
		assertEquals(null, brute.bestMatch(null));
		assertEquals(null, brute.bestMatch("FailureTest"));
	}
	
	@Test
	public void testMatches()
	{
		assertEquals(results1, brute.matches("th", 5));
		assertEquals(results2, brute.matches("we", 10));
	}
	
	@Test
	public void testInvalidMatches()
	{
		assertEquals(null, brute.matches(null, 5));
		assertEquals(null, brute.matches("FailureTest", 20000));
		assertEquals(null, brute.matches(null, 30000));
		assertEquals(null, brute.matches("th", -4));
	}

}
