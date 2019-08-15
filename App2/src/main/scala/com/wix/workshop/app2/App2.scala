package com.wix.workshop.app2

import com.wix.workshop.app2.bankmanager.ResilientTransferManager
import com.wix.workshop.app2.model.Account

object App2 {

  def main(args: Array[String]) {
    println("App2 Starting....")

    val manager = new ResilientTransferManager
    val fooAccount = Account(name = "Foo", balance = 1000)
    val barAccount = Account(name = "Bar", balance = 1000)

    val t1 = new Thread(() => {
      for (_ <- 0 until 100) manager.transfer(fooAccount, barAccount, amount = 5)
    })
    val t2 = new Thread(() => {
      for (_ <- 0 until 100) manager.transfer(barAccount, fooAccount, amount = 5)
    })

    t1.start()
    t2.start()

    t1.join()
    t2.join()
    println(s"Done! ${fooAccount.name} has ${fooAccount.balance}")
    println(s"Done! ${barAccount.name} has ${barAccount.balance}")
  }
}