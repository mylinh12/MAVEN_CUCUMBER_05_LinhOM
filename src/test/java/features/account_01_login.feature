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
    And I sleep some times
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
    Given I open New Customer page
    When I input to New Customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | m      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I sleep some times

    # And I click to Submit button at New Customer page
    # Then Verify message displayed with data "<Message>"
    # And I verify all above information created success
    # | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   |
    # | <Name> | male   | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> |
    # When I get Customer ID at New Customer page
    Examples: New Customer info
      | Name      | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password | Message                             |
      | Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 | Customer Registered Successfully!!! |
