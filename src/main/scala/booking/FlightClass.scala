package booking

object FlightClass extends Enumeration {
  type FlightClass = Value

  val First: FlightClass = Value("First")
  val Business: FlightClass = Value("Business")
  val Second: FlightClass = Value("Second");
}
