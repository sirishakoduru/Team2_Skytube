Feature: Subscribe and unsubscribe a channel in skytube application

Scenario: Verify user is navigated to the required channel
Given User is on the skytube home page
When User clicks on the channel name below the vedio
Then User is naviagated to the selected channel

Scenario: Verify User subscribes to a channel in the skytube application
Given User is on the channel tab with subscribe button
When User clicks on the subscribe button on the channel
Then User should see 'subscribed' message

Scenario: Verify the subscribed channel displayed in the subscription page 
Given User is on the skytube home page
When User navigates to the subscription page
Then User should see the subscribed channel 

Scenario: Verify user is able to see unsubscribe 
Given User is on the skytube home page
When User clicks on the hamburger menu on the top left corner and selectes the subscribed channel
Then User shouls see the unsubscribe button

Scenario: Verify user is able to unsubscribe the channel
Given User is on the subscribed channel
When User clicks on the unsubscribe button
Then User should see the message 'unsubscribed'