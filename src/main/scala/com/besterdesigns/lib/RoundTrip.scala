package com.besterdesigns.lib

import net.liftweb.common.Empty
import net.liftweb.http.RoundTripInfo
import net.liftweb.http.S
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmds
import net.liftweb.http.js.JsCmds._

import scala.xml.NodeSeq

abstract class PageRoundTrips {
  protected def getRoundTrips : List[RoundTripInfo]
}
 
class EmptyRoundTrip extends PageRoundTrips {
  protected def getRoundTrips : List[RoundTripInfo] = Nil

  /**
   * Return roundtrip functions referenced by services name
   * @return NodeSeq
   */
  def services(serviceName: String): NodeSeq = {
    val res = for {
      session <- S.session
    } yield {
      val rt = session.buildRoundtrip(getRoundTrips).toJsCmd
      val data = s"var $serviceName=${rt}"
      Script(JsRaw(data).cmd)
    }
    res.getOrElse(Script())
  }

  /**
   * Insert roundtrip in vue angular space.
   * @param functionName
   */
  def addServices(functionName: String) = {
    for {
      session <- S.session
    } {
        val data = s"""window.vue.$functionName = ${session.buildRoundtrip(getRoundTrips).toJsCmd}"""
        S.appendGlobalJs(JsRaw(data).cmd)
    }
  }
} 