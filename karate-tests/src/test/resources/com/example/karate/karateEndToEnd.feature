Feature: Basic API Test

@END_TO_END
Scenario: Get user
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'users', 1
    When method GET
    Then status 200
    And match response.name == 'Leanne Graham'

@END_TO_END
Scenario: Validate schema
    Given url 'https://jsonplaceholder.typicode.com'
    And path 'users', 1
    When method GET
    Then status 200
    #And match response == { id: '#number', name: '#string', email: '#string' }
    
    # Option 2: Explicit field checks
    And match response.id == 1
    And match response.name == 'Leanne Graham'
    And match response.email contains '@'

@END_TO_END    
Scenario Outline: Get multiple users
  Given url 'https://jsonplaceholder.typicode.com'
  And path 'users', <id>
  When method GET
  Then status 200
  And match response.id == <id>

  Examples:
    | id |
    | 1  |
    | 2  |
    | 3  |
