object Main extends App {
  val password = "abcd3XXd3a"
  println(s"$password = " +
    Password.Password(password,
      Password.validateMinLen(5),
      Password.validateMaxLen(10),
      Password.validateOneCapitalLetter,
      Password.validateOneSmallLetter,
      Password.validateTwoDigits)
  )
}