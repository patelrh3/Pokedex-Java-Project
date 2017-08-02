 /* Rishabh Patel
  * 10/15/16
  * CMSC 256 - 001
  * Program Purpose: This class has a main method that calls other methods from the same
  * class and the Pokemon class. Sorts through the array list to satisfy the user with
  * their choice of option
  * 
  */
 import java.io.*;
 import java.util.*;
public class Pokedex 
{
	public static void main (String [] args) // creates a main method
	{ 
		printHeading(); // calls the printHeading method
		readFile(args); // calls the readFile method
		menu(); // calls the menu method
	}
	
	/**
	 * Prints heading at the beginning of the program 
	 */
	public static void printHeading()
	{
		System.out.println("Rishabh Patel"); // prints out my name
		System.out.println("Project 4 - Pokedex"); // prints out the project number and name
		System.out.println("CMSC 256 - 001"); // prints out the course name and number and course section
		System.out.println("10/15/16");
		System.out.println();
	}
	static String line = null; 
	static ArrayList pokemonList = new ArrayList(); // creates an array called pokemonList
	static Pokemon pokemonTemp = new Pokemon(); // creates a Pokemon object call pokemonTemp
	static ArrayList validAbilitiesList = new ArrayList(); //creates an array called validAbilitiesList
	
	/**
	 * Reads list of pokemons from the pokemon text file (input by user)
	 * Reads list of abilities from the abilities text file (input by user) 
	 * @param args
	 */
	public static void readFile(String [] args)
	{
		String fileName;
		if (args != null && args.length > 0 && args[0] != null && !"".equals(args[0]))
		{
			//use the pokemon file name from command line arguments
			fileName = args[0];
		}
		else
		{
			Scanner reader = new Scanner(System.in); // creates a scanner called reader
			System.out.println("Enter the file name: "); // prints out "enter the file name"
			fileName = reader.next(); // assigns the value of the user input to fileName
		}
		
		Scanner reader2 = new Scanner(System.in); //creates a scanner called reader2
		System.out.println("Enter the file name of the abilities: "); 
		String abilitiesFileName = reader2.next();
		
		try {
			FileReader fileReader = new FileReader(abilitiesFileName); // the FileReader called fileReader reads in the file
			BufferedReader bufferedReader = new BufferedReader (fileReader); // the buffered reader reads each line
			while ((line = bufferedReader.readLine()) != null) // creates a while loop 
			{
				String ability = line; //reads ability from the file
				validAbilitiesList.add(ability); //add ability to list of valid abilities
			}
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Please enter a correct file name that exists");
			menu();
		}
		catch (IOException ex)
		{
			System.out.println("Error reding file '" + fileName + "'.");
			System.out.println("Please enter a correct file name that exists");
			menu();
		}

		
		try // creates a try block
		{
			FileReader fileReader = new FileReader(fileName); // the FileReader called fileReader reads in the file
			BufferedReader bufferedReader = new BufferedReader (fileReader); // the buffered reader reads each line
			int lineCount = 1; // creates a count of the line number equal to 1
			
			while ((line = bufferedReader.readLine()) != null) // creates a while loop 
			{
				if (lineCount % 2 == 1) // checks for the lines that are odd
				{
					pokemonTemp = new Pokemon(); // recreates the object Pokemon
					String pokemonLine1 = line; // sets pokemonLine1 equal to the value of line
					//pokemonLine1 = pokemonLine1.replace(" ", ""); // replaces all of the white space with an empty string with no characters
					pokemonLine1 = pokemonLine1.replace("\t", ""); // replaces all of the white space with an empty string with no characters
					pokemonLine1 = pokemonLine1.replace("\r", ""); // replaces all of the white space with an empty string with no characters
					String [] pokemonParts = pokemonLine1.split(":"); // splits pokemonLine1 wherever there are colons
					pokemonTemp.setName(pokemonParts [0].trim()); // sets the name in pokemonTemp
					
					if(pokemonParts[1].trim() != null && !"".equals(pokemonParts[1].trim())) {
						pokemonTemp.setNumber(Integer.parseInt(pokemonParts[1].trim())); // sets the number in pokemonTemp
					}
					if(pokemonParts[2].trim() != null && !"".equals(pokemonParts[2].trim())) {
						pokemonTemp.setHeight(Double.parseDouble(pokemonParts[2].trim())); // sets the height in pokemonTemp
					}
					if(pokemonParts[3].trim() != null && !"".equals(pokemonParts[3].trim())) {
						pokemonTemp.setWeight(Double.parseDouble(pokemonParts[3].trim())); // sets the weight in pokemonTemp
					}
					
					pokemonTemp.setCategory(pokemonParts[4].trim()); // sets the category in pokemonTemp
					
					if(pokemonParts[5].trim() != null && !"".equals(pokemonParts[5].trim())) {
						pokemonTemp.sethP(Integer.parseInt(pokemonParts[5].trim())); // sets the HP in pokemonTemp
					}
					
					if(pokemonParts[6].trim() != null && !"".equals(pokemonParts[6].trim())) {
						pokemonTemp.setcP(Integer.parseInt(pokemonParts[6].trim())); // sets the CP in pokemonTemp
					}
					lineCount += 1; // increments the lineCount
				}
				else
				{
					String pokemonLine2 = line;
					//pokemonLine2 = pokemonLine2.replace(" ", ""); // replaces all of the white space with an empty string with no characters					pokemonLine2 = pokemonLine2.replace("\t", "");
					pokemonLine2 = pokemonLine2.replace("\r", ""); // replaces all of the white space with an empty string with no characters
					pokemonLine2 = pokemonLine2.replace("\\s", ""); // replaces all of the white space with an empty string with no characters
					String [] pokemonParts2 = pokemonLine2.split(":"); // replaces all of the white space with an empty string with no characters
					pokemonTemp.setAbility(pokemonParts2[0].trim()); // sets the ability in pokemonTemp
					pokemonTemp.setType(pokemonParts2[1].trim()); // sets the type in pokemonTemp
					pokemonTemp.setWeaknesses(pokemonParts2[2].trim()); // sets the weaknesses in pokemonTemp
					
					//add to list only if all characteristics are valid
					if (pokemonTemp.isValidName()
							&& pokemonTemp.isValidNumber()
							&& pokemonTemp.isValidHeight()
							&& pokemonTemp.isValidWeight()
							&& pokemonTemp.isValidCategory()
							&& pokemonTemp.isValidhP()
							&& pokemonTemp.isValidcP()
							&& pokemonTemp.isValidAbility(validAbilitiesList)
							&& pokemonTemp.isValidType()
							&& pokemonTemp.isValidWeaknesses())
							{
								pokemonList.add(pokemonTemp);// adds everything in the object pokemonTemp to the array list pokemonList
							}
					lineCount += 1; // increments the lineCount
				}
			}
			bufferedReader.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("Please enter a correct file name that exists");
			menu();
		}
		catch (IOException ex)
		{
			System.out.println("Error reding file '" + fileName + "'.");
			System.out.println("Please enter a correct file name that exists");
			menu();
		}
		System.out.println("List of available pokemon "+ pokemonList);
	}
	
