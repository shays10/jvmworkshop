"Airbnb reviews analyzer" - Solution
-----------------------------------------------

You probably noticed that our app is failing with `Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread`,
 using a lot of threads for analyzing the reviews. 
 
The root cause is our definition of `ExecutionContext`, we currently use `Executors.newCachedThreadPool()`
this causes the app to create more and more threads without limitation until it cant create any more and crashes.

to solve the issue need to initiate it with a limit thread pool
```java
   Executors.newFixedThreadPool(100)
```
The new ExecutionContext will limit the number of new threads and will wait for a tread to be free.
