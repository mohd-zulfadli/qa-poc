*** Settings ***
Library    Process

*** Keywords ***
Run TestNG Tests With Maven
    @{args}=    Create List    test    -Dtest=MyTestNGTest
    ${result}=    Run Process    mvn    @{args}    shell=True
    Log    ${result.stdout}
    Log    ${result.stderr}
    Should Be Equal As Integers    ${result.rc}    0

*** Test Cases ***
Run TestNG Tests With Mavenz
    Run TestNG Tests With Maven    