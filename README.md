# [Workshop] Troubleshooting the JVM 

## Before we start
Make sure you're connected to VPN

## Objectives & Toolbox

In today's workshop we will simulate common use cases of JVM problems you might run into when your application misbehaves.

We will learn how to troubleshoot and diagnose JVM issues in our application using a our toolbox below:

`jps` - JVM Process Status Tool. Allows you to find the PID of your running JVMs.

`jmap` - Memory Map. Allows you to take histograms and heapdumps.

`jstack` - Allows us to print the stack traces of all threads that are attached to our JVM (e.g. Thread dump)

`jvisualvm`  - Allows you to monitor and troubleshoot apps on the JVM.

All of them are already installed on your machine if you have JDK installed.

## Let's Start!

Below you will find a list of sample apps. Simple, yet misbehaving apps. 

### First App: "The Lightweight Contact Retriever"

The Lightweight Contact Retriever application allows you to get any contact you'd like, and fast!
It introduces a revolutionary cache mechanism that will save you plenty of time and network latency.

When a contact request arrives, if the contact is already in the cache we will extract it from there. Otherwise,
we'll call our remote and slow DB, cache the contact and return it.

To test that it is working properly, let's fire up the server and see what happens

1. In your terminal navigate to `ContactRetriever`, execute `./compile.sh` and `./run.sh`. Your jetty server should be up and running.

2. In a separate terminal window, locate your PID via `jps`.

3. Open `jvisualvm` (From terminal), locate your app and go to the `Monitor` tab. 

4. run `./create_load.sh`, It will create 10K requests. Each request will try to retrieve one of the first 10 contacts.

5. Back to JVisualVM. You should see the Heap graph going wild.
To investigate further, let's take a heap dump. Try one of the following methods:
    * JVisualVM: `Monitor` tab -> `Heap dump` (right upper corner)
    * jmap. (By running `jmap -dump:live,file=<filename> <pid>`)  
Let's open the heap dump and look at the `Classes` tab. What is wrong here?  
6. Let's try to gather the "[Surviving Generations](https://blogs.oracle.com/nbprofiler/what-do-the-surviving-generations-metrics-mean)" metric: 
    1. Make sure the app is still running and creating contacts
    2. Go to `Profiler` tab and configure your setting as follows:
   ![Memory profiling](memoryprofiling.png)
    3. Click on `Memory` to start profiling. Watch the `generations` metric. What are we seeing?

7. Kill the app. 

8. Let's try to simulate faster what will happen overtime. Let's increase the rate of requests
(by simply looping infinitely) while decreasing the heap size.
Run `./fast_run.sh` - It will do that for you. Let it run until it crashes.

9. Open the source code in your favorite IDE. (load the `pom.xml` in `/jvmworkshop`). Locate and try to fix the problem.

Solution [is here](/ContactRetriever/solution/Solution.md)

### Second App: "The Always Correct Money Transfer" 
The Always Correct Money Transfer application allows you to safely and conveniently transfer money from one account to the other.
It keeps your account safe and only withdraws the amount it should.

To test that it is working properly, running our app will transfer 5$ from `Foo` account to `Bar` and 5$ from `Bar` account to `Foo`.
After completing it will print out the current balance of each account.

1. In your terminal navigate to `MoneyTransfer`, execute `./compile.sh` and `./run.sh`. Your app is now running.
2. Take a thread dump via `jstack <PID>`
3. Investigate the results yourself or upload the results to https://fastthread.io
4. You figured out what went wrong, awesome! Open the source code and try to fix the problem (while keeping our app "Always correct"!)
5. Rerun the app and make sure it completes successfully.

Solution [is here](/MoneyTransfer/solution/Solution.md)

### Third App: "Airbnb Reviews Analyzer"
The Airbnb Reviews Analyzer is an app that can read a CSV file that contains reviews on an Airbnb property, parse it
and figure out how many positive and negative reviews are there, using a super complex algorithm! 

To test that it is working properly, running our app will analyze only the first 3K reviews (out of ~200K reviews)

1. In your terminal navigate to `AirbnbReviews` execute `./compile.sh` and `./run.sh`. 
2. Again, go to the `Monitor` tab in `JVisualVM`. What is wrong? There's one metric that is abnormal.
3. Open the source code, understand the problem and mitigate it. 
4. Rerun the app to make sure that the issue is solved.

Solution [is here](/AirbnbReviews/solution/Solution.md)

### Fourth App: "YouTube Likes Calculator"
The YouTube Likes Calculator is an app that can read CSV files that contains data on YouTube videos such as: views, likes review dates and more.
 
The app goes over the data and calculates the average likes for video per country.

1. In your terminal navigate to `LikesCalculator` execute `./compile.sh` and `./run.sh`.  Your Jetty server should be up and running.
2. Run `curl localhost:8080/` to fire up a single request. You app has crashed!
3. Maybe run the app with more memory. `java -Xmx512M -jar target/LikesCalculator-1.0-SNAPSHOT-jar-with-dependencies.jar`
4. In a separate terminal window run `./create_load.sh`. This will fire 10K requests. 
5. What is happening? Is there a leak? (Try to use the `Surviving Generations` metric again).

Solution [is here](/LikesCalculator/solution/Solution.md)

### Fifth App: "SuperUUID Tokens Generator"
The SuperUUID Tokens Generator App generates a REALLY long String that will represent the context id for
the scope of every request that will be made to the server. 
Obviously, the main requirement is that each request must have its own unique ID.

To test that it is working properly, Let's run the app and fire requests.
 
1. In your terminal navigate to `SuperUuidGenerator` and execute `/.compile.sh` and `./run.sh`. Your Server is now running
2. Run the `./create_load.sh` script. It will fire 100 requests while printing out their IDs.
3. Is the output valid? What is wrong here?
4. Let's also investigate via JVisualVM. This time, take a heap dump, open it and navigate to "OQL Console"
5. Create a query to find out if there are instances that were not GCed of the class that is holding our UUID (`com.wix.app5.model.SuperUuidWrapper`)
6. Open the source code, understand the problem and mitigate it. 
7. Rerun the app to make sure that the issue is solved.

Solution [is here](/SuperUuidGenerator/solution/Solution.md)

## Reading Materials

