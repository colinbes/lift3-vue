package com.besterdesigns.snippet 

import com.besterdesigns.lib.{DateTimeUtils, EmptyRoundTrip}
import net.liftweb.http.{RoundTripHandlerFunc, RoundTripInfo}
import net.liftweb.http.RoundTripInfo.handledBuilder
import net.liftweb.json.{JString, JValue, parse}
import net.liftweb.util.Helpers.StringToCssBindPromoter
import org.joda.time.{DateTime, DateTimeZone}

trait MyRT extends EmptyRoundTrip {
  
  protected def doSimpleRT(value :JValue, func :RoundTripHandlerFunc) :Unit = {
    func.send(JString("Yay, it worked - There and back again!!"))
  }

  protected def doSomething(value :JValue, func :RoundTripHandlerFunc) :Unit = {
    val response = """{"name":"Index page"}"""
    val json = parse(response);
    func.send(json)
  }   

  private val roundTrips:List[RoundTripInfo] = List("doSimpleRT" -> doSimpleRT _, "doSomething" -> doSomething _)
  override def getRoundTrips = super.getRoundTrips ++ roundTrips
}

class IndexSnippet extends MyRT  {    
  def render() = {
//    addServices("$myRTFunctions");
    
//    val mk :DateTimeConverter = LiftRules.dateTimeConverter.vend
//    val dt = mk.formatDateTime(new Date())
    val now = DateTime.now()
    val Austin = DateTimeZone.forID("America/Chicago")
    val dt1 = DateTimeUtils.print(now)
    val dt2 = DateTimeUtils.print(now, Austin)
    val dt = s"$dt1 $dt2"

    "#angularscript" #> services("myServices") &
    "#time *" #> dt
  } 
}