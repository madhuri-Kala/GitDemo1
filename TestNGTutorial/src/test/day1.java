package test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day1 {

	@AfterClass
	public void afClass() {
		System.out.println("This is after Class of day 1 class");
		System.out.println("This is git demo 1 Y");
	}
	@AfterMethod
	public void afmethod() {
		System.out.println("I will execute after every method this test clas day 1");
	}

	@AfterSuite
	public void afSuite() {
		System.out.println("I will execute at last As I am after suite annotation");
	}

	@AfterTest
	public void lastExecutionStep() {
		System.out.println("I will execute at last test of every test scope");
	}
	

	@BeforeMethod
	public void bfmethod() {
		System.out.println("I will execute before every method this test clas day 1");
	}

	@Test(groups= {"Smoke"})// Here we can grouping the methods using groups annotations
	public void day1Demo() {
		System.out.println("day1Demo Hello");
		Assert.assertTrue(false);
	}

	@Test(timeOut=4000)// Here we can specifically defined the timeOut in ms to particular method using helper annotations  
	public void day1Test() {
		System.out.println("day1Test Bye");
	}
	
	
    @Parameters({"URL"})// here we are calling the global parameter URK which is defined in suite level
	@Test
	public void day1Parameter(String urlname) {
    	// In order to use that variable into this method we need to create a variable passed tht into argument in this method which will take the URL value as string 
		System.out.println("day1Parameter Example");
		System.out.println(urlname);
	}
	
	
	@BeforeClass
	public void bfClass() {
		System.out.println("This is before Class of day 1 class");
	}

}

//---------------------IMP NOTES----------------

//1. @BeforeSuite will be implemented at the start of the Suite of that in our case day1, day2,day3 and day java class belongs to suite scope of "Loan Department". Refer testng.xaml for this.
//2. @AfterSuite will be implemented at the end of the Suite of that in our case day1, day2,day3 and day java class belongs to suite scope of "Loan Department". Refer testng.xaml for this.
//3. @BeforeTest will be implemented at the start of the test of that in our case day1, day2 java class belongs to test scope of "Personal loan". Refer testng.xaml for this.
//4. @AfterTest will be implemented at the end of the test of that in our case day1, day2 java class belongs to test scope of "Personal loan". Refer testng.xaml for this.
//5. @BeforeClass will be implemented at the start of the that class in our case if we put Before class in day1 java class, then it will execute before every test of that class for e.g "day1.java" class. Refer testng.xaml for this.
//6. @AfterClass will be implemented at the end of the that class in our case if we put After class in day1 java class, then it will execute after that class for e.g "day1.java" class. Refer testng.xaml for this.
//7. @BeforeMethod will be implemented at before every method of the class of that Test scope in our case day1 and day2 java class belongs to test scope of "Personal Loan". Refer testng.xaml for this
//8. @AfterMethod will be implemented at after every method of the class of that Test scope in our case day1 and day2 java class belongs to test scope of "Personal Loan". Refer testng.xaml for this
//9. @Test will be implemented at the above of every test case. Refer testng.xaml for this.

// -- IMP- IF CLIENT ASKED TO RUN AFTER EVERY BUILD AS SMOKE TEST IF THE TEST CASES ARE NOT BELONG TO ONE CLASS OR TEST OR PACKAGE. IN THAT CASE WE NEED TO USE GROUP ANNOTATION ON WHICH TEST CASES WE WANT IT IN SMOKE 
// syntax will be @Test(groups={"smoke"}) after that we need to mention this group in testng xml file as well. Please refer testng3.xml for this.

/* SYntax- this for include, we can use the same for exclude using like this <exclude name="Smoke"></exclude>
 *   <groups>
  <run>
  <include name="Smoke"></include>
  </run>
  </groups>
 * */

// In testng there are 3 helper attribute 1. DependsOnMethod- which will tweak the method of execution. Syntax-(dependsOnMethods= {"wTest2"}) or multiple test case is (dependsOnMethods= {"wTest2","wTest1"})
// second is (enabled=false or true) syntax this is helpful when you want to skip one of the test case in your class for e.g. you know there is bug in login so you can skip that test cases using this.
// third one is timeout - Syntax is -(timeOut=4000)


//--- VIMP---Parameterization concepts for setting global properties like Base URL, Username,Password or API Key for Rest api--->

/* For this we can enter this variable using parameter tag in testng.xml file. 
 * This can be achieved at 2 level one at test folder scope level or suite level. 
 * For suite level - you need to define it after suite start tag and before the test start tag. please refer testng.xml for this.
 * For test scope level - you need to define it after test start tag and before another test start tag. please refer testng4.xml for this.
 *  IMP- for this to whoever test cases you need to pass this for that every test cases you need to pass it before @test and passed as this syntax-
 *  @parameter=({"URL"}) and the method which you are passing against this you need pass argument as (String urlname) like this then only you can use this in that method. Please refer java classes for that*/

//<---------------VIMP PARAMETERIZATION ACHEIVED VIA DATAPROVIDER ANNOTATION OF TESTNG- THIS IS USEFUL WHEN WE NEED TO RUN THE TEST CASES WITH MULTIPLE TEST DATA--- >
/*1. for this you need to create a method and before that you need to use @DataProvider annotation
 * 2. Inside that method we need to define the mutidimension array object and need to intialized and assign the value according to how any rows/records
 * are there we need to iterate will go to first array value and second array value will contain the columns means how any data we are providing here.
 * for e.g. if we need to iterate for 3 times which contains 2 columns username and password so syntax for creating  mutidimension array object wiil be-
 * Object [][] data= new  Object [3][2];
 * Please refer day3.java class for see example of that.
 * 3. After this we need to assign the value for each rows. by using this syntax data[0][1]= "firstusername";data[1][1]= "firstpassword"; and so on and so forth for the ramining two records
 * */


//<--------------- how to test parallel using testng xmal file--- >
/*1. for this you need to mention that like this in that respective suite level scope-	<suite name="Loan Department" parallel="tests" thread-count="2">
 * By using syntax- we are saying that we need to run the test parallel with thread count of 2 means we need to run 2 tests run parallel.
 * 2. For this you need to mention that like this in that respective test level scope- <test name="Personal Loan" parallel="classes" thread-count="5">
*  By using syntax- we are saying that we need to run the classes parallel with thread count of 5 means we need to run 5 classes run parallel.*/
 