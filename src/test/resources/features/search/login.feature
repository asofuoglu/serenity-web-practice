Feature: Login to TST

  @s1
  Scenario: Customer login to TST env
    Given Mike is on the login page
    And he enter the credentials
    When he enter pin
    Then he navigated to the homepage
  
