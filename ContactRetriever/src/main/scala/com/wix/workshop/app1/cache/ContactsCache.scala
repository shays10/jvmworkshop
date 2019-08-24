package com.wix.workshop.app1.cache

import com.wix.workshop.app1.model.{Contact, ContactId}

import scala.collection.mutable

class ContactsCache {

  val contacts: mutable.Map[ContactId, Contact] = mutable.HashMap.empty

  def getContact(contactId: ContactId): Contact = {
    contacts.get(contactId) match {
      case Some(contact) => contact
      case None =>
        val contact = getContactFromDB(contactId)
        contacts.put(contactId, contact)
        contact
    }
  }

  def getContactFromDB(contactId: ContactId): Contact = {
    Contact(contactId.getId, "firstName", "lastName", "address", "city", "zipCode") //This emulates a remote call to DB
  }
}
