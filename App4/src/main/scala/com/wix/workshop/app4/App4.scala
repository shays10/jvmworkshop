package com.wix.workshop.app4

import scala.io.Source
import scala.util.Try

object App4 {

  val LIKE_COL = 8

  def main(args: Array[String]) {
    Thread.sleep(10000)
    avgLikesForCountry("US")
    avgLikesForCountry("FR")
    avgLikesForCountry("GB")
    Thread.sleep(10000)
  }

  private def avgLikesForCountry(code: String): Unit = {
    val source = Source.fromFile(s"App4/src/main/resources/${code}videos.csv")

    val likesSeq = source.getLines().map { line ⇒
      val cols = line.split(",").map(_.trim)
      val maybeLikesStr = cols.lift(LIKE_COL)
      maybeLikesStr.flatMap(l ⇒ Try(l.toLong).toOption).getOrElse(0l)
    }.toSeq

    val avg = likesSeq.foldLeft(0L)(_ + _) / likesSeq.size
    println(s"The Average likes for a video in the $code is $avg")
  }
}

