JVM Workshop
------------

Objectives & Installations
--------------------------

In today's workshop we will simulate common use cases of JVM problems you might run into when you application misbehaves.
We will learn how to troubleshoot and diagnose JVM issues in our application using a our toolbox below:

1. jps
2. jmap
2. Visual VM  (Install from https://github.com/visualvm/visualvm.src/releases/download/1.4.3/VisualVM_143.dmg)
3. Visual VM GC Plugin (Install it via: Visual VM -> Tools -> Plugins)
4. MAT (Install from https://www.eclipse.org/mat/downloads.php)


Below you will find a list of sample apps. Simple, yet misbehaving apps. 

App #1
------

1. In your terminal navigate to `App1`, execute `/.compile.sh` and `./run.sh`. Your app is now running.
2. In a spearate terminal window, locate your PID via jps. (It should be under the name `App1-1.0-SNAPSHOT-jar-with-dependencies.jar` 
3. Open VisualVM, locate your app and monitor it. 
4. What is happening? Can you guess? 
5. To investigate further, let's take a heap dump. Take it via:
  a. VisualVM
  b. jmap. (By running `jmap -dump:live,file=<filename> <pid>`)
6. Investigate one of the heap dump. Can you locate the problem? (Try to use all of the information. Memory usage, CPU usage, GC behavior and the objects allocation tab)
7. Open the source code in your favorite IDE. Locate and try to locate and fix the problem.

App #2
------
1. In your terminal navigate to `App2`, execute `/.compile.sh` and `./run.sh`. Your app is now running.
2. This time, take a thread dump via `jstack <PID>`
3. Investigate the results yourself or upload the results to https://fastthread.io
4. You figured out what went wrong, awesome! Open the source code and try to fix the problem (while keeping the same logic that is being used)
5. Rerun the app and make sure it completes successfully.

Airbnb Reviews Analyzer
-----------------------
The third app is an app and can read CSV file that contains reviews on Airbnb properties, parse it
and figure out how many positive and negative reviews are there, using a super complex algorithm! 

1. In your terminal navigate to `App3b` execute `/.compile.sh` and `./run.sh`. 
2. This time, your app has crashed.
3. Open the source code, understand the problem and mitigate it. (solution is here ????)

App #4
------
1. In your terminal navigate to ??? a and run ???. Your app crashed.
2. Run it with a JVM flag to automatically take a heap dump on OOM.
3. Investigate the heap dump. 
4. Run the app again, this time with -Xmx???
5. Monitor it. Do you think there is a leak? (Solution is here ???)


Solutions
---------
App1


Reading Materials
-----------------

