# Scala W3C Device Description Repository Simple API

By [Yudao](https://github.com/yudao/).

[![Build Status](https://api.travis-ci.org/yudao/scala-ddr-simple-api.png?branch=master)](http://travis-ci.org/yudao/scala-ddr-simple-api)
[![Code Climate](https://codeclimate.com/github/yudao/scala-ddr-simple-api.png)](https://codeclimate.com/github/yudao/scala-ddr-simple-api)

**Scala DDR Simple Api** is a simple port of the W3C Java DDR Simple API which can be found [here](http://www.w3.org/TR/DDR-Simple-API/DDRSimpleAPI.jar) and his [javadoc](http://www.w3.org/TR/DDR-Simple-API/javadoc/).

The W3C DDR Simple Api specifications, for their, can be found [here](http://www.w3.org/TR/DDR-Simple-API/#sec-java-representation)

## Installation

Clone this repository:

```console
git clone https://github.com/yudao/scala-ddr-simple-API.git ./scala-ddr-simple-API && cd scala-ddr-simple-API
```

Run the test if you want

```console
sbt test
```

## Import into your SBT project

In your build.sbt:

```scala
RootProject( uri("git://github.com/yudao/scala-ddr-simple-API.git#v1.0") )
```

## Usage

**Scala DDR Simple Api** is just a specification api that follow the W3C DDR recommendation.

This recommendation hold a FactoryService for faciliting the creation of all Service to implement.

```scala
import net.yudao.w3c.ddr.simple.{Service, ServiceFactory}
val service1:Service = ServiceFactory.newService("mobi.example.DDRService", "http://www.w3.org/2008/01/DDR-Core-Vocabulary", Map("property1"->"value1", "property2"->"value2"))
```

This will return an implemented service (your own) with this trait:

```scala
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
```

## Improvements

I'm sure, **Scala DDR Simple Api** can be improved with, by example, the exceptions parts to be more concise and maybe some other occurs guru scala tips ;)

## Information

### Bug reports

If you discover any bugs or any bad implementation from the W3C DDR SImple API, feel free to create an issue on GitHub. Please add as much information as possible to help us fixing the possible bug. We also encourage you to help even more by forking and
sending us a pull request.

https://github.com/yudao/scala-ddr-simple-API/issues

## Maintainers

* Yudao (https://github.com/yudao)

## License

WTFPL License. Copyright 2014 Yudao. https://github.com/yudao/
