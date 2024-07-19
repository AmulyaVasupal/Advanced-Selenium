package Practice;

import java.util.Date;

import Generic_Utilities.Java_Utility;

public class SystemdateEx {

	public static void main(String[] args) {
		//---------hardcoding--------------
		Date d = new Date();
		String dateAndTime = d.toString();
		System.out.println(dateAndTime);
		
		String YYYY = dateAndTime.split(" ")[5];
		int MM = d.getMonth()+1;
		String DD = dateAndTime.split(" ")[2];
		
		String finalFormat = YYYY+"-"+MM+"-"+DD;
		System.out.println(finalFormat);
		
		//--------generic--------
		Java_Utility jlib = new Java_Utility();
		String date = jlib.getSystemDateAndTime();
		String dateFormat = jlib.getSyatemDateWithFormat();
		
	}

}
