package booking

import booking.FlightClass.FlightClass
import booking.FlightFlexibility.FlightFlexibility


case class Fare(fareBasis: String, flightClass: FlightClass, flightFlexibility: FlightFlexibility, price: Int)


