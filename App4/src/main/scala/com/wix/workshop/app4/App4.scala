package com.wix.workshop.app4

import scala.concurrent.{ExecutionContext, Future}
import scala.io.Source

object App4 {

  def main(args: Array[String]) {
    scala.io.Source.fromResource("/title.basics.tsv").mkString

  }


}
