package com.wix

import com.wix.servlet.YouTubeServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHandler

object App {

  def main(args: Array[String]) {
    println("YouTube Likes Calculator Starting....")
    val server = new Server(8080)
    val handler = new ServletHandler()
    server.setHandler(handler)
    handler.addServletWithMapping(classOf[YouTubeServlet], "/*")
    server.start()
    server.join()
  }
}
