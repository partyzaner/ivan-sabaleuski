import DefaultCaps.Companion.AndroidBaseCapabilities
import io.appium.java_client.android.AndroidDriver
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class BaseTest {
    var driver: AndroidDriver? = null
    protected open var caps: DesiredCapabilities? = AndroidBaseCapabilities().caps
    private val headSpinAPIToken: String = "your-api-token-here"
    private val webDriverURL: URL = URL("https://appium-dev.headspin.io/v0/$headSpinAPIToken/wd/hub")

    @BeforeAll
    fun setUp() {
        this.driver = AndroidDriver(webDriverURL, caps)
    }

    @AfterAll
    fun tearDown() {
        this.driver!!.quit()
    }
}