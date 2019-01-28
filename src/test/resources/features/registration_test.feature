Feature: Registration

  Scenario Outline: [EPMFARMATS-5257]: Registration new account
    Given the user goes to start page and types data into fields
    Then checks presence pop-up and text "<message>"
    Examples:
      | message                     |
      | Just a quick security check |