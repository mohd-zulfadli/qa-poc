Feature: Users API

  Background: 
    * url 'https://jsonplaceholder.typicode.com'

  @USERS @BASIC_API
  Scenario: Get user by id
    Given path 'users', 1
    When method get
    Then status 200
    And match response.name == 'Leanne Graham'
    And match response.email == 'Sincere@april.biz'

  @TODOS @BASIC_API
  Scenario: Get todos by userId and validate done: TRUE
    Given path 'todos', 4
    When method get
    Then status 200
    And match response.title == 'et porro tempora'
    And match response.completed == TRUE