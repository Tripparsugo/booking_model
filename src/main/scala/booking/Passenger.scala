package booking

import scala.collection.mutable.ListBuffer


class Passenger(name: String) {
  private var reservations = new ListBuffer[Reservation]()

  def addReservation(reservation: Reservation): Unit = {
    reservations += reservation
  }

  def getReservations(): List[Reservation] = {
    reservations.toList
  }
}
