package booking

class BookingPlanner private() {
  private var trips: Set[Trip] = Set()


  def addTripFor(passenger: Passenger): A1 = {
    fare => new TripHelper(passenger, fare)
  }

  private def registerTrip(segments: List[FlightSegment], passenger: Passenger, fare: Fare): BookingPlanner = {
    trips += Trip(Set(segments), fare, passenger)
    this
  }


  def finishBooking(): Booking = {
    Booking(trips)
  }


  trait A1 {
    def withFare(fare: Fare): TripHelper
  }


  class TripHelper(passenger: Passenger, fare: Fare) {
    val segments: List[FlightSegment] = List()

    trait B1 {
      def marketedBy(airline: Airline): B2
    }

    trait B2 {
      def operatedBy(airline: Airline): B3

      def from(city: Airport): B4
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
      def sittingIn(seat: Seat): TripHelper
    }


    def finishTrip(): BookingPlanner = {
      registerTrip(segments, passenger, fare)
      BookingPlanner.this;
    }


    def withFlight(): B1 = {
      marketedBy =>
        new B2 {
          def operatedBy(operatedBy: Airline): B3 = {
            from =>
              to =>
                flightCode =>
                  seat => {
                    segments.appended(new FlightSegment(from, to, marketedBy, operatedBy, seat, flightCode))
                    TripHelper.this
                  }
          }

          def from(from: Airport): B4 = {
            to =>
              flightCode =>
                seat => {
                  segments.appended(new FlightSegment(from, to, marketedBy, marketedBy, seat, flightCode))
                  TripHelper.this
                }
          }
        }
    }
  }
}



object BookingPlanner {
  def planBooking(): BookingPlanner = {
    new BookingPlanner()
  }
}
