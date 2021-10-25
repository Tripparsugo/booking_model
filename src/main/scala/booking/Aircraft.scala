package booking

case class Aircraft(code: String){
  require(code.matches("[\\w0-9]{3}"))
}
