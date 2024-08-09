package test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day3 {

	@Test
	public void WebLoginCarLoan() {
		System.out.println("WebLoginCarLoan");
	}

	@Test
	public void MobileLoginCarLoan() {
		System.out.println("MobileLoginCarLoan");
	}

	@Parameters({ "URL", "APIKey" })
	@Test
	public void APILoginCarLoan(String carURL, String Key) {
		System.out.println("APILoginCarLoan");
		System.out.println("APILoginCarLoan " + carURL);
		System.out.println("APILoginCarLoan " + Key);

	}

	@Test(dataProvider="getData")
	public void APILoginCarLoan2(String username, String password) {
		System.out.println("APILoginCarLoan2 "+username);
		System.out.println("APILoginCarLoan2 "+password);
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		Object[][] data = new Object[3][2]; // efine the mutidimension array object and need to intialized and assign
											// the value according to how any rows/records

		// This is for first record/row
		
		data[0][0] = "firstUsername"; // Array always starts with 0th index

		data[0][1] = "firstPassword";

		// This is for second record/row

		data[1][0] = "secondUsername";

		data[1][1] = "secondPassword";

		// This is for third record/row

		data[2][0] = "thirdUsername";

		data[2][1] = "thirdPassword";
		
		return data;
	}

	@BeforeSuite
	public void bfSuite() {
		System.out.println("I will execute at first As I am no.1 - after suite annotation");
	}

}
