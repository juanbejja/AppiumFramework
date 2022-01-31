package eci.qa.pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import eci.qa.AppiumFramework.Constantes;
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

	@iOSXCUITFindBy(accessibility = "PERMITIR NOTIFICACIONES")
	private MobileElement btnPermitirNotificaciones;

	public void clickBtnAcceptCookies() {
		btnAcceptCookies.click();
	}

	public void clickBtnPermNotificaciones() throws IOException {

		FileInputStream fis = new FileInputStream(Constantes.GLOBAL_PROPERTIES);
		Properties prop = new Properties();
		prop.load(fis);

		String SO = (String) prop.get("SO");

		if (SO.equals("iOS")) {

			btnPermitirNotificaciones.click();

		}
	}
}
