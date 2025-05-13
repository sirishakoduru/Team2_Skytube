
@BookmarkModule
Feature: Bookmark feature in the skyTube Application

Background: User launches the Skytube Application

 Scenario: Verify the video is playing in the skytube application
   Given User is on the home page of SkyTube application
   When User selects a video to play and clicks on play button
   Then User should see the video playing
  Scenario: verify user is able to bookmark the video in skytube application
   Given user is on the home page
   When User clicks three dots below the video and able to select Bookmark option
   Then User should be able to see message 'Bookmarked'
  
  Scenario: Verify video is  added in Bookmark list
   Given User is on  skyTube home page
   When User clicks on Bookmark option on homepage
   Then User should be able to see the bookmarked video
  
  Scenario: Verify user is able to Unbookmark the video in skytube application
   Given User sees the bookmarked video in the bookmark page
   When User clicks on three dots below the video and clicks Unbookmark
   Then User sees toast message 'Bookmark removed'
