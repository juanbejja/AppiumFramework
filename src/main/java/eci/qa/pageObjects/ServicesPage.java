package eci.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ServicesPage {

	public ServicesPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "com.elcorteingles.app.pre:id/toolbar_title")
	public WebElement titleToolBar;

	@iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@name=\"Compra manos libres. Compra en la tienda sin bolsas. \"]")
	@AndroidFindBy(id = "com.elcorteingles.app.pre:id/digital_cart_button")
	public WebElement btnCompraManosLibres;

	public void clickBtnCompraManosLibres() {
		btnCompraManosLibres.click();
	}

}
