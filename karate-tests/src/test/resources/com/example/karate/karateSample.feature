Feature: Sample API and UI Tests

@GET_API @SMOKE
Scenario: Get a post by ID
  Given url 'https://jsonplaceholder.typicode.com/posts/1'
  When method get
  Then status 200
  And match response.id == 1

@GET_API @SMOKE
Scenario: Get a post by ID 2
  Given url 'https://jsonplaceholder.typicode.com/posts/2'
  When method get
  Then status 200
  And match response.id == 2

@POST_WITH_MYKEY @SMOKE
Scenario: POST Karate
  Given url 'https://httpbin.org/anything'
  When request { myKey: 'myValue' }
  And method post
  Then status 200
  And match response.json == { myKey: 'myValue' }
  

# Scenario: Open Example Page
#   Given driver 'https://example.com'
#   Then title should be 'Example Domain'
#   And driver.quit()
