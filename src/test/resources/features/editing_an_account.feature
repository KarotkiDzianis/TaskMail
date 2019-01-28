Feature: Editing an account

  Background:
    Given the user logs in to LinkedIn with login "linked.test11@gmail.com" and password "Begemot11" on Start page

  Scenario Outline: [EPMFARMATS-5248]: Post a message
    When the user posts a "<message>" on the Home page
    And the user deletes a message on the Home page
    Then the user sees a message that the post is deleted on the Home page
    Examples:
      | message      |
      | Hello world! |

  Scenario Outline: [EPMFARMATS-5249]: Change language
    When the user goes to Settings Page
    And the user changes language to "<russianLanguage>"
    And the user sees that the page title is changed to "<russianLanguage>"
    And the user changes language to "<englishLanguage>"
    Then the user goes to Main page
    Examples:
      | russianLanguage | englishLanguage |
      | ru_RU           | en_US           |

  Scenario: [EPMFARMATS-5250]: Hide education place
    When the user goes to Profile page
    And the user hide his education place
    And the user sees that education place is hidden
    Then the user revert changes back

  Scenario Outline: [EPMFARMATS-5251]: Add existing skill to profile
    When the user goes to Profile page
    And the user adds a "<skill>" to his profile
    Then the user sees a message that the skill have already added
    Examples:
      | skill |
      | Java  |