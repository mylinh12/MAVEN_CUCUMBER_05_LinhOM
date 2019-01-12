@account
Feature: ACCOUNT
  As a PO
  I want to login to system with parameters.
  So that verify login function work well

  @register
  Scenario: Register to application
    # Login page
    Given I get Login page Url
    When I click to here link
    # Register page
    And I input to email textbox with data "autorandomL2"
    And I click to Submit button at Register page
    And I sleep with "10" times
    Then I get UserID infor
    And I get Password infor
    When I open Login page again

  @login
  Scenario: Login to application
    Given I input to Username textbox
    When I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"

  @new_customer
  Scenario Outline: Create New Customer
    Given I open "New Customer" page
    When I input to "name" textbox with data "<Name>"
    And I select "m" radio button
    And I input to "dob" textbox with data "<DateOfBirth>"
    And I input to "addr" textarea with data "<Address>"
    And I input to "city" textbox with data "<City>"
    And I input to "state" textbox with data "<State>"
    And I input to "pinno" textbox with data "<Pin>"
    And I input to "telephoneno" textbox with data "<Phone>"
    And I input to "emailid" textbox with "2" data "<Email>"
    And I input to "password" textbox with data "<Password>"
    And I click to "Submit" button
    And Verify message "Customer Registered Successfully!!!" displayed success
    And I sleep with "10" times

    Examples: New Customer info
      | Name      | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password | Message                             |
      | Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 | Customer Registered Successfully!!! |
