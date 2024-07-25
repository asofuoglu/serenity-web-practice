Feature: Sign in & Purchase a product

  Scenario: Sign in with new user information and add address information
    Given Mike is navigating to the ecommerce website
    And he clicks on the sign in button
    Then he enter the email and click on Create an Account button
    And he fill the personal information form
      | title | firstname | lastname | password     | dateOfBirth |
      | Mr.   | Mike      | May      | Password01/* | 15/11/1990  |
    When he clicks on the register button
    Then he should see the title "My account"
    And he clicks on the add my first address button
    Then he fills the Address form
    When he clicks on the Save address button
    Then he should see the title "addresses"

  Scenario: Login, search a product ,add to the basket and go payment
    Given Mike is navigating to the ecommerce website
    And he clicks on the sign in button
    Then he enter the email and password
    When he clicks on the log in button
    Then he should see the title "My account"
    When he looks up product "Printed Summer Dress"
    Then he should see the product within results about "Printed Summer Dress"
    And he selects the product "Printed Chiffon Dress"
    Then he selects the available product size
    When he clicks on the Proceed to the checkout button
    Then he should see the title "Order"

