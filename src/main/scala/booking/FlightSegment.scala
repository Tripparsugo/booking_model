package booking

class FlightSegment(from: Airport, to: Airport, marketedBy: Airline, operatedBy: Airline, seat: Seat, number: Int) {
  def this(from: Airport, to: Airport, marketedBy: Airline, seat: Seat, number: Int) {
    this(from, to, marketedBy, marketedBy, seat, number)
  }

}
