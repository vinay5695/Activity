@api
Feature: Test the Github Api functionality

  Scenario Outline: Get a respository of a user
    Given I have to given the endpoint of the github get function "<baseurl>" "<token>"
    When I have to sent get request "<geturl>"
    Then I have to validate the response <responsecode> "<name>" "<ownerid>" "<pushpermission>"
    
    Examples:
    |baseurl|token|geturl|responsecode|name|ownerid|pushpermission|
    |repos/|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|vinay5695/Activity|200|name|owner.id|permissions.push|
    
