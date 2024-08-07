@FeatureTwo
Feature: Checking out with Cart

  Scenario Outline: Adding item to cart
    Given User is on "<website>" landing page
    When Login page is opened
    Then User enters "<username>" and "<password>" and clicks sign in button
    And Sort items with lower to higher
    And Check footer to make a scroll
    Then User adds an item to the cart
    And Item is successfully added to the cart
    When User goes to checkout
    And User entered his info
    Then Checkout page is displayed
    And Finished checkout
    And Close browser

    Examples:
      | website                    | username       | password     |
      | https://www.saucedemo.com/ | standard_user  | secret_sauce |
