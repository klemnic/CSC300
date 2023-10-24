package net.codejava;

public class UpdatedCommissionClass 
{
	public static void main(String[] args)
	{
		// this variable establishes the number of starting disciples
		int startingDisciples = 13;
		// this number represents the number of disciples trained at a time
        int traineesPerDisciple = 2;
        // this variable is the years it takes to train each disciple
        int yearsToTrain = 3;

        // this code implements my evangelismFunction and determines the years it will take to train the whole world
        long yearsToConvert = evangelismFunction(startingDisciples, traineesPerDisciple, yearsToTrain);
        
        // and here i print my conclusion
        System.out.println("It will take " + yearsToConvert + " years to convert the entire world population to follow our Lord.");
	}
	
	public static long evangelismFunction(int startingDisciples, int traineesPerDisciple, int yearsToTrain) 
	{
		
        long totalDisciples = startingDisciples;
        // this is the world population which we want to convert
        long worldPopulation = 7800000000L;
        // starting at year 0
        int years = 0;

        // this while loop will help me to keep track of the current number of disciples based on births and deaths
        while (totalDisciples < worldPopulation) 
        {
            // this will calculate births (new disciples) based on the number of disciples over 30 years old
            long births = totalDisciples - (totalDisciples / 30);
            // this will calculate deaths based on the number of disciples over 72 years old
            long deaths = totalDisciples / 72;

            // finally, i need to update total disciples with trainees, births, and subtract deaths
            totalDisciples = totalDisciples + (totalDisciples * traineesPerDisciple) + births - deaths;

            years = years + yearsToTrain;

        }

        return years;
    }
}

