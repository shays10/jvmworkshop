package com.wix.app5

import scala.concurrent.ExecutionContext
import scala.util.Random

object App5 {

  def main(args : Array[String]) {
    println("App5 Starting....")

    val ec = ExecutionContext.fromExecutorService(java.util.concurrent.Executors.newFixedThreadPool(300))

    for (_ <- 1 to 300) {
      ec.submit(new Worker)
    }

  }

}
