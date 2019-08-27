### Second App: "The Always Correct Money Transfer" 
The Always Correct Money Transfer application allows you to safely and conveniently transfer money from one account to the other.
It keeps your account safe and only withdraws the amount it should.

To test that it is working properly, running our app will transfer 5$ from `Foo` account to `Bar` and 5$ from `Bar` account to `Foo`.
After completing it will print out the current balance of each account.

1. In your terminal navigate to `MoneyTransfer`, execute `./compile.sh` and `./run.sh`. Your app is now running but never completes.
2. Take a thread dump via `jstack <PID>`
3. Investigate the results yourself or upload the results to https://fastthread.io
4. You figured out what went wrong, awesome! Open the source code and try to fix the problem (while keeping our app "Always correct"!)
5. Rerun the app and make sure it completes successfully.

Solution [is here](solution/Solution.md)
