package com.wix.workshop.app2

case class LockObject()

class ResilientTransferManager {

  def transfer(fromAccount: Account, toAccount: Account, amount: Double): Unit = {
    if (fromAccount.balance < amount) throw new InsufficientFundsException(s"Missing funds for ${fromAccount.name}")

    fromAccount.synchronized({
      toAccount.synchronized({
        fromAccount.balance -= amount
        toAccount.balance += amount
        Thread.sleep(5)
      })
    })

  }
}

class InsufficientFundsException(msg: String) extends RuntimeException(msg)