#Author: Gregory.Green@dell.com
Feature: Disk File System Management

	Scenario: statistic archive files
	When statistic archive file property is not empty
	Then archive-disk-space-limit is > 0
	
	Scenario:log files
	When log level property is not none
	Then log-disk-space-limit > 0
	And log-file-size-limit > 0
	
	Scenario: Disk store
	When Disk Store Used
	Then Assert Auto Compact is false
	And Assert Force Compaction Allowed  is true
	And Assert Disk Usage Critical Percentage < 95
	And TotalBackupCompleted > 1
	
	