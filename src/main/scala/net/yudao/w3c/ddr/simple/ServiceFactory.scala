package net.yudao.w3c.ddr.simple

import net.yudao.w3c.ddr.simple.exceptions.{InitializationException, SystemException}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.5 ServiceFactory Class</a>
 */
object ServiceFactory {
  def newService(clazz: String, defaultVocabulary: String, configuration: Map[String, String]): Service = (clazz, defaultVocabulary) match {
    case ("", value) => throw new SystemException(SystemException.ILLEGAL_ARGUMENT, "Service class cannot be null")
    case (value, "") => throw new SystemException(SystemException.ILLEGAL_ARGUMENT, "Default vocabulary cannot be null")
    case (null, value) => throw new SystemException(SystemException.ILLEGAL_ARGUMENT, "Service class cannot be null")
    case (value, null) => throw new SystemException(SystemException.ILLEGAL_ARGUMENT, "Default vocabulary cannot be null")
    case _ => {
      try {
        val service: Service = Class.forName(clazz).newInstance().asInstanceOf[Service]
        service.initialize(defaultVocabulary, configuration)
        service
      } catch {
        case e@(_: IllegalAccessException | _: ClassNotFoundException ) =>
          throw new InitializationException(InitializationException.INITIALIZATION_ERROR, e)
        case _: Exception => throw new SystemException(SystemException.CANNOT_PROCEED, "")
      }
    }
  }
}
