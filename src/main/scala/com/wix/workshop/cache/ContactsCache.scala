package com.wix.workshop.cache

import com.wix.workshop.model.Contact

class ContactsCache {

  var contacts: Seq[Contact] = Nil

  def getContact(contact: Contact): Contact = {
    if(contacts.contains(contact)){
      contact
    } else {
      contacts = contacts :+ contact
      contact
    }
  }


}
