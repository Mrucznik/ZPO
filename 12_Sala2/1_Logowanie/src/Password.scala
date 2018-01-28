object Password {

  def Password(string: String, valitations:((String) => Boolean)*): Boolean = {
    valitations.forall(
      (f: ((String) => Boolean)) => f(string)
    )
  }

  def validateMinLen(minLen: Int)(string: String): Boolean = {
    string.length >= minLen
  }

  def validateMaxLen(maxLen: Int)(string: String): Boolean = {
    string.length <= maxLen
  }

  def validateOneCapitalLetter(string: String): Boolean = {
    string.matches(".*[A-Z]+.*")
  }

  def validateOneSmallLetter(string: String): Boolean = {
    string.matches(".*[a-z]+.*")
  }

  def validateOneDigit(string: String): Boolean = {
    string.matches(".*\\d.*")
  }

  def validateTwoDigits(string: String): Boolean = {
    string.matches(".*\\d.*\\d.*")
  }
}
