package com.wix.servlet

import java.io.OutputStreamWriter

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

import scala.io.Source
import scala.util.Try

class YouTubeServlet extends HttpServlet {
  val LIKE_COL = 8

  override protected def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val countriesSeq = Seq("US", "FR", "GB")

    createResponse(resp, countriesSeq.map(avgLikesForCountry))
  }

  private def avgLikesForCountry(code: String): (String, Long) = {
    val file = Source.fromResource(s"${code}videos.csv").getLines().mkString
    val source = file.split("\n")
    val likesSeq = source.map { line ⇒
      val cols = line.split(",").map(_.trim)
      val maybeLikesStr = cols.lift(LIKE_COL)
      maybeLikesStr.flatMap(l ⇒ Try(l.toLong).toOption).getOrElse(0l)
    }.toSeq

    (code, likesSeq.foldLeft(0L)(_ + _) / likesSeq.size)
  }

  private def createResponse(resp: HttpServletResponse,
                             res: Seq[(String, Long)]): Unit = {
    resp.setContentType("text/plain")
    val writer = new OutputStreamWriter(resp.getOutputStream)
    writer.write("\n")
    res.foreach(r ⇒ writer.write(s"The Average likes for a video in the ${r._1} is ${r._2}\n"))
    writer.close()
  }
}
