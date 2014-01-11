package net.yudao.w3c.ddr.simple

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.1 Evidence Interface</a>
 */
trait Evidence {

  def put(s: String, s1: String): Unit

  def exists(s: String): Boolean

  def get(s: String): String
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.2 PropertyName Interface</a>
 */
trait PropertyName {

  def getLocalPropertyName: String

  def getNamespace: String
}


/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.2 PropertyName Interface</a>
 */
object PropertyRef {
  val NULL_ASPECT: String = "__NULL"
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.3 PropertyRef Interface</a>
 */
trait PropertyRef {

  def getLocalPropertyName: String

  def getAspectName: String

  def getNamespace: String
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.4 PropertyValue Interface</a>
 */
trait PropertyValue {

  def getDouble: Double

  def getLong: Long

  def getBoolean: Boolean

  def getInteger: Int

  def getEnumeration: Array[String]

  def getFloat: Float

  def getPropertyRef: PropertyRef

  def getString: String

  def exists(): Boolean
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.2.5 PropertyValues</a>
 */
trait PropertyValues {

  def getAll: Array[PropertyValue]

  def getValue(propertyRef: PropertyRef): PropertyValue
}

/**
 * See <a href="http://www.w3.org/TR/DDR-Simple-API/">http://www.w3.org/TR/DDR-Simple-API/#4.3 Service Interface</a>
 */
trait Service {

  def initialize(s: String, properties: Map[String, String]): Unit

  def getAPIVersion: String

  def getDataVersion: String

  def listPropertyRefs(): Array[PropertyRef]

  def getPropertyValue(evidence: Evidence, propertyRef: PropertyRef): PropertyValue

  def getPropertyValue(evidence: Evidence, propertyName: PropertyName): PropertyValue

  def getPropertyValue(evidence: Evidence, s: String): PropertyValue

  def getPropertyValue(evidence: Evidence, s: String, s1: String, s2: String): PropertyValue

  def getPropertyValues(evidence: Evidence): PropertyValues

  def getPropertyValues(evidence: Evidence, propertyRefs: Array[PropertyRef]): PropertyValues

  def getPropertyValues(evidence: Evidence, s: String): PropertyValues

  def getPropertyValues(evidence: Evidence, s: String, s1: String): PropertyValues

  def newPropertyName(s: String): PropertyName

  def newPropertyName(s: String, s1: String): PropertyName

  def newPropertyRef(s: String): PropertyRef

  def newPropertyRef(propertyName: PropertyName): PropertyRef

  def newPropertyRef(propertyName: PropertyName, s: String): PropertyRef

  def newHTTPEvidence(): Evidence

  def newHTTPEvidence(map: Map[String, String]): Evidence
}


