package com.besterdesigns.lib

import net.liftweb.http.RoundTripInfo
import net.liftweb.http.S
import net.liftweb.http.js.JE.JsRaw

abstract class PageRoundTrips {
  protected def getRoundTrips : List[RoundTripInfo]
}
 
class EmptyRoundTrip extends PageRoundTrips {
  protected def getRoundTrips : List[RoundTripInfo] = Nil
  
  def addServices(functionName: String) = {
    for {
      session <- S.session
    } {
        val data = s"""window.vue.$functionName = ${session.buildRoundtrip(getRoundTrips).toJsCmd}"""
        println(s"inserting data $data")
        S.appendGlobalJs(JsRaw(data).cmd)
    }
  }
} 