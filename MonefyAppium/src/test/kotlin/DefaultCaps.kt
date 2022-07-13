import org.openqa.selenium.remote.DesiredCapabilities

class DefaultCaps {
    companion object {
        fun AndroidBaseCapabilities(): DesiredCapabilities {
            val caps = DesiredCapabilities()
            caps.setCapability("autoAcceptAlerts", true)
            caps.setCapability("platformName", "Android")
            caps.setCapability("automationName", "UiAutomator2")
            caps.setCapability("deviceName", "Pixel 4 API 33")
            //caps.setCapability("udid", "8ABY0H6YG")
            caps.setCapability("appPackage", "com.google.android.apps.magazines")
            caps.setCapability("appActivity",
                "com.google.apps.dots.android.app.activity.CurrentsStartActivity")
            return caps
        }
    }
}