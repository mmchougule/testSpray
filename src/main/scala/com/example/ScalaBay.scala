package com.example


import akka.actor.ActorSystem
import spray.routing.SimpleRoutingApp
import spray.http.MediaTypes

object ScalaBay extends App with SimpleRoutingApp {
  implicit val actorSystem = ActorSystem()
  val plentyOfSilicon = Amber.ambers
  //"hellough"

  startServer(interface = "localhost", port = 8080) {
    get {
      path("hello") {
        complete {
          "Hello here!"
        }
      }
    } ~
    get {
      path("list" / "all") {
        respondWithMediaType(MediaTypes.`application/json`) {
          complete {
            Amber.toJson(plentyOfSilicon)
          }
        }
      }
    } ~
    get {
      path("amber" / IntNumber / "details") { index =>
        complete {
          Amber.toJson(plentyOfSilicon(index))
        }
      }
    }
  }
}