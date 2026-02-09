*** Settings ***
Library    Process

*** Keywords ***
Run JUnit Tests With Maven
    @{args}=    Create List    test    -Dtest=MyJUnitTest
    ${result}=    Run Process    mvn    @{args}    shell=True
    Log    ${result.stdout}
    Log    ${result.stderr}
    Should Be Equal As Integers    ${result.rc}    0

*** Test Cases ***
Run JUnit Tests With Mavenz
    Run JUnit Tests With Maven