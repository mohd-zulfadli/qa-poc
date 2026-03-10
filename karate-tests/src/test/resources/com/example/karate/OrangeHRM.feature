Feature: Login to OrangeHRM

@ORANGEHRM @API_POST_LOGIN
Scenario: Login with valid credentials
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/login'
  And request { username: 'admin', password: 'admin123' }
  When method post
  Then status 200
  And match response.token == '#string'
