@FeatureThree
Feature: Updating with Cart

  Scenario Outline: Remove item from cart
    Given User is on "<website>" landing page
    When Login page is opened
    Then User enters "<username>" and "<password>" and clicks sign in button
    And Check footer to make a scroll
    Then User adds an item to the cart
    And Item is successfully added to the cart
    When User goes to cart
    And User removes his item
    Then Try to continue shopping
    And User goes to cart again to check the removed items
    And Close browser

    Examples:
      | website                    | username       | password     |
      | https://www.saucedemo.com/ | standard_user  | secret_sauce |
