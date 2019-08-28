# "The Always Correct Money Transfer App" - Hint

As you already figured out, our app isn't working properly as it never completes.
In order to protect our accounts we have to make sure our `transfer` method is atomic. In order to make sure 
no other thread is modifying either account concurrently, we are invoking `synchronized` on both accounts.

By doing so we created a deadlock since our threads are acquiring resources and then cyclically try to acquire 
other thread's resources without releasing their own. In short, we have a cycle. 

Whenever resources are acquired in the same order there is no danger of deadlock.

Fix your app so your locks will be properly ordered - so no cycle can occur.
