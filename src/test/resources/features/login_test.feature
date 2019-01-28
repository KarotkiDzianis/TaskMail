Feature: Login

  Background:
    Given the user logs in to LinkedIn with login "linked.test11@gmail.com" and password "Begemot11" on Start page

  Scenario Outline: [EPMFARMATS-5254]: Log in with existing account
    Then after log in text "<message>" is present on the page
    Examples:
      | message                                |
      | Share an article, photo, video or idea |

  Scenario Outline: [EPMFARMATS-5255]: Log out from account
    When the user logs out from account
    Then after log out text "<message>" is present on the page
    Examples:
      | message                 |
      | Be great at what you do |