
@VideoblockersetupModule
Feature: Video Blocker set up feature in the skyTube Application

Background: User launches the Skytube Application

 Scenario: Verify User is able to see  Video blocker set up option
   Given User is on SkyTube Homepage
   When User clicks  hamburger icon top right corner of application
   Then User is able to see Video blocker set up message box 
   
  Scenario: Verify user able to set up  video blocker
   Given User is on Video blocker set up message box 
   When User clicks set option of video blocker
   Then User is able to see different options for setup
