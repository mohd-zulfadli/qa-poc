*** Settings ***
Library    Browser

*** Keywords ***
Open Example With Playwright
    New Browser    chromium
    New Page    https://example.com
    Get Title    ==    Example Domain
    Close Browser

*** Test Cases ***
Open Example With Playwrightz
    Open Example With Playwright