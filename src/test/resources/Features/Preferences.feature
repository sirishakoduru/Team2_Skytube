@PreferencesModule
Feature: Check checks all the preferences menu options

Scenario: Verify user is able to naviage to preferences tab
Given User on the skytube home page
When User clicks on the three dots on the top right corner of home page and clicks on preferences
Then User is navigated to the preferences tab

Scenario Outline: Verify the presence of all the menu options on the preference tab
Given User is on the preference tab
Then User should see the menu options "<MenuOptions>".
Examples:
|MenuOptions|
|Video Player|
|Video Blocker|
|SponsorBlock|
|Import/Export|
|Privacy|
|Network and Downloads|
|Others|
|About|