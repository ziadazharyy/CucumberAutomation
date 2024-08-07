@FeatureOne
Feature: Login Functionality for E-commerce Website

  Scenario Outline: Successful login with valid credentials
    Given User is on "<website>" landing page
    When Login page is opened
    Then User enters "<username>" and "<password>" and clicks sign in button
    And Close browser

    Examples:
      | username    | password     | website                    |
      | visual_user | secret_sauce | https://www.saucedemo.com/ |


  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given User is on "<website>" landing page
    Then Login page is opened
    And User enters invalid "<username>" and "<password>" and clicks sign in button
    Then User should see an error message "<error_message>"
    And Close browser

    Examples:
      | website                    | username           | password        | error_message                                                             |
      | https://www.saucedemo.com/ | invalidE@email.com | invalidPassword | Epic sadface: Username and password do not match any user in this service |
      | https://www.saucedemo.com/ | test123            | validPassword   | Epic sadface: Username and password do not match any user in this service |
      | https://www.saucedemo.com/ | locked_out_user    | secret_sauce    | Epic sadface: Sorry, this user has been locked out. |
