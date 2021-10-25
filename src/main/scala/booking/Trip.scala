package booking

case class Trip(flightSegments: Set[FlightSegment], fare: Fare, passengers: List[Passenger])


