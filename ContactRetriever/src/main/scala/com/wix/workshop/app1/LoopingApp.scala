package com.wix.workshop.app1

import com.wix.workshop.app1.cache.ContactsCache
import com.wix.workshop.app1.model.ContactId

import scala.util.Random


object LoopingApp {

  def main(args: Array[String]) {
    println("Looping Starting....")
    val cache = new ContactsCache
    while (true) {
      cache.getContact(new ContactId(Random.nextInt(10)))
    }
  }
}
