Feature: Watchvideocleanner feature in the skyTube Application

Background: User launches the Skytube Application

 Scenario: Verify User is able to see  watched video cleaner option
   Given User sees SkyTube Homepage
   When User sees  three dots on top right corner of application and clicks on it
   Then User is able to see watched video cleaner option
   
  Scenario: Verify user able to see watched video cleaner message box with options
   Given User sees video cleaner option after clicking three dots of application
   When User clicks watched video cleaner option
   Then User is able to see watched video cleaner message box with options
   
   Scenario: User is not be able to clean videos without option selected in the video cleaner message box
   Given User is able to see watched video cleaner message box
   When User clicks on clean option 
   Then User sees 'zero videos deleted message'
   
  
  Scenario: Verify user able to clean videos
   Given User sees watched video cleaner message box with options
   When User selects the checkboxes in the box and clicks on clean option
   Then User sees message 'videos removed from boookmark and downloads'
  
 