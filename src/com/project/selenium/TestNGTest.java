package com.project.selenium;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGTest {
	
	
	@Test()
	public void test1(){
		System.out.println("Third Test method");
	}

	@Test
	public void test2(){
		System.out.println("First test method");
	}
	@BeforeTest 
	public void beforeTest(){
		System.out.println("Before test");
	}
	@BeforeClass
	public void beforeClass(){
		System.out.println("Before class");
	}
	@BeforeSuite
	public void beforeSuit(){
		System.out.println("Before suit");
	}
	@BeforeMethod
	public void beforeMethod(){
	System.out.println("Before method");	
	}
	@Test
	public void test3(){
		System.out.println("Second test method");
	}
	@AfterSuite
	public void afterSuit(){
		System.out.println("After suit");
	}
	@AfterMethod
	public void afterMethod(){
		System.out.println("After Method");
	}
	@AfterClass
	public void afterclass(){
		System.out.println("After class");
	}
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
	

}
