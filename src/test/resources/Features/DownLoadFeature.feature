Feature: DownLoad functionality in SkyTube app

Scenario: Verify the user can see the downloaded videos in download menu
    Given The User is on the skytube home page
    When The User click on the Downlaod menu in the home page
    Then The user can see the downloaded videos below

  Scenario: Verify the Delete video option in downloaded vieo
    Given The User is on the Download page on skyTube application
    When The User click on the three dot on the videos
    Then The user will see multiple option with Delete download option
  
  Scenario: Verify the User able to delete the downloaded video
    Given The User is on the mulitple options page
    When The User click on the delete download option 
    Then The user will see the selected will be deleted from there
    
  Scenario: Verify the User able to empty page on DownLoad Page
    Given The User is on the skytube home page
    When The User click on the Downlaod menu in the home page 
    Then The user will see "DownLoad some videos to find here" message