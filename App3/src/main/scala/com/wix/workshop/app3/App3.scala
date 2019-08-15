package com.wix.workshop.app3

import scala.concurrent.{ExecutionContext, Future}

object App3 {

  def main(args: Array[String]) {
    val ectx = ExecutionContext.fromExecutorService(java.util.concurrent.Executors.newFixedThreadPool(10))
    for (i <- 1 to 100000) {
      myFuture(i)(ectx)
    }
  }

  def myFuture(i: Int)(implicit ec: ExecutionContext): Future[Int] = Future {
    Thread.sleep(500)
    i
  }

}