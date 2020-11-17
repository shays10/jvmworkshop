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

1. [The Lightweight City Retriever](/CityRetriever/README.md)
2. [The Always Correct Money Transfer](/MoneyTransfer/README.md)
3. [Airbnb Reviews Analyzer](/AirbnbReviews/README.md)
4. [SuperUUID Tokens Generator](/SuperUuidGenerator/README.md)


## Reading Materials
[How do I take heap dumps in production machines?](https://stackoverflow.com/c/wix/questions/251) 

[Udemy Course - Java Memory Management](https://wix2019.udemy.com/java-memory-management/learn/lecture/6125082#overview)

["Surviving Generations" metric - explained](https://blogs.oracle.com/nbprofiler/what-do-the-surviving-generations-metrics-mean)
