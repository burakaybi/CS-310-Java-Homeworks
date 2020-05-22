package hw1q2;

import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {
		
				ArrayList<Country> countries = JPAManager.readFromFile("world.txt");
		
		
				JPAManager.writeIntoTable(countries);
		
		
				
				
				int countryID=0;
				JPAManager.getCountryByID(countryID);
				JPAManager.deleteCountryByID(countryID);
				
				
				
				int population = 0;
				JPAManager.updateCountryPopulationByID(countryID, population);

	}

}
