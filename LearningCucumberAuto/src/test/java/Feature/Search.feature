Feature: Search

  Scenario: Validate search with keyword on Google
    Given I am on google page
    When I search keyword: "the beatles"
    Then I get the result containing "the beatles" keyword

    Scenario: Verify that Youtube video in the search result that contains search keyword
      Given I am on Google search result page of keyword is "the beatles"
      When I open the first video in Video carousel
      And I stop video after 10 seconds
      Then The video title at Youtube page should match with search result
      And State of video is correct

