Feature: Create a demo post

@POSTAPI @PA_POSITIVE
Scenario: Create post TC1 Positive
  Given url 'https://api.restful-api.dev/objects'
  And request
    """
    {
      "name": "Karate Demo Post",
      "data": {
        "type": "blog-post",
        "createdBy": "Karate DSL"
      }
    }
    """
  When method post
  Then status 200
  And match response.name == 'Karate Demo Post'
  And match response.id == '#string'
  And match response.data.type == 'blog-post'
  And match response.data.createdBy == 'Karate DSL'

@POSTAPI @PA_NEGATIVE
Scenario: Create post TC2 Negative
  Given url 'https://api.restful-api.dev/objects'
  And request
    """
    {
      "name": "Karate Demo Post",
      "data": {
        "type": "blog-post",
        "createdBy": "Karate DSL"
      }
    }
    """
  When method post
  Then status 200
  And match response.name == 'Karate Demo Post'
  And match response.id == '#string'
  And match response.data.type == 'blog-post'
  And match response.data.createdBy == 'Karate DSL Author'

@POSTAPI @PA_NEGATIVE
Scenario: Create post TC3 Negative
  Given url 'https://api.restful-api.dev/objects'
  And request
    """
    {
      "name": "Karate Demo Post",
      "data": {
        "type": "blog-post",
        "createdBy": "Karate DSL"
      }
    }
    """
  When method post
  Then status 200
  And match response.name == 'Karate Demo Post'
  And match response.id == '#integer'
  And match response.data.type == 'blog-post'
  And match response.data.createdBy == 'Karate DSL'