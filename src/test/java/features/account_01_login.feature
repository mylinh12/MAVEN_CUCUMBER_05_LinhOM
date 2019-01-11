@account
Feature: ACCOUNT
  As a PO
  I want to login to system with parameters.
  So that verify login function work well

  @register
  Scenario: Register to application
    Given I get Login page Url
    When I click to here link
    And I input to email textbox with data "autorandom"
    And I click to Submit button at Register page
    Then I get UserID infor
    And I get Password infor
    When I open Login page again

  @login
  Scenario: Login to application
    Given I input to Username textbox
    When I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
