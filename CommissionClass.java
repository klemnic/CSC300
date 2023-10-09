package net.codejava;

public class CommissionClass 
{
    public static void main(String[] args) 
    {
    	long yearsToConvert = evangelismFunction(13, 2, 3);
        
        System.out.println("It will take " + yearsToConvert + " years to convert the entire world population to follow our Lord.");
        
        
        int disciplesToTrainTogether = fiftyYearConversion(13, 3, 50);
        
        System.out.println("To convert the world population in 50 years, " + disciplesToTrainTogether + " disciples should be trained together at a time.");
    }
    

    public static long evangelismFunction(int startingDisciples, int traineesPerDisciple, int yearsToTrain) 
    {
        long totalDisciples = startingDisciples;
        long worldPopulation = 7700000000L; // Note the 'L' to indicate a long literal
        int years = 0;
        
        while (totalDisciples < worldPopulation) 
        {
            totalDisciples = totalDisciples + (totalDisciples * traineesPerDisciple);
            years = years + yearsToTrain;
        }
        
        return years;
    }
    
    public static int fiftyYearConversion(int startingDisciples, int yearsToTrain, int targetYears) 
    {
        long worldPopulation = 7700000000L;
        int disciplesToTrain = 1;
        
        while (true) 
        {
            long totalDisciples = startingDisciples;
            int years = 0;
            
            while (totalDisciples < worldPopulation && years < targetYears) 
            {
                totalDisciples = totalDisciples + (totalDisciples * disciplesToTrain);
                years = years + yearsToTrain;
            }
            
            if (years <= targetYears) 
            {
                return disciplesToTrain;
            }
            
            disciplesToTrain++;
        }
    }

}
