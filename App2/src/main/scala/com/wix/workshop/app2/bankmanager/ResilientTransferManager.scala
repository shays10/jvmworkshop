package com.wix.workshop.app2.bankmanager

import com.wix.workshop.app2.model.Account

class ResilientTransferManager {

  def transfer(fromAccount: Account, toAccount: Account, amount: Double): Unit = {
    if (fromAccount.balance < amount) throw new InsufficientFundsException(s"Missing funds for ${fromAccount.name}")

    fromAccount.synchronized({
      toAccount.synchronized({
        transferInternal(fromAccount, toAccount, amount)
        Thread.sleep(5)
      })
    })

  }

  private def transferInternal(fromAccount: Account, toAccount: Account, amount: Double): Unit = {
    fromAccount.balance -= amount
    toAccount.balance += amount
  }
}

class InsufficientFundsException(msg: String) extends RuntimeException(msg)