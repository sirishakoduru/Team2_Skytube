
@SubscribeUnsubscribeModule
Feature: Subscribe and unsubscribe a channel in skytube application

Scenario: Verify user is navigated to the required channel
Given User is on the skytube home page
When User selects the vedio to be played and clicks on the options of the vedio to subscribe
Then Then User should see 'Subscribed' message

Scenario: Verify the subscribed channel displayed in the subscription page 
Given User is on the skytube home page
When User clicks on the hamburger menu on the top left corner and navigates to subscribed channel tab
Then User should see the subscribed channel 
#
Scenario: Verify user is able to see unsubscribe 
Given User is on the skytube home page
When User clicks on the hamburger menu on the top left corner and selectes the subscribed channel in the subscriptions tab
Then User shouls see the unsubscribe button

Scenario: Verify user is able to unsubscribe the channel
Given User is on the subscribed channel
When User clicks on the unsubscribe button
Then User should see the message 'Unsubscribed'