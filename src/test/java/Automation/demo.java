package Automation;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.base;

public class demo extends base {
	@Test
	public void initialise() throws IOException, InterruptedException
	{
		driver = Initialization();	
		System.out.println("TEST2: Signup Page Test");
	}


}
