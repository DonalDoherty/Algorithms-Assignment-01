package algorithms;

public class Term {
	
	public double weight;
	public String text;
	
	
	public Term (double weight, String text)
	{
		this.weight = weight;
		this.text = text;
	}
	
	public String toString()
	{
		return weight +"	"+ text; 
	}
}