	/** This creates a menu for the user to use to search through the list of Pokemon. 
	 *  It also different conditions and for loops that check whether or not the 
	 *	Pokemon is valid or not. Then it returns it to the user via the console.
	 */
	
	public static void menu()
	{
		// all of the statements below print out the options for the user to read and choose
		System.out.println("Choose one of the following options: ");
		System.out.println("1. Search the playlist by Pokemon name.");
		System.out.println("2. Search the playlist by Pokemon number");
		System.out.println("3. Display all the Pokemon sorted by health points ordered from highest to lowest.");
		System.out.println("4. Display all the Pokemon sorted by combat power ordered from highest to lowest.");
		System.out.println("5. Quit");
		System.out.println("Enter an option of your choice: "); // prints out "enter an option of your choice"
		Scanner reader2 = new Scanner (System.in); // creates a new scanner called reader2
		int chosenOption = reader2.nextInt(); // assigns the value of the user input to the variable chosenOption
		
		
		if (chosenOption == 1) // if the user input equals 1
		{
			Pokemon temp = new Pokemon(); // creates an object called temp
			
			System.out.println("Please enter the name of the pokemon: "); // prints out the statement in quotes
			Scanner reader = new Scanner(System.in); // creates a new scanner called reader 
			String pokemonName = reader.next(); // assigns the value of the user input to the variable pokemonName
			
			temp.setName(pokemonName); // added the variable pokemonName to the object temp
			boolean dataFound = false; // created a boolean equaling false
			for (int i = 0; i < pokemonList.size(); i++) // for loop iterating through the array list pokemonList
			{
				if (pokemonList.get(i).equals(temp)) // if the value for name in pokemon list equals the value in the temp object
				{
					dataFound = true; // change value of dataFound to true
					System.out.println("Pokemon Found: "+pokemonList.get(i)); // print out all the attributes of the pokemon
					break; // break statement to quit
				}
			}

			if (!dataFound) // if true 
			{
				System.out.println("Pokemon name does not exist."); // print the fact that the pokemon does not exist
				menu(); // recursively calls the method menu()
			}
			menu();
		}
		
		else if (chosenOption == 2) // if the user input equals 2
		{
			Pokemon temp = new Pokemon(); // creates an object called temp
			
			System.out.println("Please enter the number of the pokemon: "); // prints out the statement in quotes
			Scanner reader = new Scanner(System.in); // creates a scanner called reader
			int pokemonNumber = reader.nextInt(); // assigns the value of the user input to the variable pokemonNumber
			
			temp.setNumber(pokemonNumber); // added the variable pokemonNumber to the object temp
			boolean dataFound = false; // created a boolean equaling false
			for (int i = 0; i < pokemonList.size(); i++) // for loop iterating through the array list pokemonList
			{
				if (pokemonList.get(i).equals(temp)) 
				{
					System.out.println("Pokemon Found: " + pokemonList.get(i));
					dataFound = true;
					break;
				}
			}
			if (!dataFound)
			{
				System.out.println("Pokemon number does not exist.");
				menu();
			}
			menu();
		}
		
		else if (chosenOption == 3) // if user input equals 3
		{
			Collections.sort(pokemonList); // sort the pokemonList using 
			To method in the Pokemon class
			System.out.println("Here is the list of pokemons sorted by health points from highest to lowest: \n\n" + pokemonList); // prints out the list
			menu();
		}
		
		else if (chosenOption == 4) // if user input equals 4
		{
			Collections.sort(pokemonList, new PokemonCPComparator()); // sort the pokemonList using compare method in Pokemon class
			System.out.println("Here is the list of pokemons sorted by combat power from highest to lowest: \n\n" + pokemonList); // prints out the list
			menu();
		}
		
		else if (chosenOption == 5) // if user input equals 5
		{
			System.exit(0); // quit the program
		}
		
		else
		{
			System.out.println("Your input needs to either \"1, \" \"2, \" \"3, \"4, or \"5. \" Please enter the correct option.");
			menu(); // recursive call to the method menu()
		}
			
	}
}
