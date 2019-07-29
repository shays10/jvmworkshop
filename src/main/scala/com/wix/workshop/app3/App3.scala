package com.wix.workshop.app3

import com.wix.workshop.app1.model.Contact

object App3 {

  def main(args: Array[String]) {
    java.util.concurrent.Executors.newFixedThreadPool(2)
    for (_ <- 1 to 10) {
      val thread = new Thread(() => {
        manager.add(contact)
      })
      val thread2 = new Thread(() => {
        manager.removeFirst()
      })
      thread.start()
      thread2.start()
    }
  }

}
