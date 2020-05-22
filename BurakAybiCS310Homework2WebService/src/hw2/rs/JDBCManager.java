package hw2.rs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCManager {
	
	
	public static boolean insert (Product p1) 
	{
		try 
		{
			
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root","Burakbjk1997");
			PreparedStatement ps =  con.prepareStatement("INSERT INTO product (productName,productPrice,productStock) values (?,?,?)");
			ps.setString(1, p1.getName());
			ps.setDouble(2, p1.getPrice());
			ps.setInt(3, p1.getStock());
			int result = ps.executeUpdate();
			
			if(result==1)
			{
				return true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean delete(int id)
	 {
		try {
			
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", "root","Burakbjk1997");
		PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE productID =?" );
		
		ps.setInt(1,id);
        //boolean result= ps.execute();
        int result = ps.executeUpdate();
        
        
        if(result==1) {
        	return true;
        }
        
       
	} catch (Exception e) {
		e.printStackTrace();
	}
		return false;
		
	
	 }
	
	public static boolean update(int id,double price,int stock)
	{
		
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/cs310?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey","root","Burakbjk1997");
			PreparedStatement ps = connection.prepareStatement("UPDATE product SET productPrice=?,productStock=? WHERE productID=?");
			
			ps.setDouble(1 ,price);
			ps.setInt(2,stock);
			ps.setInt(3, id);
			int result = ps.executeUpdate();
			
			if(result==1) {
				return true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
		
	}
	

}
