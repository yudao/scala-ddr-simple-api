import net.yudao.w3c.ddr.simple.exceptions.{InitializationException, SystemException}
import net.yudao.w3c.ddr.simple.ServiceFactory
import org.specs2.mutable._

class ServiceFactoryStress extends Specification {

  object o1 {
    def apply() = ServiceFactory.newService("mobi.example.DDRService", null, null)
  }

  object o2 {
    def apply() = ServiceFactory.newService(null, "http://www.w3.org/2008/01/DDR-Core-Vocabulary", null)
  }

  object o3 {
    def apply() = ServiceFactory.newService("mobi.example.DDRService", "", null)
  }

  object o4 {
    def apply() = ServiceFactory.newService("", "http://www.w3.org/2008/01/DDR-Core-Vocabulary", null)
  }

  override def is = s2"""

  This is a specification to check the Service Factory Object

  ServiceFactory should
    throw SystemException if default vocabulary is null                                 $e1
    throw SystemException if Service class is null                                      $e2
    throw SystemException if default vocabulary is empty                                $e3
    throw SystemException if Service class is empty                                     $e4
    throw InitializationException when Service class can't be initialized               $e5
                                                                                        """

  def e1 = o1() must throwA[SystemException](message = "Default vocabulary cannot be null")

  def e2 = o2() must throwA[SystemException](message = "Service class cannot be null")

  def e3 = o3() must throwA[SystemException](message = "Default vocabulary cannot be null")

  def e4 = o4() must throwA[SystemException](message = "Service class cannot be null")

  def e5 = ServiceFactory.newService("mobi.example.DDRService", "http://www.w3.org/2008/01/DDR-Core-Vocabulary", null) must throwA[InitializationException](message = "code: 300")
}
