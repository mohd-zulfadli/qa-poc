*** Settings ***
Library    Process

*** Keywords ***
Run Karate Tests With Maven
    @{args}=    Create List    clean    verify    -Dit.test=SampleKarateIT
    ${result}=    Run Process    mvn    @{args}    shell=True
    Log    ${result.stdout}
    Log    ${result.stderr}
    Should Be Equal As Integers    ${result.rc}    0

*** Test Cases ***
Run Karate Tests With Mavenz
    Run Karate Tests With Maven