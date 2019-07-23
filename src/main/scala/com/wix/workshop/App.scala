package com.wix.workshop

import com.wix.workshop.cache.ContactsCache
import com.wix.workshop.model.Contact

/**
 * @author ${user.name}
 */
object App {
  
  def foo(x : Array[String]) = x.foldLeft("")((a,b) => a + b)
  
  def main(args : Array[String]) {
    val cache = new ContactsCache
    while(true) {
      val contact = Contact("1", "shay")
      cache.getContact(contact)
    }
  }

}
