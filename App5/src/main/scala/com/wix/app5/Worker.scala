package com.wix.app5

import scala.util.Random

class Worker extends Runnable {
  val aRatherLargeString = Random.alphanumeric.take(100).mkString
  val threadLocal = ThreadLocal.withInitial[WorkerUUID](() => WorkerUUID(aRatherLargeString))

  def run() {
    val threadLocalVal = threadLocal.get()
    println(threadLocalVal)
  }
}
