package eci.qa.pageObjects;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class InitPage {

	public InitPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
	}

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmas que has leído y aceptado la información sobre las cookies.\"]")
	@AndroidFindBy(xpath = "(//android.widget.Button)[2]")
	private MobileElement btnAcceptCookies;

	public void clickBtnAcceptCookies() {
		btnAcceptCookies.click();
	}
}
