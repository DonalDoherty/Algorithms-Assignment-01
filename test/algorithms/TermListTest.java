package algorithms;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class TermListTest {
	private TermList terms;
	private Term term1;
	private Term term20;
	private Term term400;
	private Term term9000;
	
	@Before 
	public void setUp() throws IOException 
	{
		terms = new TermList();
		term1 = new Term(5627187200.0, "the");
		term20 = new Term(520250100.0, "her");
		term400 = new Term(21129900.0, "mean");
		term9000 = new Term(494696.0, "insulting");
	}
	
	//Tests 4 different known terms to make sure their weights and text is as expected
	@Test
	public void testMakeList() 
	{
		assertEquals(terms.termList.get(0).getWeight(), term1.getWeight(), 0.01);
		assertEquals(terms.termList.get(0).getText(), term1.getText());
		assertEquals(terms.termList.get(19).getWeight(), term20.getWeight(), 0.01);
		assertEquals(terms.termList.get(19).getText(), term20.getText());
		assertEquals(terms.termList.get(399).getWeight(), term400.getWeight(), 0.01);
		assertEquals(terms.termList.get(399).getText(), term400.getText());
		assertEquals(terms.termList.get(8999).getWeight(), term9000.getWeight(), 0.01);
		assertEquals(terms.termList.get(8999).getText(), term9000.getText());
	}
	
	//Tests to make sure the overall list size is 10000 terms long, which was what was provided to us.
	@Test
	public void testListSize()
	{
		assertEquals(terms.termList.size(), 10000);
	}

}
