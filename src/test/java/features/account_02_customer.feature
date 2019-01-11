@customer
Feature: CUSTOMER
  As a PO
  I want to login to system with parameters.
  So that verify login function work well

  @new_customer
  Scenario: Create New Customer
    Given I open application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open New Customer page
    And I input to New Customer form with data
      | Name      | Gender | DateOfBirth | Address    | City        | State   | PIN    | Phone      | Email    | Password |
      | Auto Test | m      | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |   123123 |
    And I click to Submit button at New Customer page
    Then Verify message displayed with data "Customer Registered Successfully!!!"
    And I verify all above information created success
      | Name      | Gender | DateOfBirth | Address    | City        | State   | PIN    | Phone      | Email    |
      | Auto Test | m      | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987456321 | autotest |
    When I get Customer ID at New Customer page

  @edit_customer
  Scenario Outline: Edit Customer
    Given I open application
    When I input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    When I open Edit Customer page
    And Input Customer ID to textbox
    And I click to Submit button at Edit Customer page
    And I input to Edit Customer form with data
      | Address   | City   | State   | PIN   | Phone   | Email   |
      | <Address> | <City> | <State> | <PIN> | <Phone> | <Email> |
    And I click to Submit button at Edit Customer page
    Then Verify message displayed with data "Customer details updated Successfully!!!"
    And I verify all above information edited success
      | Address   | City   | State   | PIN   | Phone   | Email   |
      | <Address> | <City> | <State> | <PIN> | <Phone> | <Email> |

    Examples: 
      | Address         | City             | State        | PIN    | Phone      | Email        |
      | Edit 123 Le Loi | Edit Ho Chi Minh | Edit Thu Duc | 123456 | 0987456321 | editautotest |
