package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import Generic_Utilities.BaseClass;

public class FetchDataFromDatabaseTest extends BaseClass {
    @Test
	public  void FetchDataFromDatabaseTest() throws Throwable {
		
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details","root","database1");
	    Statement state = conn.createStatement();
	    String query = "select * from student";
	    
	    ResultSet res = state.executeQuery(query);
	    
	    while(res.next())
	    {
	    	System.out.println(res.getInt(1)+"\t"+res.getString(2)+"\t"+res.getString(3)+"\t"+res.getString(4));
	    	
	    }
	    
	}

}
