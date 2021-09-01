1. Transformations in spark:
    - map(func): returns a new dataset formed on the basis of source data
    - filter(func): return a dataset by filtering out rows from initial dataset where func. is true
    - flatmap(func): forms a map (key ->[val1,val2,..]) as per the function
    - mapPartitions(func): a function that runs separately for each partition of RDD (they run locally on each node)
    - mapPartitionsWithIndex(func): runs on each function but keeps not of the original index of partition
    - sample(withReplacement, fraction,seed): sample a fraction of data
    - union(otherDataset): return a union of source dataset and the "otherDataset"
    - intersection()
    - distinct([numPartitions]): returns a dataset containing the distinct elements
    - groupByKey([numPartitions]): returns key->[val1,val2,...]
    - reduceByKey(func,[numPartitions]): forms a dataset of (k,v) pairs from a similar data format by using some aggregate function or a function of type (V,V)->V
    - aggregateByKey(zeroValue)(seqOp,combOp,[numPartitions]): Perform aggregation on the values and output the (k,v) pairs
    - sortByKey([ascending],[numPartitions]): returns (k,v) pairs sorted in ascending or descending order of k
    - join(otherDataset,[numPartitions]): makes (k,v) and (k,w) into (k,(v,w))
    - cogroup(otherDataset,[numPartitions]): makes(k,v) and (k,w) into (k,(iterable v, iterable w))
    - cartesian(otherDataset): pairs the original and the "otherDataset" into (original,"otherDataset")
    - pipe(command,[envVars]): write a transformation to the std. output or read each element from std. input as string.
    - coalesce(numPartitions): decrease the no. of partition in RDD to make it equal to numPartitions
    - repartition(numPartitions): Shuffle and repartition data over the entire network
    - repartitionAndSortWithinPartitions(partitioner):
   
2. Actions in spark:
   - reduce(func): operate on a dataset, func is commutative and associative so that parallel computation is correct.
   - collect(): collect and returns datasets in local nodes to the driver program as an array. Make sure not to use it bluntly, 'cause a larger dataset may cause out of memory error.
   - count(): returns the no. of rows/elements in a dataset
   - first(): returns the first element of dataset
   - take(n): returns first n elements of a dataset
   - takeSample(withReplacement, num,[seed]): return fixed-sized sample subset of RDD.
   - takeOrdered(n,[ordering]): returns first n elements in a specific order
   - saveAsTextFile(path): convert each element to string and store it in a local file system.
   - saveAsSequenceFile(path): write elements as Hadoop SequenceFile and store it in local file system.
   - saveAsObjectFile(path): store elements of a dataset as java serialization which can be loaded as SparkContext.objectFile()
   - countByKey(): dataset is of (k,v) format. returns hashmap of (k,int) pairs
   - foreach(func): performs the function "func" on each element. Be aware of closures

3. Functional Data Structures in Scala - part I