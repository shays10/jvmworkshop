"The Lightweight Contact Retriever" - Solution
-----------------------------------------------

You probably noticed that our app is misbehaving, using A LOT of memory over time and when we take a heap dump
 our `Contact` class has a lot of instances. 
 More over, it's "Surviving Generation" metrics keeps on growing and growing, a strong indication of a memory leak.
 
The root cause is that our `ContactId` class implemented `hashcode` without `equals`.
Failing to do so causes our Cache (that is based on a `HashMap`) to misbehave and basically act like a `List`.
It fails to correctly `.get` on our map, so we end up storing all of our Contacts in the map infinitely.

Implementing `equals`: 
``` 
override def equals(that: Any): Boolean =
       that match {
         case that: ContactId => that.canEqual(this) && this.id == that.id
         case _ => false
       }
       
def canEqual(a: Any): Boolean = a.isInstanceOf[ContactId]
```

solves the issue. If you will run the app again you will see that memory graph looks like it should, and
if you will take a heap dump will see exactly 10 instances of `Contact`
