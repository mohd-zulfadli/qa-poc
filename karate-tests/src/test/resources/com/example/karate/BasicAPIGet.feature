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
    And match response.completed == true

  @PUT_API @BASIC_API
  Scenario: Get todos by userId and validate done: TRUE
    Given path 'posts', 10
    And request
    """
    {
      "userId": 3,
      "id": 30,
      "title": "Test New Title for userId 3 and id 30",
      "body": "Like I said in the title, this is a test update for userId 3 and id 30"
    }
    """
    When method put
    Then status 200
    And match response.title == 'Test New Title for userId 3 and id 30'
    And match response.body == 'Like I said in the title, this is a test update for userId 3 and id 30'

  Scenario: Get response from comments and count the number of comments for postId 1
    Given path 'comments'
    When method get
    Then status 200
    And match karate.sizeOf(response) == 500