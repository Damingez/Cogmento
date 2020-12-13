Feature: Application login

  Scenario: Home page default login
    Given User is on Cogmento landing page
    When User login into application with "kowalix93@gmail.com" and password "testy1234"
    Then Home page is populated
    And User Fullname "Damianoi Komenoi" is displeyed in the upper panel
