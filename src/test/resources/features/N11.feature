@smoke

Feature: Got to N11 Website
  Scenario: Negative Login n11 site
    Given User go to homepage
    When Confirm that it went to the homepage
    And User click to login button
    And Verifies that the login page has loaded
    And User does not fill in eMail and password
    And The user only fills in the eMail section
    And The user only fills the password section
    And User enters incorrect information
    Then User incorrect information is verified

@smoke

  Scenario: Login N11 site
    Given User go to homepage
    When Confirm that it went to the homepage
    And User click to login button
    And Verifies that the login page has loaded
    And User enters valid username and password
    Then User verifies successful login



      @smoke

      Scenario: User adds a product to the cart
        Given User go to homepage
        When Confirm that it went to the homepage
        And User click to login button
        And Verifies that the login page has loaded
        And User enters valid username and password
        Then User verifies successful login
        When User searches for a product and clicks
        Then User adds the product to the cart
        And Verify that the product is in the cart

        @smoke

        Scenario: User delete product to the card
          Given User go to homepage
          When Confirm that it went to the homepage
          And User click to login button
          And Verifies that the login page has loaded
          And User enters valid username and password
          Then User verifies successful login
          When User searches for a product and clicks
          And User delete product
          And Verify that the product is not in the cart

          @smoke

          Scenario: Logout N11 site
            Given User go to homepage
            When Confirm that it went to the homepage
            And User click to login button
            And Verifies that the login page has loaded
            And User enters valid username and password
            Then User verifies successful login
            And Performs user logout operations
            And User verifies successfully logout




