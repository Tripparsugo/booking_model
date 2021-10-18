package booking

object FlightFlexibility extends Enumeration {
  type FlightFlexibility = Value

  val Light: FlightFlexibility = Value("Light")
  val Standard: FlightFlexibility = Value("Standard")
  val Flexible: FlightFlexibility = Value("Flexible");
}
