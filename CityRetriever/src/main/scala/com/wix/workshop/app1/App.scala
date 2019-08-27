package com.wix.workshop.app1

import com.wix.workshop.app1.servlet.CacheServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHandler

object App {

  def main(args: Array[String]) {

    println("CityRetriever Starting....")
    val server = new Server(8080)
    val handler = new ServletHandler()
    server.setHandler(handler)
    handler.addServletWithMapping(classOf[CacheServlet], "/*")
    server.start()
    server.join()
  }


}
