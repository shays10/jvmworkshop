package com.wix

import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

import scala.concurrent.{ExecutionContext, ExecutionContextExecutorService, Future}
import scala.io.Source
import scala.util.{Failure, Success}

object App  {

  val positiveReviews: AtomicInteger = new AtomicInteger()
  val negativeReviews: AtomicInteger = new AtomicInteger()
  val positiveKeywords: Set[String] = Set("amazing", "awesome", "great", "divine", "perfect", "good")
  val negativeKeywords: Set[String] = Set("terrible", "disgusting", "horrific", "bad", "scam", "fraud")
  val REVIEW_COLUMN = 6

  implicit val ec: ExecutionContextExecutorService = ExecutionContext.fromExecutorService(Executors.newCachedThreadPool())

  def main(args: Array[String]) {
    parseReviews()
  }

  private def parseReviews(): Unit = {
    val source = Source.fromResource("reviews.csv")
    val analyzedReviews: Set[Future[Unit]] = source.getLines().take(3000).map { analyzeLine }.toSet
    Future.sequence(analyzedReviews).onComplete( {
      case Success(_) =>
        println(s"Positive Reviews: ${positiveReviews.get()}")
        println(s"Negative Reviews: ${negativeReviews.get()}")
      case Failure(t) =>
        println("An error has occurred: " + t.getMessage)
    })
  }


  private def analyzeLine(line: String) = Future {
    val cols = line.split(",").map(_.trim)

    cols.lift(REVIEW_COLUMN).foreach(review => {
      executeSuperComplexStuff()
      if (positiveKeywords.exists(review.contains(_))) {
        positiveReviews.incrementAndGet()
      }
      if (negativeKeywords.exists(review.contains(_))) {
        negativeReviews.incrementAndGet()
      }
    })
  }

  def executeSuperComplexStuff(): Unit = Thread.sleep(3000)
}
