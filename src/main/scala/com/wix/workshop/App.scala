package com.wix.workshop

import com.wix.workshop.cache.ContactsCache
import com.wix.workshop.model.{Contact, ContactId}

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
