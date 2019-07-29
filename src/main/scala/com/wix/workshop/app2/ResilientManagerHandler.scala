package com.wix.workshop.app2

import com.wix.workshop.app1.model.Contact

case class LockObject()

class ResilientManagerHandler {
  val mySet: Seq[Contact] = Seq.empty
  val lockA: LockObject = LockObject()
  val lockB: LockObject = LockObject()


  def add(contact: Contact) = {
    lockA.synchronized({
      lockB.synchronized( {
        //TODO: add impl
      })
    })
  }

  def removeFirst() = {
    lockB.synchronized({
      lockA.synchronized( {
        //TODO: add impl
      })
    })
  }


}
