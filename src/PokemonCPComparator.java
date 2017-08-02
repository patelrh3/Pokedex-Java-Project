import java.util.Comparator;


public class PokemonCPComparator implements Comparator<Pokemon> 
{
	public int compare(Pokemon obj1, Pokemon obj2) 
	{

		if (obj1.getcP() > obj2.getcP()) // checks which cp is greater than the other one
		{
			return -1; // returns -1
		}
		else if (obj1.getcP() < obj2.getcP()) // checks which hp is greater than the other one
		{
			return 1; // returns 1
		}
		else // if they are equal return 0
		{
		return 0;
		}	
	}
}
