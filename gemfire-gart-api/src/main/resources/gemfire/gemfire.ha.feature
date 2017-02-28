#Author: Gregory.Green@dell.com
Feature:  High Availability
    Scenario: Running Locator
    Given a Locator Server
    Then Assert Locator Member Running Status is true
    
    Scenario: Running Cache Server
    Given a Cache Server
    Then Assert Cache Server Running Status is true
    And TotalFailedConnectionAttempts = 0

    Scenario: Redundant Locator
    Given a Distributed System
    Then Assert LocatorCount > 1
    
    
    Scenario: Redundant Cache Server
    Given a Distributed System
    Then Assert MemberCount - LocatorCount > 1

    Scenario:  Set the redundancy zone
    Given a Cache Server 
    Then Assert Member Property redundancy-zone not empty

  	Scenario:  Persist Data To Disk
    Given a Region
    Then Assert Region Data Policy is persistent
    
    Scenario: Use Cache Loader With Eviction
    Given a Region
	When Eviction Used
	Then Assert Cache Has Cache Loader
 	
 	Scenario: Use Partitioned Entries Copies
 	Given a Partition Region
 	Then Region property numberOfCopies > 1
 	
 	Scenario: Number of Buckets Without Redundancy
 	Given a Partition Region
 	Then Region property numberOfBucketsWithRedundancy = 1
 	
 	