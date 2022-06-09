package com.sleek.stepDefinitions;

import commonUtils.BaseTest;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest {
	@Before()
	public void beforeInitilization() {
		System.out.println("<<<<<<<<<browser Started>>>>>>>>>>>>>");
	}

	@After()
	public void Driverclose() {

		System.out.println("<<<<<<<<<browser close>>>>>>>>>>>>>");
		driver.close();
	}

}
