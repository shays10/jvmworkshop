package com.wix.workshop.app1.servlet

import java.io.OutputStreamWriter

import com.wix.workshop.app1.cache.CityCache
import com.wix.workshop.app1.model.City
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class CacheServlet extends HttpServlet {
  val cache: CityCache = new CityCache

  override protected def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val city = cache.getCity(req.getParameter("cityId").toLong)
    createResponse(resp, city)
  }

  private def createResponse(resp:HttpServletResponse, city: City): Unit = {
    resp.setContentType("text/plain")
    val writer = new OutputStreamWriter(resp.getOutputStream)
    writer.write("City is: ")
    writer.write("\n")
    writer.write(city.toString)
    writer.close()
  }
}
