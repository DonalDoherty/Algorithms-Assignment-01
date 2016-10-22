package algorithms;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class BruteTest {
	private TermList terms;
	private BruteAutoComplete brute;
	@Before
	public void setUp() throws IOException
	{
		terms = new TermList();
	}
	
	//Testing the weightOf method
	@Test
	public void testWeightOf() {
		assertEquals(5627187200.0, brute.weightOf("the"), 0.01);
	}

}
