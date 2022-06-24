@Sanity
Feature: Google home page

  @Regression
  @LogoIcon
  Scenario: Validate google logo icon displayed in google home page
    Given User navigates to google URL
    When User successfully navigated
    Then User should see google logo icon displayed

  @Regression
  @SearchBar
  Scenario: Validate google search bar displayed in google home page
    Given User navigates to google URL
    When User successfully navigated
    Then User should see google search bar displayed

  @Buttons
  Scenario: Validate google buttons displayed and enabled in google home page
    Given User navigates to google URL
    When User successfully navigated
    Then User should see google buttons displayed
    And User should see google buttons enabled