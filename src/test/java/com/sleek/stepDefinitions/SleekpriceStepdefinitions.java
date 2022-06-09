package com.sleek.stepDefinitions;

import java.io.FileOutputStream;
import java.io.PrintStream;

import com.sleek.page.SleekpricePage;

import commonUtils.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SleekpriceStepdefinitions {

	SleekpricePage sleekpricePage;

	@Given("^Verify user Load the browser and Navigate to sleek homepage URL$")
	public void verify_user_Load_the_browser_and_Navigate_to_sleek_homepage_URL() throws Throwable {
		PrintStream logs = new PrintStream(new FileOutputStream("AllLogs.txt"));
		System.setOut(logs);
		BaseTest.initialization();
	}

	@When("^Verify user click on the \"([^\"]*)\" link$")
	public void verify_user_click_on_the_link(String exepectedpriceLink) throws Throwable {
		sleekpricePage = new SleekpricePage();
		sleekpricePage.clickPriceLink(exepectedpriceLink);
	}

	@Then("^Verify user should be navigated to the Sleek SG Pricing \"([^\"]*)\" page$")
	public void verify_user_should_be_navigated_to_the_Sleek_SG_Pricing_page(String exepectedurl) throws Throwable {
		sleekpricePage.navigatePricePage(exepectedurl);
	}

	@Given("^Verify user click on find out more for Corporate secretary$")
	public void verify_user_click_on_find_out_more_for_Corporate_secretary() throws Throwable {
		sleekpricePage.clickFindOutMoreForCorporateSecretary();
	}

	@Then("^Verify Adjust shareholder & price for corporate secretary details are correct: \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" fields$")
	public void verify_Adjust_shareholder_price_for_corporate_secretary_details_are_correct_and_and_fields(String steps,
			String noShareholders, String pricePerYear) throws Throwable {
		sleekpricePage.adjustShareHolderAndPrice(steps, noShareholders, pricePerYear);
	}

}
