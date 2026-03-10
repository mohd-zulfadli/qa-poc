Feature: Login to OrangeHRM

@ORANGEHRM @API_POST_LOGIN_JSON
Scenario: Login with valid credentials using JSON payload
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
  And request { username: 'admin', password: 'admin123' }
  When method post
  Then status 200
  And match response.token == '#string'

@ORANGEHRM @API_POST_LOGIN_FORM  
Scenario: Login with valid credentials using form data
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate'
  And form field username = 'admin'
  And form field password = 'admin123'
  When method post
  Then status 200
  * print response
 