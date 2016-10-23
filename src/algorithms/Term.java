package algorithms;

public class Term {
	
	private double weight;
	private String text;
	
	
	public Term (double weight, String text)
	{
		this.weight = weight;
		this.text = text;
	}
	
	public String toString()
	{
		return text; 
	}
	
	//getters
	public double getWeight()
	{
		return weight;
	}
	
	public String getText()
	{
		return text;
	}
}
