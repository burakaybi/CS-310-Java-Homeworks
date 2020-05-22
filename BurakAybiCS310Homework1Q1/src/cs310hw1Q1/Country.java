package cs310hw1Q1;

public class Country {
	
	
	private int population;
	private String countryName;
	private String continent;
	private String city;
	

	public Country()
	{
		super();
	}
	
	public Country( String countryName,String continent,String city,int population	) 
	{
		super();
		
		this.setPopulation(population);
		this.setCountryName(countryName);
		this.setContinent(continent);
		this.setCity(city);
		
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	
	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {

		this.city = city;
	}
	
	

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	
	
}
