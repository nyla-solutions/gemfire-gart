#Author: Gregory.Green@dell.com
Feature: Performance
  
   Scenario: have time statistics disenabled
    Given Member enable-time-statistics
    Then Set enable-time-statistics=false 
 
   Scenario: System Resource Usage
   Given Member
   Then FreeMemory >= 50% of Maximum Heap Size

    
    Scenario:  CPU allocation per number of cache server nodes
    Given a Cache Server 
    Then Assert Machine #CPU > 4
    
    Scenario: Partitioned Region Bucket Sizing
    Given a Partitioned Region
    Then Assert List Fixed Partition Attributes totalNumBuckets >= (10 * Cache Server Count)
    
    
    Scenario: Cache Server JVM Heap Sizing
    Given a Cache Server
    Then Assert MaxMemory <= 64GB
    
    Scenario: Region Entries Only On Disk
    Given a Region With Persistence
    Then Assert TotalEntriesOnlyOnDisk <= 10% of SystemRegionEntryCount
    And TotalEntriesOnlyOnDisk > 10% of Members EntryCounts
    
    