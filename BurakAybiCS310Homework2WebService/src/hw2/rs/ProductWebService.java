package hw2.rs;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;



@Path("ProductWebService")
public class ProductWebService {
	
	@GET
	@Path("addNewProduct/{n}/{p}/{s}")
	public boolean addNewProduct(@PathParam("n") String name, 
			@PathParam("p")double price, @PathParam("s")int stock)
	{
		Product p = new Product(name,price,stock);
		boolean result = JDBCManager.insert(p);
		return result;
	}
	
	
	@GET
	@Path("deleteProduct/{id}")
	public boolean deleteProduct(@PathParam("id")int id) {
		
		boolean result = JDBCManager.delete(id);
       
        return result;
	}
	
	@GET
	@Path("updateProductStock/{id}/{p}/{s}")
	public boolean updateProductStock(@PathParam("id")int id ,@PathParam("p")double price, @PathParam("s")int stock)
	{
		//Product p = new Product(name,price, stock);
		boolean result = JDBCManager.update(id,price,stock);
		return result;
	}
	
	
	
	
	
}