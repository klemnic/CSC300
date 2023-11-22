package net.codejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Driver {

	public static void main(String[] args) {
		ArrayList<HumanGroup> disciples = new ArrayList<HumanGroup>();
		HumanGroup firstDisciples = new HumanGroup();
		long totalPopulation = 7700000000L;
		
		firstDisciples.Age = 30;
		firstDisciples.Population = 13;
		firstDisciples.IsDisciple = true;
		disciples.add(firstDisciples);

		long christianPopulation = 13L;
		
		ArrayList<HumanGroup> nonBelievers = new ArrayList<HumanGroup>();
		HumanGroup otherHuman = new HumanGroup();
		otherHuman.Age = 18;
		otherHuman.Population = totalPopulation - christianPopulation;
		nonBelievers.add(otherHuman);
		
		ArrayList<HumanGroup> apprentices = new ArrayList<HumanGroup>();
		
		long totalNewApprentice;
		
		int year = 0;
		while (christianPopulation < totalPopulation && !nonBelievers.isEmpty() && !disciples.isEmpty()) {
			//check who is going to die. remove them
			Iterator<HumanGroup> discipleIt = disciples.iterator();
			while(discipleIt.hasNext()) {
				HumanGroup curr = discipleIt.next();
				if (curr.Age >= Human.MaxAge) {
					discipleIt.remove();
				}
			}
			Iterator<HumanGroup> apprenticeIt = apprentices.iterator();
			while(apprenticeIt.hasNext()) {
				HumanGroup curr = apprenticeIt.next();
				if (curr.Age >= Human.MaxAge) {
					apprenticeIt.remove();
				}
			}
			Iterator<HumanGroup> nonBelieverIt = nonBelievers.iterator();
			while(nonBelieverIt.hasNext()) {
				HumanGroup curr = nonBelieverIt.next();
				if (curr.Age >= Human.MaxAge) {
					nonBelieverIt.remove();
				}
			}
			
			// **UPDATED** checking if there is a new baby, all babies are 0 years old at this moment and accounting for reproduction rate of 3
			// it also includes a variation of birth rates based on age groups
			long totalBaby = 0;
			for (HumanGroup g : disciples) {
			    if (g.Age == Human.AgeOfGivingBirth && year > 0) {
			        // Adjust birth rate based on age
			        double ageFactor = 1.0 - (double) g.Age / Human.MaxAge; // Higher birth rate for younger individuals
			        totalBaby += g.Population * Human.CapOfBaby * Human.BaseBirthRate * ageFactor;
			    }
			}
			for (HumanGroup g : apprentices) {
			    if (g.Age == Human.AgeOfGivingBirth) {
			        // Adjust birth rate based on age
			        double ageFactor = 1.0 - (double) g.Age / Human.MaxAge; // Higher birth rate for younger individuals
			        totalBaby += g.Population * Human.CapOfBaby * Human.BaseBirthRate * ageFactor;
			    }
			}
			for (HumanGroup g : nonBelievers) {
			    if (g.Age == Human.AgeOfGivingBirth) {
			        // Adjust birth rate based on age
			        double ageFactor = 1.0 - (double) g.Age / Human.MaxAge; // Higher birth rate for younger individuals
			        totalBaby += g.Population * Human.CapOfBaby * Human.BaseBirthRate * ageFactor;
			    }
			}

			if (totalBaby > 0) {
			    HumanGroup baby = new HumanGroup();
			    baby.Population = totalBaby;
			    nonBelievers.add(baby);
			}
			
			//check if non-believer can be apprentice, check number of disciples,
			
			totalNewApprentice = 0;
			for(HumanGroup g: disciples) {
				if (g.YearsInTeaching == 0) {
					totalNewApprentice += g.Population * Human.CapOfApprentice;
				}
			}
			//convert nonbeliever to apprentice from younger to older
			Collections.sort(nonBelievers, HumanGroup.ageAscComparator);
			// **UPDATED** loop through all non-believers, and convert all groups until total qualified disciple = 0;
			// check number of qualified non-believers
			nonBelieverIt = nonBelievers.iterator();
			while (nonBelieverIt.hasNext() && totalNewApprentice > 0) {
			    HumanGroup curr = nonBelieverIt.next();
			    if (curr.Age >= Human.AgeAsApprentice) {
			        // Introduce chance here
			        double chance = Math.random(); // generates a random number between 0.0 (inclusive) and 1.0 (exclusive)
			        if (chance <= 0.8) { // 80% chance of accepting the gospel
			            HumanGroup newApprentice = curr.Clone();
			            newApprentice.IsApprentice = true;
			            if (curr.Population <= totalNewApprentice) {
			                nonBelieverIt.remove();
			                totalNewApprentice -= curr.Population;
			            } else {
			                curr.Population -= totalNewApprentice;
			                newApprentice.Population = totalNewApprentice;
			                totalNewApprentice = 0;
			            }
			            apprentices.add(newApprentice);
			        } else {
			            // 20% chance of not accepting the gospel
			            // You can optionally add code here to handle non-believers who do not accept the gospel
			        }
			    }
			}
			
			//check if apprentice graduate from apprenticeship
			//change the isDisciple property, isApprentice
			
			//age increase by 1,
			for(HumanGroup hg: disciples) {
				hg.Aging();
				if (hg.YearsInTeaching >= Human.YearToBeDisciple) {
					hg.YearsInTeaching = 0;
				}
			}
			
			apprenticeIt = apprentices.iterator();
			while(apprenticeIt.hasNext()) {
				HumanGroup curr = apprenticeIt.next();
				curr.Aging();
				if (curr.YearsAsApprentice == Human.YearToBeDisciple) {
					curr.YearsAsApprentice = 0;
					curr.IsApprentice = false;
					curr.IsDisciple = true;
					apprenticeIt.remove();
					disciples.add(curr);
				}
			}
			
			for(HumanGroup hg: nonBelievers) {
				hg.Aging();
			}
			totalPopulation = getPopulation(disciples, nonBelievers, apprentices);
			christianPopulation = getPopulation(disciples);
			year++;
			try {
			    Thread.sleep(100);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("Year " + (2023 + year) + ": Christian population is: " + christianPopulation + ", and total population is "
					+ totalPopulation +". Christians account for " + String.format("%.2f", (((float)christianPopulation / totalPopulation)*100)) + "%."); 
		}
		System.out.println(year);
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis, ArrayList<HumanGroup> non,
	ArrayList<HumanGroup> app) {
		long total = 0;
		for(HumanGroup h: dis) {
			total += h.Population;
		}
		for(HumanGroup h: non) {
			total += h.Population;
		}
		for(HumanGroup h: app) {
			total += h.Population;
		}
		return total;
	}
	
	public static long getPopulation(ArrayList<HumanGroup> dis) {
		long total = 0;
		for(HumanGroup h: dis) {
			total += h.Population;
		}
		return total;
	}

}