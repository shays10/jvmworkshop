package com.wix.workshop.app1.cache

import com.wix.workshop.app1.model.{Contact, ContactId}

import scala.collection.immutable.HashMap

class ContactsCache {

  var contacts: Map[ContactId, Contact] = HashMap.empty

  def getContact(id: Long): Contact = {
    val contactId = new ContactId(id)
    contacts.get(contactId) match {
      case Some(contact) => contact
      case None =>
        val contact = getContactFromDB(contactId)
        contacts = contacts + (contactId -> contact)
        contact
    }
  }

  //This emulates a remote call to DB
  private def getContactFromDB(contactId: ContactId): Contact = {
    // The 'arr' parameter is here to make the Contact object larger. It's not the root cause.
    Contact(contactId.getId, "firstName", "lastName", "address", "city", "zipCode", arr = new Array[String](1024 * 10))
  }
}
