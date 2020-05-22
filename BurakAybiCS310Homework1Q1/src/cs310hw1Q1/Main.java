package cs310hw1Q1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Country> countries = BurakJDBCManager.readFromFile("world.txt");
		
		
		BurakJDBCManager.writeIntoTable(countries);
		
		
		ArrayList<Country> countries1 =
				
				BurakJDBCManager.readFromFile("world.txt");
		 
				BurakJDBCManager.writeIntoTable(countries1);
				
				
				int countryID=0;
				BurakJDBCManager.getCountryByID(countryID);
				
				BurakJDBCManager.deleteCountryByID(countryID);
				
				int population = 0;
				BurakJDBCManager.updateCountryPopulationByID(countryID, population);
		
		
		

	}

}
