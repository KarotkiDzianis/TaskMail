Feature: Messaging

  Scenario Outline: [EPMFARMATS-5258]: Sending MESSAGE to another user
    Given the user logs in to LinkedIn with login "<login_email>" and password "<password>" on Start page
    When clicks icon "Messaging"
    And the user types name "<name_ti>", selects colleague from list and sends message "<message>"
    And logs out from account
    And the user logs in to LinkedIn with login "<email_ti>" and password "<password>" on Start page
    And clicks icon "Messaging"
    And the user selects colleague name "<name_link>" from list
    Then check of message text "<message>" is presented on the page
    Examples:
      | login_email             | email_ti            | password  | message      | name_link | name_ti |
      | linked.test11@gmail.com | tatigna11@gmail.com | Begemot11 | How are you? | Linked    | Tatiana |