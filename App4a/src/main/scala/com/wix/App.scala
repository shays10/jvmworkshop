package com.wix

import scala.io.Source
import scala.util.Try

/**
 * Hello world!
 *
 */
object App  {

  val LIKE_COL = 8

  def main(args: Array[String]) {
    executeSuperComplexStuff()
    avgLikesForCountry("US")
    avgLikesForCountry("FR")
    avgLikesForCountry("GB")
    executeSuperComplexStuff()
  }

  private def avgLikesForCountry(code: String): Unit = {
    val source = Source.fromResource(s"${code}videos.csv")

    val likesSeq = source.getLines().map { line ⇒
      val cols = line.split(",").map(_.trim)
      val maybeLikesStr = cols.lift(LIKE_COL)
      maybeLikesStr.flatMap(l ⇒ Try(l.toLong).toOption).getOrElse(0l)
    }.toSeq

    val avg = likesSeq.foldLeft(0L)(_ + _) / likesSeq.size
    println(s"The Average likes for a video in the $code is $avg")
  }

  def executeSuperComplexStuff(): Unit = Thread.sleep(10000)
}
