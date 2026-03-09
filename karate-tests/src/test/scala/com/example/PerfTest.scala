import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class PerfTest extends Simulation {

  // Define Karate protocol (can add custom headers, etc.)
  val protocol = karateProtocol()

  // Point to your feature file location
  val testScenario = scenario("ADVANCED API Load Test")
    .exec(karateFeature("classpath:com/example/karate/karateAdvanced.feature@ADVANCED"))

  // Configure load model
  setUp(
    testScenario.inject(rampUsers(20) during (20 seconds))
  ).protocols(protocol)
}
