package com.wix

import scala.io.Source

/**
 * Hello world!
 *
 */
object App  {
  def main(args: Array[String]) {
    println(Source.fromResource("USVideos.csv").getLines().size)
    Thread.sleep(100000000)
  }

}
