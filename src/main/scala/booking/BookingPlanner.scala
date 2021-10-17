package booking

class BookingPlanner private () {
  private var trips: Set[Trip] = Set()


  def addTripFor(passenger: Passenger): A1 = {
    fare => new SegmentAccumulator(passenger, fare)
  }

  private def registerTrip(segments: List[FlightSegment], passenger: Passenger, fare: Fare): BookingPlanner = {
    trips += new Trip(Set(segments), fare, passenger)
    this
  }


  def finishBooking(): Booking = {
    Booking(trips)
  }


  trait A1 {
    def withFare(fare: Fare): SegmentAccumulator
  }


  class SegmentAccumulator(passenger: Passenger, fare: Fare) {
    val segments: List[FlightSegment] = List()

    trait B1 {
      def operatedBy(airline: Airline): B2
    }

    trait B2 {
      def marketedBy(airline: Airline): B3
    }

    trait B3 {
      def from(city: Airport): B4
    }

    trait B4 {
      def to(city: Airport): B5
    }

    trait B5 {
      def withFlightCode(flightCode: Int): B6
    }

    trait B6 {
      def sittingIn(seat: Seat): SegmentAccumulator
    }


    def finishTrip(): BookingPlanner = {
      registerTrip(segments, passenger, fare)
      BookingPlanner.this;
    }


    def withFlight(): B1 = {
      operatedBy =>
        marketedBy =>
          from =>
            to =>
              flightCode =>
                seat => {
                  segments.appended(new FlightSegment(from, to, marketedBy, operatedBy, seat, flightCode))
                  this
                }


    }

  }

}


object BookingPlanner{
  def planBooking(): BookingPlanner = {
    new BookingPlanner()
  }
}
