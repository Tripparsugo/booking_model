package booking

object FlightFlexibility extends Enumeration {
  type FlightFlexibility = Value

  val Light: FlightFlexibility = Value("First")
  val Standard: FlightFlexibility = Value("Business")
  val Flexible: FlightFlexibility = Value("Second");
}
