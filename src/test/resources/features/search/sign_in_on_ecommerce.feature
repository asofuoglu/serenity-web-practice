Feature: Sign in

  Scenario: Searching for 'green'
    Given Mike is navigating to the ecommerce website
    And he clicks on the sign in button
    Then he enter the email and click on Create an Account button
    And he fill the personal information form
      | title | firstname | lastname | password     | dateOfBirth |
      | Mr.   | Mike      | May      | Password01/* | 15/11/1990  |
    When he clicks on the register button
    Then he should see the title "My account"
    And he clicks on the add my first address button
    Then he fills the Address form "address.yaml"
    When he clicks on the Save address button
    Then he should see the title "addresses"