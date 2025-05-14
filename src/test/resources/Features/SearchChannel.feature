Feature: Search Channel functionality in SkyTube app

  Scenario: Verify the user able to search channel in skytube application
    Given The User is on the skytube home page
    When The User Click on the hamburger menu on left side of home page
    Then The User will land on subscription page with search channel options

  Scenario: Verify the user able to search channel in skytube application with valid subscribed channel
    Given The User is on the subscription page with search channel options
    When The User type the valid subscribed channel "Channel Name" in the search tab
    Then The User can see the searched subscribed channel below the search bar
  
  Scenario: Verify the user able to search channel in skytube application with Non subscribed channel
    Given The User is on the subscription page with search channel options
    When The User type the non subscribed channel "Non Subscribed" in the search tab
    Then The user can see empty column below the search tab
    
  Scenario: Verify the user able to search channel in skytube application with special character
    Given The User is on the subscription page with search channel options
    When The User type the special character "&%" in the search tab
    Then The user can see empty column below the search tab