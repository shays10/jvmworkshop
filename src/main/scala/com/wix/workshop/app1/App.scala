package com.wix.workshop.app1

import com.wix.workshop.app1.cache.ContactsCache
import com.wix.workshop.app1.model.ContactId

/**
 * @author ${user.name}
 */
object App {

  def main(args : Array[String]) {
    val cache = new ContactsCache
    while(true) {
      cache.getContact(ContactId(1L))
      println(cache.contacts.size)
    }
  }

}
