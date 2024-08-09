package test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2 {
	
	
	@Test(groups= {"Smoke"})
	public void wTest2()
	{
		System.out.println("This is first test of day 2 class");
	}
	
	@Parameters({"URL"})
	@Test(dependsOnMethods= {"wTest2"})
	public void wTest1(String personalURL)
	{
		System.out.println("This is second test of day 2 class");
		System.out.println(personalURL);
	}

	@Test(dependsOnMethods= {"wTest1"})
	public void Day2Test2()
	{
		System.out.println("This is third test of day 2 class");
		System.out.println("This is git brach develop code added");
	}
	
	@BeforeTest
	public void preRquisitesStep()
	{
		System.out.println("I will execute first of Test scope as I am beforeTest annotation");
	}

}
