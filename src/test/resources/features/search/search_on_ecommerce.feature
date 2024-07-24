Feature: Search by keyword

  Scenario: Searching for 'green'
    Given Mike is navigating to the ecommerce website
    When he looks up product "T-shirts"
    Then he should see the product within results about "Faded Short Sleeve T-shirts"