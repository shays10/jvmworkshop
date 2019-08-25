package com.wix.workshop.app2.model

import java.util.UUID

case class Account(id: UUID, name: String, var balance: Double)

object Account {
  def apply(name: String, balance: Double): Account =
    Account(UUID.randomUUID(), name, balance)
}
