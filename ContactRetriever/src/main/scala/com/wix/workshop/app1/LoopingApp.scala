package com.wix.workshop.app1

import com.wix.workshop.app1.cache.ContactsCache

import scala.util.Random


object LoopingApp {

  def main(args: Array[String]) {
    println("Looping Starting....")
    val cache = new ContactsCache
    while (true) {
      cache.getContact(Random.nextInt(10))
    }
  }
}
