Feature: Users API


  Background: 
    * url 'https://jsonplaceholder.typicode.com'

  @USERS
  Scenario: Get user by id
    Given path 'users', 1
    When method get
    Then status 200
    And match response.name == 'Leanne Graham'
    And match response.email == 'Sincere@april.biz'