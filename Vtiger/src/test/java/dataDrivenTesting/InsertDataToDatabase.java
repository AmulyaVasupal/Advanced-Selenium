package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataToDatabase {

	public static void main(String[] args) throws Throwable {
		
		Driver drivRef = new Driver();
		
        DriverManager.registerDriver(drivRef);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details","root","database1");
        
        
        Statement state = conn.createStatement();
        String query = "insert into student(first_name,last_name,address) values ('padma','krishna','Bangalore'),('sai','manju','hubli')";
        
        int res = state.executeUpdate(query);
        System.out.println(res);
        //if(res ==1) //for single row
        if(res !=1) //multiple rows
        {
        	System.out.println("data is inserted");
        }
        else
        {
        	System.out.println("data not inserted");
        }
        conn.close();
	
	}

}
