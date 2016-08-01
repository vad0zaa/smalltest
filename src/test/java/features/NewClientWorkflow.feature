Feature:
  As a user
  I want to be able to register in the system
  So that i can login into system

  Scenario: Sign up a new user
    Given the user is on landing page
    When he chooses to sign up
    And he provides the first name as Ivanoff
    And he provides the last name as Petrovv
    And he provides the email as hot2222@hot.ee
    And he provides the password as password
    And he provides the confirm password again as password
    And he signs-up
    Then he should be logged in to the application
