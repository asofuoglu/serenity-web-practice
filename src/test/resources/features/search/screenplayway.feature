Feature: Place an Order

  Scenario: User places an order for a product
    Given Mike is on the homepage and Sign in
      | title | firstname | lastname | password     | dateOfBirth |
      | Mr.   | Mike      | May      | Password01/* | 15/11/1990  |
    Then he searches for "Printed Chiffon Dress" and adds available product to the cart
    When he proceeds to checkout
    Then he should see the order successfully placed
