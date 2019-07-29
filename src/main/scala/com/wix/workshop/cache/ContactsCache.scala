package com.wix.workshop.cache

import com.wix.workshop.model.{Contact, ContactId}

import scala.collection.immutable.HashMap

class ContactsCache {

  var contacts: Map[ContactId, Contact] = HashMap.empty

  def getContact(contactId: ContactId): Contact = {
    contacts.get(contactId) match {
      case Some(contact) => contact
      case None =>
        val contact = getContactFromDB(contactId)
        contacts += contactId -> contact
        contact
    }
  }

  def getContactFromDB(contactId: ContactId) = {
    Contact(contactId.id, "firstName", "lastName", "address", "city", "zipCode")
  }
}
