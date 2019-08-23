# "The Always Correct Money Transfer App" - Solution

As you already figured out, our app isn't properly as it never completes.
In order to protect our accounts and make our `transfer` method atomic by making sure no other thread is modifying either account concurrently, 
we are invoking `synchronized` on both accounts.

By doing so we created a deadlock since our threads are acquiring resources and then cyclically try to acquire 
other thread's resources without releasing their own. In short, we have a cycle. 

We have to break the cycle by ordering our resources. Whenever resources are acquired in the same order there is 
no danger of deadlock.

First, let's add a unique identifier to our `Account` case class

```
case class Account(uuid: Long, name: String, var balance: Double)
```

Pass the new argument when creating our `Account` objects 

And this will be our new `transfer` method:

```
 def transfer(fromAccount: Account, toAccount: Account, amount: Double): Unit = {
    if (fromAccount.balance < amount) throw new InsufficientFundsException(s"Missing funds for ${fromAccount.name}")

    if (fromAccount.uuid > toAccount.uuid) {
      fromAccount.synchronized({
        toAccount.synchronized({
          transferInternal(fromAccount, toAccount, amount)
        })
      })
    } else {
      toAccount.synchronized({
        fromAccount.synchronized({
          transferInternal(fromAccount, toAccount, amount)
        })
      })
    }
    Thread.sleep(5)

  }
```  
