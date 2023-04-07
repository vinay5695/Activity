@api
Feature: Test the Github Api functionality

  Scenario Outline: Get a respository of a user
    Given I have to given the endpoint of the github get function "<baseurl>" "<token>"
    When I have to sent get request "<geturl>"
    Then I have to validate the response <responsecode> "<name>" "<ownerid>" "<pushpermission>"
    
    Examples:
    |baseurl|token|geturl|responsecode|name|ownerid|pushpermission|
    |repos/|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|vinay5695/Activity|200|name|owner.id|permissions.push|
    
