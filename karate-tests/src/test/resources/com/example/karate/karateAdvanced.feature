Feature: Advanced Features

  Background:
    * url 'https://jsonplaceholder.typicode.com'
    * header Accept = 'application/json'

@ADVANCED
Scenario: Reuse karateEndToEnd feature
    * def login = call read('karateEndToEnd.feature')
    Given path 'posts'
    When method GET
    Then status 200

@ADVANCED
Scenario: Parallel execution
    Given path 'users'
    When method GET
    Then status 200
    And match response[*].id contains 1
