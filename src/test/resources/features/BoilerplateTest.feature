Feature: Google Search
	As an example, I should be able to assert a Google search result

	Scenario: Assert First Google Search Result
		Given I go to "https://www.google.com/"
		When I enter "Reddit" in the search bar
		And I click the "Google Search" button
		Then I should see that the first result is "reddit: the front page of the internet"
