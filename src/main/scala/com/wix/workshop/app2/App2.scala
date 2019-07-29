package com.wix.workshop.app2

import com.wix.workshop.app1.model.Contact

object App2 {

  def main(args: Array[String]) {
    val manager = new ResilientManagerHandler
    val contact = Contact(1, "", "", "", "", "")

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
