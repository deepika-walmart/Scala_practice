1. Shuffle Operations in Spark
    - Redistribution of data across various nodes
    - consumes heap memory
    - involves disk I/O, network I/O, data serialization
    - e.g.: repartition, coalesce, "ByKey" operations and join operations
   
2. RDD Persistence
   - caching a dataset in memory.
   - each node stores their own partition
   - the cached dataset can be used for actions on the partitioned dataset
   - very useful for fast processing of iterative algorithms
   - persist() or cache() methods are used for caching
   - upon any changes in the partition, the previous transformations are automatically run on the cached dataset. Hence, the spark cache is fault-tolerant.
   - Storage Levels: where to persist the data
         1. MEMORY_ONLY:  
            - default
            - RDD is stored as deserialized Java objects in JVM
            - if RDD doesn't fit in, partitions are not stored
         2. MEMORY_AND_DISK:
            - stored as Java objects in JVM
            - if RDD doesn't fit in, store the partitions on Disk
         3. MEMORY_ONLY_SER:
            - store in 1 byte array per partition, i.e., serialized java object
            - memory efficient, CPU-intensive
         4. MEMORY_AND_DISK_SER:
            - Store the partitions that don't fit, in disk
         5. DISK_ONLY:
            - Store the RDDs only on Disk
         6. MEMORY_ONLY_2, MEMORY_AND_DISK_2: 
            - replicate each partition on two cluster nodes
         7. OFF_HEAP: 
            - store data in off-heap memory
   - Choose carefully amongst the options for storage levels:
        - don't use disk storage unless your function for computation is costly
        - for fast fault recovery (e.g., web applications), use replicated storage
     
3. Techathon
    - Preparing slides
    - Exploration, research and discussion on ecommerce sites and their recommendation systems