import booking._

object Main {
  def main(args: Array[String]): Unit = {

    val passenger = new Passenger("Alex")
    val losAngeles = City("Los angeles")
    val laAirport = Airport("", losAngeles)
    val sydney = City("sydney")
    val syAirport = Airport("", sydney)
    val honolulu = City("Los angeles")
    val hoAirport = Airport("", honolulu)
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

    //Making the same booking with a builder, in a real world application the constructor of Booking would be made private:
    //    val bookingPlanner = BookingPlanner.planBooking()
    //
    //    bookingPlanner.addTripFor(passenger).withFare(fare1)
    //      .withFlight().marketedBy(oceanicAirlines)
    //      .from(laAirport).to(syAirport).withFlightCode(815).sittingIn(seat1).finishTrip()
    //
    //    bookingPlanner.addTripFor(passenger).withFare(fare2)
    //      .withFlight().marketedBy(oceanicAirlines)
    //      .from(syAirport).to(hoAirport).withFlightCode(700).sittingIn(seat2)
    //      .withFlight().marketedBy(oceanicAirlines).operatedBy(pamAirAirlines)
    //      .from(hoAirport).to(laAirport).withFlightCode(100).sittingIn(seat3).finishTrip()
    //
    //    val bookingFromBuilder: Booking = bookingPlanner.finishBooking()
    //
    //    printf(bookingFromBuilder.toString)
    //    printf(bookingFromBuilder.toString)
    //    printf(bookingFromBuilder.toString)
    //    printf(bookingFromBuilder.toString)


  }
}


//Possible builder:
// planner = Booking.plan();
//planner.addTrip(fare).withFlight(code).from(airport1).to(airport2).sittingIn(seat1)
// .thenFlight(code).to(airport3).sittingIn(sea2);
// planner.addTrip(fare).withFlight(code).from(airport1).to(airport2).sittingIn(seat1)
// .thenFlight(code).to(airport3).sittingIn(sea2);
// Booking booking = planner.getBooking()
