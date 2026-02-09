*** Settings ***
Library    Process

*** Keywords ***
Run Cypress E2E Tests
    ${result}=    Run Process    npx    cypress    run    cwd=cypress-tests    shell=True
    Log    ${result.stdout}
    Log    ${result.stderr}
    Should Be Equal As Integers    ${result.rc}    0

*** Test Cases ***
Run Cypress E2E Testsz
    Run Cypress E2E Tests