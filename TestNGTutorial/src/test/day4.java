package test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day4 {
	
	
	@Test(groups= {"Smoke"})
	public void WebLoginHomeLoan()
	{
		System.out.println("WebLoginHomeLoan");
	}
	
	
	@Test(enabled=false)
	public void MobileLoginHomeLoan()
	{
		System.out.println("MobileLoginHomeLoan");
	}
	
	@Parameters({"URL"})
	@Test(groups= {"Smoke"})
	public void APILoginHomeLoan(String uname)
	{
		System.out.println("APILoginHomeLoan");
		System.out.println(uname);
	}
	
	@Test
	public void MobileSignInHomeLoan()
	{
		System.out.println("MobileSignInHomeLoan");
	}
}
