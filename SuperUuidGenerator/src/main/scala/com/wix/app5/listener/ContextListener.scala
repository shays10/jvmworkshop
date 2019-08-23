package com.wix.app5.listener

import javax.servlet.annotation.WebListener
import javax.servlet.{ServletContextEvent, ServletContextListener}

@WebListener
class ContextListener extends ServletContextListener {
  override def contextInitialized(sce: ServletContextEvent): Unit = {
    sce.getServletContext.addListener(new RequestListener())
  }

  override def contextDestroyed(servletContextEvent: ServletContextEvent): Unit = {

  }
}
