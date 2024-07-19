package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	/**
	 * This Method is used to avoid Duplicates
	 * @return
	 * @author Amulya
	 */
	public int getRandomNum() {
		Random ran = new Random();
		int rnum = ran.nextInt(1000);
		return rnum;
	}
	
	/**
	 * This method is used to get the system date
	 * @author Amulya
	 * @return
	 */
	public String getSystemDateAndTime() {
		
		Date date = new Date();
		String DateTime = date.toString();
		return DateTime;
	}
	
	/**
	 * This method is used to get the system date time with format
	 * @author Amulya
	 * @return
	 */
	public String getSyatemDateWithFormat() {
		Date d = new Date();
		String dateAndTime = d.toString();
		System.out.println(dateAndTime);
		
		String YYYY = dateAndTime.split(" ")[5];
		int MM = d.getMonth()+1;
		String DD = dateAndTime.split(" ")[2];
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		System.out.println(finalFormat);
		return finalFormat;
	}

}
