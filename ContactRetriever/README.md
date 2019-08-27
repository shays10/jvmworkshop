
### First App: "The Lightweight Contact Retriever"

The Lightweight Contact Retriever application allows you to get any contact you'd like, and fast!
It introduces a revolutionary cache mechanism that will save you plenty of time and network latency.

When a contact request arrives, if the contact is already in the cache we will extract it from there. Otherwise,
we'll call our remote and slow DB, cache the contact and return it.

To test that it is working properly, let's fire up the server and see what happens

1. In your terminal navigate to `ContactRetriever`, execute `./compile.sh` and `./run.sh`. Your Jetty server should be up and running.

2. In a separate terminal window, locate your PID via `jps`.

3. Open `jvisualvm` (From terminal), locate your app and go to the `Monitor` tab. 

4. run `./create_load.sh`, It will create 10K requests. 
Each request will try to retrieve one of the first 10 contacts (So eventually there should be no more than 10 contacts in our Cache)

5. Back to JVisualVM. You should see the Heap graph going wild. To investigate further, let's take a heap dump. In JVisualVM: `Monitor` tab -> `Heap dump` (right upper corner) 
Let's open the heap dump and look at the `Classes` tab. What is wrong here? 

6. Let's try to gather the "[Surviving Generations](https://blogs.oracle.com/nbprofiler/what-do-the-surviving-generations-metrics-mean)" metric: 
    1. Make sure the app is still running and creating contacts
    2. Go to `Profiler` tab and configure your setting as follows:
   ![Memory profiling](../memoryprofiling.png)
    3. Click on `Memory` to start profiling. Watch the `generations` metric. What are we seeing?

7. Kill the app. 

8. Let's try to simulate faster what will happen over time. Let's increase the rate of requests
(by simply looping infinitely) while decreasing the heap size.
Run `./fast_run.sh` - It will do that for you. Eventually, the app will crash.

9. Open the source code in your favorite IDE. (load the `pom.xml` in `/jvmworkshop`). Locate and try to fix the problem.

Solution [is here](/ContactRetriever/solution/Solution.md)
