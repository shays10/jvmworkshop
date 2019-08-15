package com.wix.workshop.app1.model

class ContactId(id: Long) {
  override def hashCode(): Int = id.hashCode()

  def getId: Long = id
}

case class Contact(id: Long, firstName: String, lastName: String, address: String, city: String, zipCode: String)