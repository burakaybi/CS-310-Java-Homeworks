package hw1q2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAManager {
	
	

public static void writeIntoTable(ArrayList<Country> countries) {
		
		
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("countries");
			EntityManager entityManager =emf.createEntityManager();
			
			//entityManager.find(Country.class, countries);
			
			
			//entityManager.persist(countries);
			
			
			for (Country c : countries)
			{
				entityManager.getTransaction().begin();
				entityManager.persist(c);
				entityManager.getTransaction().commit();
				
			} 
			
			
			System.out.println("Data inserted!!!");
		
	

	}
	
	public static void deleteCountryByID(int countryID) {
	    
	        
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("countries");
			EntityManager entityManager =emf.createEntityManager();
			Country c = entityManager.find(Country.class, countryID);
			
			
			entityManager.getTransaction().begin();
			entityManager.remove(c);
			entityManager.getTransaction().commit();
	       
			String deleted= c.toString();
			System.out.println("Data deleted!!!");
	        
			System.out.println("Deleted date" +deleted);
			
	        
	        
	   
	}
	
	public static ArrayList<Country> readFromFile(String filename)
	{
		ArrayList<Country> countries 
		= new ArrayList<Country>();
		try 
		{
			FileReader reader = new FileReader(filename);
			BufferedReader bfr = new BufferedReader(reader);
			while(true)
			{
				String line = bfr.readLine();
				if (line == null)
				{
					break;
				}
				//System.out.println(line);
				String[] arr = line.split(",");
				String country = arr[0];
				String continent= arr[1];
				String city =arr[2];
				int population = Integer.parseInt(arr[3]);
				Country s = new Country (0, country, continent, city, population);
				
				countries.add(s);
			}
			reader.close();
		
		}
		catch (FileNotFoundException e) {
			System.out.println("no file");
			e.printStackTrace();
		}
		catch (IOException e) {
			System.out.println("no have rights to read that file");
			e.printStackTrace();
		}
		return countries;
	}
	
	
	
	public static Country getCountryByID(int countryID)
	{
		
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("countries");
			EntityManager entityManager =emf.createEntityManager();
			
	        Country country= entityManager.find(Country.class, countryID);
			entityManager.close();
			System.out.println("Get it");
			String info=country.toString();
			System.out.println(info);
			return country;
			
		
	}
	
	public static void updateCountryPopulationByID(int countryID, int population)
	{
		
		
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("countries");
			EntityManager entityManager =emf.createEntityManager();
			
			Country country = entityManager.find(Country.class, countryID);
			
			entityManager.getTransaction().begin();
			country.setPopulation(population);
			entityManager.merge(country);
			
			entityManager.getTransaction().commit();
			
			System.out.println("Data updated!!!");
			
			
		
		
	}

}
