/* Rishabh Patel
 * 10/15/16
 * CMSC 256 - 001
 * Program Purpose: The purpose of this class is to create private instance data members 
 * that are attributes of each Pokemon. All of the instance data members have setter and 
 * getter methods. It contains an equals method that double checks the name of the pokemon
 * in the array list with the one inputed by the user. The toString() method correctly 
 * prints out the attributes of the pokemon (name, type, category, ability, weaknesses,
 * number, CP, HP, weight and height). This class also implements the comparable and 
 * comparator interfaces. 
 */
import java.util.Comparator; // imports the Comparator interface
import java.util.List;

public class Pokemon implements Comparable<Pokemon>
{
	private String name; // creates a private instance data member called name
	private String type; // creates a private instance data member called type
	private String category; // creates a private instance data member called category
	private String ability; // creates a private instance data member called ability
	private String weaknesses; // creates a private instance data member called weaknesses
	private int number; // creates a private instance data member called number
	private int hP; // creates a private instance data member called HP
	private int cP; // creates a private instance data member called CP
	private double weight; // creates a private instance data member called weight
	private double height; // creates a private instance data member called height

	public Pokemon() // creates a default constructor with no parameters
	{
		name = ""; // sets name equal to an empty string
		type = ""; // sets type equal to an empty string
		category = ""; // sets category equal to an empty string
		ability = ""; // sets ability equal to an empty string
		weaknesses = ""; // sets weaknesses equal to an empty string
		hP = 0; // sets HP equal to 0
		cP = 0; // sets CP equal to 0
		weight = 0.0; // sets weight equal to 0
		height = 0.0; // sets height equal to 0
	}
	
	public Pokemon(String name, String type, String category, String ability, 
			String weaknesses, int number, int hP, int cP, int weight, int height) // creates a parameterized constructor
	{
		this.name = name;
		this.type = type;
		this.category = category;
		this.ability = ability;
		this.weaknesses = weaknesses;
		this.number = number;
		this.hP = hP;
		this.cP = cP;
		this.weight = weight;
		this.height = height;
	}
	
	public String getName() // getter for the variable, name
	{
		return name;
	}

	public void setName(String name) // setter for the variable, name
	{
		this.name = name;
	}

	public String getType() // getter for the variable, type
	{
		return type;
	}

	public void setType(String type) // setter for the variable, type
	{
		this.type = type;
	}

	public String getCategory() // getter for the variable, category
	{
		return category;
	}

	public void setCategory(String category) // setter for the variable, category
	{
		this.category = category;
	}

	public String getAbility() // getter for the variable, ability
	{
		return ability;
	}

	public void setAbility(String ability) // setter for the variable, ability
	{
		this.ability = ability;
	}

	public String getWeaknesses() // getter for the variable, weaknesses
	{
		return weaknesses;
	}

	public void setWeaknesses(String weaknesses) // setter for the variable, weaknesses
	{
		this.weaknesses = weaknesses;
	}

	public int getNumber() // getter for the variable, number
	{
		return number;
	}

	public void setNumber(int number) // setter for the variable, number
	{
		this.number = number;
	}

	public int gethP() // getter for the variable, HP
	{
		return hP;
	}

	public void sethP(int hP) // setter for the variable, HP
	{
		this.hP = hP;
	}

	public int getcP() // getter for the variable, CP
	{
		return cP;
	}

	public void setcP(int cP) // setter for the variable, CP
	{
		this.cP = cP;
	}

	public double getWeight() // getter for the variable, weight
	{
		return weight;
	}

	public void setWeight(double weight) // setter for the variable, weight
	{
		this.weight = weight;
	}

	public double getHeight() // getter for the variable, height
	{
		return height;
	}

	public void setHeight(double height) // setter for the variable, height
	{
		this.height = height;
	}
	
	
	public String toString() // creates a toString method to return the correctly formatted output of the pokemon and it's attributes
	{
		return "NAME: " + name + " TYPE: " + type + " CATEGORY: " + category + 
				" ABILITY: " + ability + " WEAKNESSES: " + weaknesses + " NUMBER: " 
				+ number + " HP: " + hP + " CP: " + cP + " WEIGHT (kg): " + weight + 
				 " HEIGHT (m): " + height + "\n";			
	}
	
	public boolean equals (Object obj) // creates an equals method to cross check user input and the list
	{
		if (obj instanceof Pokemon)
		{
			Pokemon objPokemon = (Pokemon) obj; // creates an object called objPokemon
			if (number == objPokemon.getNumber()) // if number is equal to number of the objPokemon
			{
				return true; // return true
			}
			if (name.equals(objPokemon.getName())) // if name is equal to name of the objPokemon
			{
				return true; // return true
			}
		}
		return false; // else return false
	}
	

	public int compareTo(Pokemon obj)  // creates a compareTo method
	{
		if (this.gethP() > obj.gethP()) // checks which hp is greater than the other one
		{
			return -1;
		}
		else if (this.gethP() < obj.gethP()) // checks which hp is less than the other one
		{
			return 1;
		}
		else // if they are equal return 0
		{
		return 0;
		}
	}
	
	/**
	 * Checks that Pokemon name is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidName()
	{
		boolean isValid = true;
		if (name == null || "".equals(name))
		{
			System.out.println("Invalid Pokemon name: the pokemon name was either null or empty.");
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Checks that Pokemon number is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidNumber()
	{
		boolean isValid = true;
		if (number <= 0)
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon number was either less than or equal to zero.");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon height is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidHeight()
	{
		boolean isValid = true;
		if (height <= 0)
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon height was either less than or equal to zero.");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon weight is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidWeight()
	{
		boolean isValid = true;
		if (weight <= 0)
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon weight was either less than or equal to zero");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon category is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidCategory()
	{
		boolean isValid = true;
		if (category == null || "".equals(category))
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon category was either null or empty.");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon HP is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidhP()
	{
		boolean isValid = true;
		if (hP < 0)
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon HP was either less than or equal to zero");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon CP is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidcP()
	{
		boolean isValid = true;
		if (cP < 0)
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon CP was either less than or equal to zero");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon Ability is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidAbility(List validAbilities)
	{
		boolean isValid = true;
		if(ability.contains(",")) {
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon cannot contain multiple abilities.");
			isValid = false;
		} else if (!validAbilities.contains(ability))
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon ability was not present in valid abilities list.");
			isValid = false;
		}
		return isValid;
	}
	
	/**
	 * Checks that Pokemon Type is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidType()
	{
		boolean isValid = true;
		if (type == null || "".equals(type))
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon type was either null or empty.");
			isValid = false;
		}
		return isValid;
	}

	/**
	 * Checks that Pokemon weaknesses is valid. If invalid, prints error
	 * @return
	 */
	public boolean isValidWeaknesses()
	{
		boolean isValid = true;
		if (weaknesses == null || "".equals(weaknesses))
		{
			System.out.println("Invalid Pokemon [" + name + "]: the pokemon weaknesses was either null or empty.");
			isValid = false;
		}
		return isValid;
	}
}
