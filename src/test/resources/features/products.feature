Feature: To see if the products API is working

  Scenario: client makes call to GET /products to get the products
    Given the products exist in the DB
    When the client calls "/products"
    Then the client receives status code of 200
    And the response contains product Name "Digital Watch"