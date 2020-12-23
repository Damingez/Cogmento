Feature: Application login

  @LoginTest
  Scenario: Home page default login
    Given Contacts page is displayed
    When the user logins into application with "kowalix93@gmail.com" and password "testy1234"
    Then Home page is populated
    And the user Fullname "Damianoi Komenoi" is displeyed in the upper panel


