package com.project.selenium2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest2 {

	@Test()
	public void selenium2_test1(){
		System.out.println("selenium2_Third Test method");
	}

	@Test
	public void selenium2_test2(){
		System.out.println("selenium2_First test method");
	}
	@BeforeTest 
	public void selenium2_beforeTest(){
		System.out.println("selenium2_Before test");
	}
	@BeforeClass
	public void selenium2_beforeClass(){
		System.out.println("selenium2_Before class");
	}
	@BeforeSuite
	public void selenium2_beforeSuit(){
		System.out.println("selenium2_Before suit");
	}
	@BeforeMethod
	public void selenium2_beforeMethod(){
	System.out.println("selenium2_Before method");	
	}
	@Test
	public void selenium2_test3(){
		System.out.println("selenium2_Second test method");
	}
	@AfterSuite
	public void selenium2_afterSuit(){
		System.out.println("selenium2_After suit");
	}
	@AfterMethod
	public void selenium2_afterMethod(){
		System.out.println("selenium2_After Method");
	}
	@AfterClass
	public void selenium2_afterclass(){
		System.out.println("selenium2_After class");
	}
	@AfterTest
	public void selenium2_afterTest(){
		System.out.println("selenium2_After Test");
	}


}
