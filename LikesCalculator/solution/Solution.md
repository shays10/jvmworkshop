"YouTube likes statistics" - Solution
-----------------------------------------------

Did the app crushed? what is the problem?
go to JVisualVm -> check the heap usage, we can see that the heap is full, is it due to a leak?
 or the business logic of the app.
 
the app loads a data set file of youtube statistics and analyze it.
in this case some optimizations can be done:
1. increase the xmx parameter using  `java -Xmx512M -jar target/LikesCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar` 
or from `Edit configuration -> Vm options -> -Xmx512M ` 
1. change the what the app work by reading chunks of the file...


