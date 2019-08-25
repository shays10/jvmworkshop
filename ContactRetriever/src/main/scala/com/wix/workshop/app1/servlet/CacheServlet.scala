package com.wix.workshop.app1.servlet

import java.io.OutputStreamWriter

import com.wix.workshop.app1.cache.ContactsCache
import com.wix.workshop.app1.model.Contact
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class CacheServlet extends HttpServlet {
  val cache: ContactsCache = new ContactsCache

  override protected def doGet(req: HttpServletRequest, resp: HttpServletResponse): Unit = {
    val contact = cache.getContact(req.getParameter("contactId").toLong)
    createResponse(resp, contact)
  }

  private def createResponse(resp:HttpServletResponse, contact: Contact): Unit = {
    resp.setContentType("text/plain")
    val writer = new OutputStreamWriter(resp.getOutputStream)
    writer.write("Contact is: ")
    writer.write("\n")
    writer.write(contact.toString)
    writer.close()
  }
}
