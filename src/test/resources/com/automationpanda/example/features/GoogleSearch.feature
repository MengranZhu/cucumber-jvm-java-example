Feature: Google Searching
  As a web surfer,
  I want to search Google for panda,
  So that I can learn new things.

  @automated @web @google @panda
  Scenario: Simple Google search
    Given a web browser is on the Google page
    When the search phrase "panda" is entered
    Then results for "panda" are shown

  @auomated @web @google @panda
  Scenario: Google Image Search
    Given a web brower is on the Google Image page
    When the search phrase "panda" is entered
    Then results for "panda" are shown
