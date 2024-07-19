package Practice;

import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(invocationCount = 2)
	public void createContactTest() {
		System.out.println("contact created");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("contact modify");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void deletContactTest() {
		System.out.println("contact deleted");
	}

}
