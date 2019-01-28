Feature: Editing an account

  Background:
    Given the user logs in to LinkedIn with login "linked.test11@gmail.com" and password "Begemot11" on Start page

  Scenario Outline: [EPMFARMATS-5259]: View vacancies
    When the user open JobsPage
    And the user fill form 'Search jobs' random value
    And the user fill form 'Search location' "<location>"
    And the user push the button 'Search'
    Then the user sees a counter jobs or message "<mes>"
    Examples:
      | location | mes                     |
      | Belarus  | No matching jobs found. |

  Scenario Outline: [EPMFARMATS-5398]: Choose jobs
    When the user open JobsPage
    And the user fill form 'Search jobs' "<jobs>"
    And the user fill form 'Search location' "<location>"
    And the user push the button 'Search'
    Then the user save job and after unsave this job
    Examples:
      | location | jobs      |
      | Belarus  | junior QA |

  Scenario: [EPMFARMATS-5260]: Create company page
    When the user open WorkPage
    And  the user opens link Create page
    And  the user enter company name
    Then the user create company page and then delete this page