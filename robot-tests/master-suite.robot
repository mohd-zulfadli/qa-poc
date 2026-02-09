*** Settings ***
Resource    run-junit.robot
Resource    run-testng.robot
Resource    run-playwright.robot
Resource    run-karate.robot

*** Test Cases ***
Run Junit
    run-junit.Run JUnit Tests With Maven

Run TestNG
    run-testng.Run TestNG Tests With Maven

Run Karate
    run-karate.Run Karate Tests With Maven

Run Playwright
    run-playwright.Open Example With Playwright
