package cs310hw1Q1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;




public class BurakJDBCManager {

	
	
	public static void writeIntoTable(ArrayList<Country> countries) {
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Burakbjk1997");		
			for (Country c : countries)
			{
				PreparedStatement ps =  connection.prepareStatement("INSERT into countries (Country,Continent,City,Population) values (?,?,?,?) ");
				ps.setString(1, c.getCountryName());
				ps.setString(2, c.getContinent());
				ps.setString(3, c.getCity());
				ps.setInt(4, c.getPopulation());
				ps.execute();
			}
			
			System.out.println("Data inserted!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	

	}
	
	public static void deleteCountryByID(int countryID) {
	    try {  
	        
	        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root", "Burakbjk1997");
	        PreparedStatement ps = connection.prepareStatement("DELETE FROM countries WHERE ID =?" );
	        
	        ps.setInt(1, countryID);
	        ps.execute();
	        
	    } catch(Exception e) {
	        System.out.println(e);
	    }
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
				Country c = new Country (country, continent, city, population);
				
				countries.add(c);
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
	
	public static void getCountryByID(int countryID)
	{
		
		try {
			Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Burakbjk1997");
			PreparedStatement ps= connection.prepareStatement("SELECT * FROM countries WHERE ID= ?");
			
			ps.setInt(1, countryID);
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) 
			{
				int id= rs.getInt("ID");
				String country= rs.getString("Country");
				String cont= rs.getString("Continent");
				String city = rs.getString("City");
				int pop= rs.getInt("Population");
			
				System.out.println(id+ " - " + country + " - " + cont + " - "+ city + " - "+ pop);
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void updateCountryPopulationByID(int countryID, int population)
	{
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Burakbjk1997");
			PreparedStatement ps = connection.prepareStatement("UPDATE countries SET Population =? WHERE ID =?");
			
			ps.setInt(1 , population);
			ps.setInt(2, countryID);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	
	
	
	
	


}