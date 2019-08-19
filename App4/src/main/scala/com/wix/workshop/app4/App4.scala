package com.wix.workshop.app4

import scala.concurrent.{ExecutionContext, Future}
import scala.io.Source

object App4 {

  def main(args: Array[String]) {
    println(Source.fromFile("App4/src/main/resources/title.basics.tsv").getLines().size)
  }


}
