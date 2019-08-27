"The Lightweight City Retriever" - Solution
-----------------------------------------------

You probably noticed that our app is misbehaving.

Even though we just requested 10 unique cities, our app used A LOT of memory over time. 
When we take a heap dump we can see that our `City` class has a lot of instances. (Precisely 10K instances after 10K requests) 

Moreover, it's "Surviving Generation" metrics keeps on growing and growing, a strong indication of a memory leak.
 
The root cause is that our `CityId` class implemented `hashcode` without `equals`.
Failing to do so causes our Cache (that is based on a `HashMap`) to misbehave and act like a `List`, storing duplicate values.
It fails to correctly `.get` on our map, so we end up storing all of the cities in the map until we crash with an `OutOfMemoryException`.

Changing our `CityId` class to a `case class` will solve the issue.
```
case class CityId(id: Long) 
```
In a `case class`, `equals` and `hashcode` are overridden for us, by default.

If you will run the app again you will see that memory graph looks like it should, and
if you will take a heap dump will see exactly 10 instances of `City`
