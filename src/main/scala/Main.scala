import booking._

object Main {
  def main(args: Array[String]): Unit = {

    val passenger = new Passenger("Alex")
    val losAngeles = City("Los angeles")
    val laAirport = Airport("CCC", losAngeles)
    val sydney = City("sydney")
    val syAirport = Airport("AAA", sydney)
    val honolulu = City("Los angeles")
    val hoAirport = Airport("BBB", honolulu)
    val oceanicAirlines = Airline("Oceanic Airlines", "OA")
    val pamAirAirlines = Airline("Pan Am Airlines", "PAA")
    val seat1 = Seat("3A", FlightClass.Business)
    val seat2 = Seat("2A", FlightClass.Second)
    val seat3 = Seat("3A", FlightClass.Second)
    val fare1 = Fare("DFFAU", FlightClass.Business, FlightFlexibility.Flexible, 4500)
    val fare2 = Fare("LLLAU", FlightClass.Second, FlightFlexibility.Standard, 1000)
    val segment1 = new FlightSegment(laAirport, syAirport, oceanicAirlines, seat1, 815)
    val segment2 = new FlightSegment(syAirport, hoAirport, oceanicAirlines, seat2, 700)
    val segment3 = new FlightSegment(hoAirport, laAirport, oceanicAirlines, pamAirAirlines, seat3, 100)

    val reservation1 = Reservation(segment1, seat1)
    val reservation2 = Reservation(segment2, seat2)
    val reservation3 = Reservation(segment3, seat3)

    passenger.addReservation(reservation1)
    passenger.addReservation(reservation2)
    passenger.addReservation(reservation3)

    val trip1 = Trip(Set[FlightSegment](segment1), fare1, List(passenger))
    val trip2 = Trip(Set[FlightSegment](segment2, segment3), fare2, List(passenger))

    val booking = Booking(Set[Trip](trip1, trip2))

    printf(booking.toString)
  }
}


