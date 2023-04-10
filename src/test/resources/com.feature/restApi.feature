@api
Feature: Test the Github Api Get functionality

  Scenario Outline: Get a respository of a user
    Given I have to given the endpoint of the github get function "<baseurl>"
    When I have to sent get request "<geturl>"
    Then I have to validate the response <responsecode> "<name>" "<ownerid>"
    
    Examples:
    |baseurl|geturl|responsecode|name|ownerid|
    |repos/|vinay5695/Activity|200|name|owner.id|
    
