1. Fp Data Structures - part II

2. Techathon
   - research and analysis
   - preparing slides

3. Spark Stages
   - Jobs that are divided into several tasks, form a stage.
   1. ShuffleMapStage: 
     - takes input for other stages
     - many jobs can use single ShuffleMap stage.
   2. Result Stage:
     - Final stage, actions are performed here.