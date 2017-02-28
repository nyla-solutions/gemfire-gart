Feature: Check Cache XMLAssert all partitioned region gateway sender ids are parallel

	Scenario Outline: Assert gateway sender has enable batch conflation is true for performance improvements
	 
		When Assert gateway sender enable batch conflation is true

Scenario Outline: Warning cache server socket buffer size not set

		When Assert cache sender socket buffer size is set	
		
Scenario Outline: disk store allow  auto compact not set then there may be compaction peak usage

		When Assert disk store auto compact is false
		
Scenario Outline: disk store allow force compaction should be set to true to allow schedule compactions

		When Assert disk store allow force compaction is true
		
Scenario Outline: partitioned region region attribute gateway sender ids must be parallel
		When Assert all partitioned region gateway sender ids are parallel

Scenario Outline: region region attribute statistics enabled is true 
		When Assert region region attribute statistics enabled is true

		