//This line of code defines the package which my program is built in (organizational)
package net.codejava;

//I ran my algorithm in the Main driver of my program
public class SearchProgamMain 
{

	public static void main(String[] args)
	{
		// I am a big Milwaukee Bucks fan and like to work them into my QA when I can 
		System.out.println(IsAllUnique("Giannis Antetokounmpo"));
		System.out.println(IsAllUnique("Jrue Holiday"));

	}


//HERE IS THE ALGORITHM WHICH COMPLETES THIS ASSIGNMENT
//As you can see, it takes in a string as a parameter and returns a boolean
	public static boolean IsAllUnique(String s)
	{
		//I started by making all characters lower case
		//I will try to avoid using built in functions this semester...
		//But this is a simple one that I have a great deal of familiarity with from Coding II
		s = s.toLowerCase();
		
		
		//My algorithm then proceeds with a for loop which tracks the character index which is being compared to the rest of the string
		//This character index will increase each time the entire string has been searched
		for (int i = 0; i < s.length(); i++)
		{
			//This line of code serves the function of keeping track of the current character as a distinct data value
			//It helped to keep my code organized as I was going along
			char currentChar = s.charAt(i);
			
			//Then, I needed to write a loop that would compare each character in the string to my currentChar
			for (int k = i + 1; k < s.length(); k++)
			{
				//The comparedChar is the char which is being compared to the currentChar at each pass through of my loop
				char comparedChar = s.charAt(k);
				
				//If the chars are the same, return false
				if (currentChar == comparedChar)
				{
					return false;
				}
			}
		}
		
		//otherwise, if none of the chars match, return true :)
		return true;
	}


}


