Feature: Description of feature goes here

  Background:

    Given a standard user tries to login with valid credentials
    And the login is successful
    Then the user is redirected to the products page

#    Scenario Outline: permite parametrizar
    Scenario: The user navigates through the website, filters and selects products, and then successfully generates a purchase

      Given an authenticated user
      And user selects the tab 'about'
      Then user sees the about page
      When user goes back to the previous page
      Then user is redirected to the products page
      When user selects the 'Price (high to Low)' filter
      And user selects the four most expensive products (first 4 elements based on the filter)
      Then user's cart amount is updated to 4
      When presses the cart icon
      Then the cart page with the selected products is shown
      When user presses the checkout button
      Then the checkout information is shown
      And user fills their 'first name', 'last name', and 'zip/postal code'
      And user presses the continue button
      Then the checkout overview page is shown with a summary of the purchase
      And user validates the total price is as expected
      When user is sure that it's ok, they press finish
      Then a page with the message 'Thank you for your order!' is shown

#      Tabla con data que se usa como parametros en los escenarios
#      Examples:
#      |type|filter|
#      |typeName|filterName|




