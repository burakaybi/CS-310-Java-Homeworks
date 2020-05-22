package hw1q2;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String countryName;
	private String continent;
	private String city;
	private int population;

	public Country()
	{
		super();
	}
	
	public Country(int id, String countryName,String continent,String city,int population	) 
	{
		super();
		this.setId(id);
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return "Country [id=" + id + ", name=" + countryName
                + ", continent=" + continent + ",city=" + city +",population= " +population+" ]";
    }
	

	
	
	

}
