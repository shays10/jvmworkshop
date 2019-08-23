package com.wix.app5.listener

import com.wix.app5.listener.RequestListener.superUuidThreadLocal
import com.wix.app5.model.SuperUuidWrapper
import javax.servlet.annotation.WebListener
import javax.servlet.{ServletRequestEvent, ServletRequestListener}

import scala.util.Random

@WebListener
class RequestListener extends ServletRequestListener {

  override def requestInitialized(servletRequestEvent: ServletRequestEvent): Unit = {
    println(s"${Thread.currentThread().getName} token is ${superUuidThreadLocal.get().uuid.take(10)}")
  }

  override def requestDestroyed(servletRequestEvent: ServletRequestEvent): Unit = {
    superUuidThreadLocal.remove()
  }
}

object RequestListener {
  val superUuidThreadLocal: ThreadLocal[SuperUuidWrapper] = ThreadLocal.withInitial[SuperUuidWrapper](() =>
    SuperUuidWrapper(Random.alphanumeric.take(100).mkString))

}