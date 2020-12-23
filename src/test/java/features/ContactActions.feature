Feature: Creation/removal of contact

  Background: Home page default login
    Given the user is on Cogmento login page
    When the user logins into application with "kowalix93@gmail.com" and password "testy1234"
    Then Home page is populated
    And the user Fullname "Damianoi Komenoi" is displeyed in the upper panel

  @SmokeTest
  Scenario: Add contact with mandatory fields
    When the user uses URL to navigate to Contacts page
    And the user clicks on New button
    And the user provides the Firstname "Maro" of the contact
    And the user provides the LastName "Slusarczyk" of the contact
    And the user clicks on save button
    Then contact page is displayed

  @SmokeTest
  Scenario: Contact deletion process
    When the user uses URL to navigate to Contacts page
    And Contact with name: "Maro Slusarczyk" exists
    When the user clicks on trash icon of contact: "Maro Slusarczyk"
    And the user clicks on the delete button
    Then number of the contacts equals to: "6"
