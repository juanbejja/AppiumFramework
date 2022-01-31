package eci.qa.pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage {

	public HomePage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(accessibility = "Servicios +")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/services")
	public MobileElement btnServicios;

	public void clickBtnServicios() {
		btnServicios.click();
	}

	public boolean existBtnServicios() throws InterruptedException {
		Thread.sleep(4000);
		return btnServicios.isDisplayed();
	}

}
