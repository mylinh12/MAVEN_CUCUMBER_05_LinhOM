Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Common step
  # ------------- ACTION ------------- #
  # Textbox
  And I input to "name" textbox with data "Automation Test"
  And I input to "city" textbox with random data "Ho Chi Minh"
  And I input to "state" textbox with random data "Thu Duc"
  And I input to "emailid" textbox with random data "autotest"
  And I input to "state" textbox with random data "Thu Duc"
  
  # 0 = fix data | 1 = random data
  And I input to "city" textbox with "0" data "Ha Noi"
  #  e.g: Ha Noi
  
  And I input to "city" textbox with "1" data "Ha Noi"
  # e.g: Ha Noi 123256
  
  And I input to "emailid" textbox with "2" data "autotest"
  # e.g: autotest511354@gmail.com
  
  # Text Area
  And I input to "addr" textarea with data "123 Nguyen Hue"
  
  # Dropdown
  And I select item in "selaccount" dropdown with data "Current"
  And I select item in "selaccount" dropdown with data "Saving"
  
  # Radio button
  And I select "m" radio button
  And I select "f" radio button
  
  # Button
  And I click to "" button
  
  # Link
  And I open "New Customer" page
  
  # Regex
  And I input first Account ID
  And I input second Account ID
  And I transfer to "<Amount>" USD
  And I withdraw to "<Amount>" USD
  
  
  # ------------- VERIFY ------------- #
  And Verify message "Customer Registered Successfully!!!" displayed success
  And Verify message "Welcome To Manager's Page of Guru99 Bank" displayed success
  
  # ------------- WAIT ------------- #
  And I sleep with "30" times
  And I sleep with "10" times
  And I sleep with "5" times