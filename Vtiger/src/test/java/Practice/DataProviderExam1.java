package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExam1 {
	
	@Test(dataProvider = "getData")
	public void bookTickets(String src, String dest, int numOfPpl) {
		System.out.println("book tickets from "+src+"to"+dest+","+numOfPpl);
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0] = "Honnavara";
		objArr[0][1] = "Bengaluru";
		objArr[0][2] = 4;
		
		objArr[1][0] = "Honnavara";
		objArr[1][1] = "Mysuru";
		objArr[1][2] = 2;
		
		objArr[2][0] = "Honnavara";
		objArr[2][1] = "Hubli";
		objArr[2][2] = 5;
		
		return objArr;
	}

}
