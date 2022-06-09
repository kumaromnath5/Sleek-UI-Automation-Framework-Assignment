package com.sleek.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import commonUtils.BaseTest;
import commonUtils.GenericUtility;

public class SleekpricePage extends BaseTest {
	private static final Logger log = LoggerFactory.getLogger(SleekpricePage.class.getName());

	GenericUtility genericUtility = new GenericUtility();
	@FindBy(id = "menu-item-36831")
	private WebElement priceLinkHeader;
	@FindBy(xpath = "//h3[.='Corporate secretary']/../../../div/div/a")
	private WebElement findOutMore;

	@FindBy(xpath = "//*[contains(text(),'Unlimited service!')]")
	private WebElement scrollToShareHolder;

	@FindBy(xpath = "//p[.='Select your plan:']")
	private WebElement shareHolderPlansDisplay;

	@FindBy(xpath = "//div[@class='accounting-progress-line']")
	private WebElement progressBar;

	/**
	 * @return the priceLinkHeader
	 */
	public WebElement getPriceLinkHeader() {
		return priceLinkHeader;
	}

	/**
	 * @return the findOutMore
	 */
	public WebElement getFindOutMore() {
		return findOutMore;
	}

	/**
	 * @return the scrollToShareHolder
	 */
	public WebElement getScrollToShareHolder() {
		return scrollToShareHolder;
	}

	/**
	 * @return the shareHolderPlansDisplay
	 */
	public WebElement getShareHolderPlansDisplay() {
		return shareHolderPlansDisplay;
	}

	/**
	 * @return the progressBar
	 */
	public WebElement getProgressBar() {
		return progressBar;
	}

	// **********Intilize the page**********
	public SleekpricePage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * @verify clickPriceLink
	 */
	public void clickPriceLink(String exepectedpriceLink) throws Exception {

		genericUtility.WaitForTheVisibilityOfElement(getPriceLinkHeader(), 40);
		genericUtility.JseHighlightTheElement(getPriceLinkHeader());
		String actulPriceLink = genericUtility.getText(getPriceLinkHeader());
		log.info(actulPriceLink + " " + "Actual price link is clicked");
		Assert.assertEquals(exepectedpriceLink, actulPriceLink);
		genericUtility.clickElement(getPriceLinkHeader());

	}

	/**
	 * @verify navigate PricePage
	 */
	public void navigatePricePage(String exepectedurl) throws Exception {
		String actualUrl = genericUtility.urlContainsSubstring(exepectedurl);
		Assert.assertEquals(exepectedurl, actualUrl, "url is  matching");
		log.info(actualUrl + "Actual url");

	}

	/**
	 * @verify clickfindOutMoreforCorporatesecretary
	 */
	public void clickFindOutMoreForCorporateSecretary() throws Exception {
		genericUtility.scrollToview(getFindOutMore());
		genericUtility.WaitForTheVisibilityOfElement(getFindOutMore(), 40);
		genericUtility.JseHighlightTheElement(getFindOutMore());
		genericUtility.clickElement(getFindOutMore());
		genericUtility.wait(4);

	}

	/**
	 * @verify adjust Shareholder And Price
	 */
	public void adjustShareHolderAndPrice(String steps, String noShareholders, String pricePerYear) throws Exception {
		genericUtility.scrollToview(getScrollToShareHolder());
		genericUtility.clickElement(getScrollToShareHolder());
		genericUtility.WaitForTheVisibilityOfElement(getProgressBar(), 60);
		genericUtility.clickElement(getShareHolderPlansDisplay());
		genericUtility.wait(2);
		genericUtility.clickElement(driver.findElement(By.xpath("//*[contains(@id,'" + steps + "')]")));
		genericUtility.wait(4);
		genericUtility.scrollToview(getScrollToShareHolder());
		String actualNoShareholders = genericUtility
				.getText(driver.findElement(By.xpath("//*[text()='" + noShareholders + "']")));
		log.info(actualNoShareholders + "noShareHolder is matched");
		Assert.assertEquals(actualNoShareholders, noShareholders, "noShare Holder is matched");
		String actualpricePerYear = genericUtility
				.getText(driver.findElement(By.xpath("//*[text()='" + pricePerYear + "']")));
		log.info(actualpricePerYear + "price range is matched");
		Assert.assertEquals(actualpricePerYear, pricePerYear, "price range is matched");

	}

}
