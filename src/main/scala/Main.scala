import booking._

object Main {
  def main(args: Array[String]): Unit = {

    val passenger = Passenger("Alex")
    val losAngeles = City("Los angeles")
    val laAirport = Airport("", losAngeles)
    val sydney = City("sydney")
    val syAirport = Airport("", sydney)
    val honolulu = City("Los angeles")
    val hoAirport = Airport("", honolulu)
    val oceanicAirlines = Airline("Oceanic Airlines", "OA")
    val pamAirAirlines = Airline("Pan Am Airlines", "PAA")
    val seat1 = new Seat("1A")
    val seat2 = new Seat("2A")
    val seat3 = new Seat("3A")
    val fare1 = Fare("DFFAU", FlightClass.Business, FlightFlexibility.Flexible, 4500)
    val fare2 = Fare("LLLAU", FlightClass.Second, FlightFlexibility.Standard, 1000)
    val segment1 = new FlightSegment(laAirport, syAirport, oceanicAirlines, seat1, 815)
    val segment2 = new FlightSegment(syAirport, hoAirport, oceanicAirlines, seat2, 700)
    val segment3 = new FlightSegment(hoAirport, laAirport, oceanicAirlines, pamAirAirlines, seat3, 100)


    val trip1 = Trip(Set[FlightSegment](segment1), fare1, passenger)
    val trip2 = Trip(Set[FlightSegment](segment2, segment3), fare2, passenger)

    val booking = Booking(Set[Trip](trip1, trip2))

//Making the same booking with a builder:
    val bookingPlanner = BookingPlanner.planBooking()
    bookingPlanner.addTripFor(passenger).withFare(fare1)
      .withFlight().operatedBy(oceanicAirlines).marketedBy(oceanicAirlines)
      .from(laAirport).to(syAirport).withFlightCode(815).sittingIn(seat1).finishTrip()

    bookingPlanner.addTripFor(passenger).withFare(fare2)
      .withFlight().operatedBy(oceanicAirlines).marketedBy(oceanicAirlines)
      .from(syAirport).to(hoAirport).withFlightCode(700).sittingIn(seat2)
      .withFlight().operatedBy(oceanicAirlines).marketedBy(pamAirAirlines)
      .from(hoAirport).to(laAirport).withFlightCode(100).sittingIn(seat3).finishTrip()

    val bookingFromBuilder: Booking = bookingPlanner.finishBooking()



  }
}


//Possible builder:
// planner = Booking.plan();
//planner.addTrip(fare).withFlight(code).from(airport1).to(airport2).sittingIn(seat1)
// .thenFlight(code).to(airport3).sittingIn(sea2);
// planner.addTrip(fare).withFlight(code).from(airport1).to(airport2).sittingIn(seat1)
// .thenFlight(code).to(airport3).sittingIn(sea2);
// Booking booking = planner.getBooking()
