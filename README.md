JVM Workshop

Objectives
In today's workshop we will simulate common use cases of JVM problems you might run into when you application misbehaves.
We will learn how to troubleshoot and diagnose JVM issues in our application using a set of utilities below:

What's in our toolbox?
1. jps 
2. Visual VM  (link to install goes here)
3. Visual VM GC Plugin
4. MAT
5. jmap

App #1
------

1. In your terminal navigate to ??? a and run ???. Your app is now running.
2. In a spearate terminal window, locate your PID via jmap.
3. Open VisualVM, locate your app and monitor it. 
4. What is happening? Can you guess? (Link to the solution can be found here ???)
5. While the app is still running (If it crashed, rerun it), take a heapdump via:
  a. VisualVM
  b. jmapoom
  c. JVM flag for taking a heap dump automatically
6. Investigate one of the heap dump. Can you locate the problem? (Try to use all of the information. Memory usage, CPU usage, GC behavior and the objects allocation tab.
7. Open the source code and try to locate and fix the problem

App #2
------
1. In your terminal navigate to ??? a and run ???. Your app is now running.
2. In a spearate terminal window, locate your PID via jmap.
3. Take a thread dump via `jstack <PID>`
4. Analyze it via https://fastthread.io or any other online tool you know 
5. Can you guess what is happening? How can we solve it?
6. Open the source code and try to fix the problem (solution is here ????)

App #3
------
1. In your terminal navigate to ??? a and run ???. Your app has crashed.
2. Open the source code and try to fix the problem (solution is here ????)

App #4
------
1. In your terminal navigate to ??? a and run ???. Your app crashed.
2. Run it with a JVM flag to automatically take a heap dump on OOM.
3. Investigate the heap dump. 
4. Run the app again, this time with -Xmx???
5. Monitor it. Do you think there is a leak? (Solution is here ???)

