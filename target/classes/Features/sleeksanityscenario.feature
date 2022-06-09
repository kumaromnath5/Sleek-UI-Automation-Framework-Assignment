@Sanity
Feature: Sleek Test Cases pages automation

  Background: Verify Clicking the Pricing link from the Header menu navigates user to the Pricing page
    Given Verify user Load the browser and Navigate to sleek homepage URL
    When Verify user click on the "Pricing" link
    Then Verify user should be navigated to the Sleek SG Pricing "https://sleek.com/sg/all-services/" page

  Scenario Outline: Correct corporate secretary details should display after updating accounting progress line
    Given Verify user click on find out more for Corporate secretary
    Then Verify Adjust shareholder & price for corporate secretary details are correct: "<steps>" and "<noShareholders>" and "<pricePerYear>" fields

    Examples: 
      | steps | noShareholders     | pricePerYear |
      | step2 | 2 Shareholders     | S$360/year   |
      | step4 | 6 - 9 Shareholders | S$540/year   |
      | step7 | > 30 Shareholders  | S$1,140/year |
