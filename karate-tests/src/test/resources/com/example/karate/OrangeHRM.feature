Feature: Login to OrangeHRM

@ORANGEHRM @API_POST_LOGIN_JSON
Scenario: Login and access dashboard
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate'
  And request { username: 'admin', password: 'admin123' }
  When method post
  Then status 200
  And match responseCookies.orangehrm != null
  * def session = responseCookies.orangehrm.value

  # Now call the dashboard using the cookie
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/dashboard'
  And cookie orangehrm = session
  When method get
  Then status 200
  And match response contains 'Dashboard'


@ORANGEHRM @API_POST_LOGIN_FORM  
Scenario: Login with valid credentials using form data
  Given url 'https://opensource-demo.orangehrmlive.com/web/index.php/auth/validate'
  And form field username = 'admin'
  And form field password = 'admin123'
  When method post
  Then status 200
  * print response
 