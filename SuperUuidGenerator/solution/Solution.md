# "SuperUUID Tokens Generator" App - Solution

As you already figured out, our app isn't working properly and prints out duplicates token for different requests.
After taking a heap dump, go to `OQL Console` and run the query

```select x from com.wix.app5.model.SuperUuidWrapper x```

You should see instances of `SuperUuidWrapper` that were never removed.

Our naive implementation is using `ThreadLocal` for storing our UUID. Unfortunately, we are never removing the `ThreadLocal` instances when the request is destroyed. This is causing a ThreadLocal leak.
Since our Jetty thread pool is reusing threads for different requests, and a `ThreadLocal` variable is initialized once per thread (and never removed) we are seeing duplicate values for different requests.

Solving it is quite easy. In our `RequestListener` implement the following:

```
override def requestDestroyed(servletRequestEvent: ServletRequestEvent): Unit = {
   superUuidThreadLocal.remove()
 }
```

This will clean up after each request is destroyed, and the next time out thread will serve a request
it will generate a brand new SuperUUID.
