package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class MainClass {

	public static void main(String[] args) {
		
		try 
        {

            URL inserturl  =  new URL("http://localhost:8080/BurakAybiCS310Homework2WebService/rest/ProductWebService/addNewProduct/Apple/5.0/3000");


            InputStreamReader reader = new InputStreamReader(inserturl.openStream());

            BufferedReader rd = new BufferedReader(reader);

            while(true)
            {
                String line = rd.readLine();
                if(line==null)
                    break;
                System.out.println(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		try 
        {

            URL delete  =  new URL("http://localhost:8080/BurakAybiCS310Homework2WebService/rest/ProductWebService/deleteProduct/10");
            
            
            InputStreamReader reader = new InputStreamReader(delete.openStream());

            BufferedReader rd = new BufferedReader(reader);

            while(true)
            {
                String line = rd.readLine();
                if(line==null)
                    break;
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		try 
        {

            URL update  =  new URL("http://localhost:8080/BurakAybiCS310Homework2WebService/rest/ProductWebService/updateProductStock/11/25.0/554");
           
            InputStreamReader reader = new InputStreamReader(update.openStream());

            BufferedReader rd = new BufferedReader(reader);

            while(true)
            {
                String line = rd.readLine();
                if(line==null)
                    break;
                System.out.println(line);
            }
             	

        } catch (Exception e) {
            e.printStackTrace();
        }

	}

}
