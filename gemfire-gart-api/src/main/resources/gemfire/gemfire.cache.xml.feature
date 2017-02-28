Feature: Check Cache XML Assert all partitioned region gateway sender ids are parallel

Background:
  Given cache xml files: 
  
  | src/test/resources/cache-xmls/server1.xml|


	Scenario: Assert gateway sender has enable batch conflation is true for performance improvements
	 
		Then Assert gateway sender enable batch conflation is true

Scenario: Warning cache server socket buffer size not set

		Then Assert cache server socket buffer size is set	

Scenario: Warning gateway sender socket buffer size not set

		Then Assert gateway sender socket buffer size is set	
		
				
Scenario: disk store allow  auto compact not set then there may be compaction peak usage

		Then Assert disk store auto compact is false
		
Scenario: disk store allow force compaction should be set to true to allow schedule compactions

		Then Assert disk store allow force compaction is true
		
Scenario: partitioned region region attribute gateway sender ids must be parallel
		Then Assert all partitioned region gateway sender ids are parallel

Scenario: region region attribute statistics enabled is true 
		Then Assert region region attribute statistics enabled is true

		