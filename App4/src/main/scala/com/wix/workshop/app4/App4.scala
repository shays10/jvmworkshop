package com.wix.workshop.app4

import scala.concurrent.{ExecutionContext, Future}
import scala.io.Source

object App4 {

  def main(args: Array[String]) {
    for (i <- 1 to 1000000) {
      Source.fromFile("src/main/resources/title.basics.tsv").getLines()
    }
  }


}
