package net.yudao.w3c.ddr.simple.exceptions

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.2 DDRException Class</a>
 */
sealed trait DDRExceptionTrait {
  protected var _code: Int = _

  protected var _message: String = _

  def getCode: Int = _code

  def code_=(code: Int): Unit = _code = code
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.2 DDRException Class</a>
 */
class DDRException(code: Int, message: String, cause: Throwable) extends Exception(message, cause) with DDRExceptionTrait {
  def this(code: Int, cause: Throwable) = this(code, "code: " + code.toString, cause)

  def this(code: Int, message: String) = this(code, message, new Exception(message))
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.2 DDRException Class</a>
 */
object DDRException {
  val IMPLEMENTATION_ERROR: Int = 0x10000
  val serialVersionUID: Long = 0x6f0b26fcL
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.3 InitializationException</a>
 */
class InitializationException(code: Int, message: String, cause: Throwable) extends DDRException(code, message, cause) {
  def this(code: Int, cause: Throwable) = this(code, "code: " + code.toString, cause)

  def this(code: Int, message: String) = this(code, message, null)
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.3 InitializationException</a>
 */
object InitializationException {
  val INITIALIZATION_ERROR: Int = 300
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.4 NameException Class</a>
 */
class NameException(code: Int, message: String, cause: Throwable) extends DDRException(code, message, cause) {
  def this(code: Int, cause: Throwable) = this(code, "code: " + code.toString, cause)

  def this(code: Int, message: String) = this(code, message, null)
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.4 NameException Class</a>
 */
object NameException {
  val PROPERTY_NOT_RECOGNIZED: Int = 100
  val VOCABULARY_NOT_RECOGNIZED: Int = 200
  val ASPECT_NOT_RECOGNIZED: Int = 800
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.1 SystemException Class</a>
 */
class SystemException(code: Int, message: String, cause: Throwable) extends RuntimeException(message, cause) with DDRExceptionTrait {
  def this(code: Int, cause: Throwable) = this(code, "code: " + code.toString, cause)

  def this(code: Int, message: String) = this(code, message, new Exception(message))
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.1 SystemException Class</a>
 */
object SystemException {
  val ILLEGAL_ARGUMENT: Int = 400
  val CANNOT_PROCEED: Int = 500
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.5 ValueException Class</a>
 */
class ValueException(code: Int, message: String, cause: Throwable) extends DDRException(code, message, cause) {
  def this(code: Int, cause: Throwable) = this(code, "code: " + code.toString, cause)

  def this(code: Int, message: String) = this(code, message, null)
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.4.5 ValueException Class</a>
 */
object ValueException {
  val INCOMPATIBLE_TYPES: Int = 600
  val NOT_KNOWN: Int = 900
  val MULTIPLE_VALUES: Int = 10000
}
