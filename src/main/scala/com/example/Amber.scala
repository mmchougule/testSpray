package com.example


import org.json4s.native.Serialization
import org.json4s.native.Serialization._
import org.json4s.ShortTypeHints

trait Amber

case class BalticAmber(size: Int) extends Amber

case class MinedAmber(country: String, size: Int) extends Amber

object Amber {
  val ambers = List[Amber](
    MinedAmber(country = "Spray Sample 1", size = 5),
    MinedAmber(country = "Scala Project", size = 20),
    BalticAmber(size = 10)
  )

  private implicit val formats = Serialization.formats(ShortTypeHints(List(classOf[MinedAmber], classOf[BalticAmber])))
  def toJson(ambers: List[Amber]): String = writePretty(ambers)
  def toJson(amber: Amber): String = writePretty(amber)
}
