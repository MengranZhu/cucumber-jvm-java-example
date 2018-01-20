Feature: Wikipedia Search
  I want to use wiki to find some useful articles for reference.

  @automated @web @wiki @article
  Scenario: Wiki Search
    Given a web browser is on the Wikipedia Page
    When the search article "panda" is entered
    Then some articles for "panda" are shown