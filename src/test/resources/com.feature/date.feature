Feature: Test the date add feature

  @java
  Scenario: Add date to current date
    Given I want to get and print the current date
    When I have to add the current date with one date
    Then I print the current date with added one date
