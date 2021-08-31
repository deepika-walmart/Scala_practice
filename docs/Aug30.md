1. Passing functions to Spark hands on
2. Local vs. cluster modes and closures
        - A program executing locally may lead to errors in cluster mode,
        - This can happen when closures are not taken care of
        - Closure is a set of variables or methods which must be available to each node in order to perform operations on RDD.
        - Solution: use Accumulators
3. Printing rdd elements on local and cluster modes
        - local -> rdd.foreach(println) or rdd.map(println)
        - cluster -> rdd.collect().foreach(println)// this may cause driver run out of memory, so we better use rdd.take(100).foreach(println)
4. Working with key-value pairs in RDDs
        - the operations are available in PairRDDFunctions class