package com.wix.app5

import com.wix.app5.listener.{ContextListener, RequestListener}
import com.wix.app5.servlet.SuperUUIDServlet
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{ServletContextHandler, ServletHandler}

object App {

  def main(args : Array[String]) {
    println("SuperUUID App Starting....")
    val server = new Server(8080)

    val context: ServletContextHandler = new ServletContextHandler
    context.addEventListener(new ContextListener())
    context.addServlet(classOf[SuperUUIDServlet], "/*")
    server.setHandler(context)
    server.start()
    server.join()
  }
}
