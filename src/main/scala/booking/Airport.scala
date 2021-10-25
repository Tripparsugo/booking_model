package booking

case class Airport(code: String, location: City){
  require(code.matches("\\w{3}"))
}
