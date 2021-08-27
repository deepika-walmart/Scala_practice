**1. Spark RDDs (Resilient Distributed Dataset)**

   - Fundamental data structure of Spark
     - Immutable collection of Objects
     - Why is it needed?
         1. Fault tolerance
         2. Fast computation
         3. Iterative algorithms
         4. Data Mining tools
     - Spark RDDs vs DSM(Distributed Shared Memory) in terms of 
         1. Read 
              - (RDD-> either fine or coarse grained)
              - (DSM->fine-grained)
         2. Write
             - (RDD-> coarse grained)
             - (DSM->fine-grained)
         3. Consistency
             - (RDD-> high, RDDs are immutable)
             - (DSM-> Set of rules should be followed)
         4. Fault recovery
             - (RDD-> lineage graphs)
             - (DSM -> rollbacks)
         5. Straggler Mitigation
             - (RDD-> easy, use backup task)
             - (DSM -> difficult to obtain)
         6. Low RAM
             - (RDD-> can be shifted to disk)
             - (DSM -> performance decreases)
     - Features : in-memory computation, persistence, fault tolerance, lazy evaluation, location stickiness, immutability
     - Operations
         1. Transformation
             - Doesn't change the input, produces one or many RDDs as output
             - lazy
             - Examples: map(),filter(),etc.
         2. Action
             - outputs non-RDD values
             - Examples: first(),count(),collect(), etc
     - Limitations

**2. iCode session** 

**3. Infosec-trainings**

**4. Functional Programming** 
    - Pattern Matching