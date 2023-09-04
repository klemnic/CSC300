package net.codejava;

import java.util.*;

public class SalesProgramMain 
{

	public static void main(String[] args) 
	{
		//Here is my data: an array of Salesman objects
		Salesman[] allSales = 
		{
			new Salesman("Giannis", 340),
		    new Salesman("Khris", 220),
		    new Salesman("Jrue", 210),
		    new Salesman("Brook", 110),
		    new Salesman("Bobby", 90),
		    new Salesman("Pat", 230),
		    new Salesman("Grayson", 70),
		    new Salesman("Marjon", 100),
		};
		
		Salesman[] topFiveSalesmen = getTopFive(allSales);

		System.out.println("Top 5 Salesmen:");
        for (Salesman salesman : topFiveSalesmen) 
        {
            System.out.println("Name: " + salesman.name + ", Sales: " + salesman.sales);
        }
	}
	
	//Here I include the necessary code to create a function that finds the top 5 salesman
    public static Salesman[] getTopFive(Salesman[] allSales) 
    {
        //This code sorts the allSales array in descending order of sales
    	//The sort function was included in my java util package
    	//The comparator allows me to create custom comparison logic for Salesman objects based on their sales figures
        Arrays.sort(allSales, new Comparator<Salesman>() 
        {
        	//I was having issues with my code so I did research and found that an override could be a solution
        	//it helps ensure that the getTopFive method in the SalesProgramMain class is correctly overriding...
        	//...a method from the Comparator interface
            @Override
            public int compare(Salesman salesman1, Salesman salesman2) 
            {
                //This compares by sales in descending order
                return Integer.compare(salesman2.sales, salesman1.sales);
            }
        });

        //This creates a new array to store the top 5 salesmen
        int topCount = Math.min(5, allSales.length);
        Salesman[] topFiveSalesmen = Arrays.copyOf(allSales, topCount);

        return topFiveSalesmen;
    }

}
