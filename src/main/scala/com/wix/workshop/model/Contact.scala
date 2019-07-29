package com.wix.workshop.model

import scala.util.Random

case class ContactId(id: Long) {
  override def hashCode(): Int = Random.nextInt() //FIXME: understand why we cant implement proper hashcode without equals
}

case class Contact(id: Long, firstName: String, lastName: String, address: String, city: String, zipCode: String)