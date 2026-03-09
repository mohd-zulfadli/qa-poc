import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PerfTest extends Simulation {
  val protocol = karateProtocol()
  val test = scenario("API Load Test")
    .exec(karateFeature("classpath:examples/api.feature"))

  setUp(
    test.inject(rampUsers(50) during (30 seconds))
  ).protocols(protocol)
}
