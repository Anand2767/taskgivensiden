Feature: to validate the login functionaly of saucedemo application

  Background: 
    Given the user should be in  saucedemo

  Scenario: To  validate product cart functionality
    When The user login to application
    When The user add the products to the cart
    Then To validate the added product is correct or not

  Scenario: To validate the Sauce Labs Bolt product availablity
    When The user login to application
    And To get all products
    Then To validate the "Sauce Labs Bolt T-Shirt" is availabale or not

  Scenario: To validate the product price details
    When The user login to application
    And To get all product price details and remove the dollor symbol
    Then Validate the product price when user click the product price same or not


  Scenario: To vaTo vaidate the login with invalid credentials
    When The user login to application with ivalid data
    Then Validate the invalid login error message
