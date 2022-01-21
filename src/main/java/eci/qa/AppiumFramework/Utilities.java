package eci.qa.AppiumFramework;

import java.util.HashMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class Utilities {

	private AppiumDriver<MobileElement> driver;

	public Utilities(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void scrollToElement(String text) {
		// scroll iOS
		HashMap<String, Object> scrollObject = new HashMap<>();
		scrollObject.put("direction", "down");
		scrollObject.put("text", "INGRESAR TEXTO");
		driver.executeScript("mobile:scroll", scrollObject);

		// scroll android
		driver.findElement(MobileBy
				.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

	}

}
