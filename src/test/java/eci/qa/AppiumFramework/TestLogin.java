package eci.qa.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eci.qa.pageObjects.HomePage;
import eci.qa.pageObjects.InitPage;
import eci.qa.pageObjects.LoginPage;
import eci.qa.pageObjects.ServicesPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class TestLogin extends Base {

	@BeforeTest
	public void killAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Thread.sleep(3000);
	}

	@AfterTest
	public void killProcess() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("killall node");
		Runtime.getRuntime().exec("pkill adb");
		Runtime.getRuntime().exec("pkill WebDriver");
		Runtime.getRuntime().exec("pkill qemu-syst");
	}

	@Test
	public void loginCorrecto() throws IOException, InterruptedException {

		System.out.println(System.getProperty("user.dir"));

		service = startAppiumServer();

		AppiumDriver<MobileElement> driver = capabilities("ECIAPP");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		InitPage init = new InitPage(driver);

//		HomePage home = new HomePage(driver);
//
//		ServicesPage servicep = new ServicesPage(driver);
//
//		LoginPage login = new LoginPage(driver);

		init.clickBtnAcceptCookies();

		init.clickBtnPermNotificaciones();

//		home.clickBtnServicios();
//
//		servicep.clickBtnCompraManosLibres();
//
//		login.sendDataInputEmail("m.garcia.rebollo@accenture.com");
//
//		login.sendDataInputContrasena("Accenture");
//
//		login.clickBtnIniciarSesion();
//
//		home.existBtnServicios();

		driver.closeApp();

		driver.quit();

		service.stop();

	}

}
