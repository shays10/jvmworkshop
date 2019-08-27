# "The Always Correct Money Transfer App" - Solution

As you already figured out, our app isn't working properly as it never completes.
To protect our accounts we have to make sure our `transfer` method is atomic. To make sure 
no other thread is modifying either account concurrently, we are invoking `synchronized` on both accounts.

By doing so we created a deadlock since our threads are acquiring resources and then cyclically try to acquire
other thread's resources without releasing their own. In short, we have a cycle. 

We have to break the cycle by re-ordering our locks. Whenever resources are acquired in the same order there is 
no danger of deadlock.

Our new `transfer` method will be:

```
 def transfer(fromAccount: Account, toAccount: Account, amount: Double): Unit = {
     if (fromAccount.balance < amount) throw new InsufficientFundsException(s"Missing funds for ${fromAccount.name}")
     val (firstLock, secondLock) = if (fromAccount.id > toAccount.id) (fromAccount, toAccount) else (toAccount, fromAccount)
 
     firstLock.synchronized({
       secondLock.synchronized({
         transferInternal(fromAccount, toAccount, amount)
       })
     })
   }
```  
