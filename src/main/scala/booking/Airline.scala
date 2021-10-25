package booking

case class Airline(name: String, code: String) {
  require(code.matches("\\w*"))
}
