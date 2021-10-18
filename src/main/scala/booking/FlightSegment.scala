package booking

class FlightSegment(from: Airport, to: Airport, marketedBy: Airline, operatedBy: Airline, seat: Seat, flightNumber: Int) {
  def this(from: Airport, to: Airport, marketedBy: Airline, seat: Seat, flightNumber: Int) {
    this(from, to, marketedBy, marketedBy, seat, flightNumber)
  }

}
