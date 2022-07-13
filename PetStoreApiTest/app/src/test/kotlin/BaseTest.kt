import io.restassured.RestAssured
import io.restassured.builder.MultiPartSpecBuilder
import io.restassured.builder.RequestSpecBuilder
import io.restassured.config.LogConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.LogDetail
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {

    companion object {
        lateinit var requestSpec: RequestSpecification
//        lateinit var requestImageSpec: MultiPartSpecBuilder

        const val BASE_URI = "https://petstore3.swagger.io"
        const val BASE_PATH = "api/v3"
    }

    @BeforeAll
    fun setUp() {
        val logConfig = LogConfig.logConfig()
            .enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL)
        val config = RestAssuredConfig.config().logConfig(logConfig)

        requestSpec = RequestSpecBuilder()
            .setBaseUri(BASE_URI)
            .setBasePath(BASE_PATH)
            .setContentType(ContentType.JSON)
            .setRelaxedHTTPSValidation()
            .setConfig(config)
            .build()
//        requestImageSpec = MultiPartSpecBuilder()
//            .fileName()
//            .setBaseUri(BASE_URI)
//            .setBasePath(BASE_PATH)
//            .setContentType(ContentType.)
//            .setRelaxedHTTPSValidation()
//            .setConfig(config)
//            .build()
    }

    @AfterAll
    fun tearDown() {
        RestAssured.reset()
    }
}
