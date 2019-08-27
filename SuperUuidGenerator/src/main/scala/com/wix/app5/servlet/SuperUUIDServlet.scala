package com.wix.app5.servlet

import java.io.OutputStreamWriter

import com.wix.app5.listener.RequestListener._
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class SuperUUIDServlet extends HttpServlet {

  override protected def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    resp.setContentType("text/plain")
    val writer = new OutputStreamWriter(resp.getOutputStream)
    writer.write(printUuid())
    writer.close()
  }

  private def printUuid(): String = {
    s"Doing important stuff in thread ${Thread.currentThread().getName} - " +
      s"Our unique SuperUUID is ${superUuidThreadLocal.get.uuid.take(10)} \n"
  }
}
