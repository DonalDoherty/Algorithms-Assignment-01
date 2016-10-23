package algorithms;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BruteTest {
	private BruteAutoComplete brute;
	private Term term1;
	private Term term20;
	private Term term400;
	private Term term9000;
	private TermList terms;
	private ArrayList<Term> results1;

	@Before
	public void setUp() throws IOException
	{
		terms = new TermList();
		brute = new BruteAutoComplete();
		term1 = new Term(5627187200.0, "the");
		term20 = new Term(520250100.0, "her");
		term9000 = new Term(494696.0, "insulting");
		//sets up an arraylist of the top 5 matches for the "th" prefix
		results1 = new ArrayList<Term>();
		results1.add(terms.termList.get(0)); //adds the word "the"
		results1.add(terms.termList.get(6)); //adds the word "that"
		results1.add(terms.termList.get(27)); //adds the word "this"
		results1.add(terms.termList.get(32)); //adds the word "they"
		results1.add(terms.termList.get(38)); //adds the word "their"

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
		assertEquals(term1.toString(), brute.bestMatch("th"));
		assertEquals(term20.toString(), brute.bestMatch("her"));
		assertEquals(term9000.toString(), brute.bestMatch("insultin"));

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
	}
	
	@Test
	public void testInvalidMatches()
	{
		assertEquals(null, brute.matches(null, 5));
		assertEquals(null, brute.matches("FailureTest", 20000));
	}

}
