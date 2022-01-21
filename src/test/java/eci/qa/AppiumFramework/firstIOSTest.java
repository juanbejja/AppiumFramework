package eci.qa.AppiumFramework;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import eci.qa.pageObjects.InitPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class firstIOSTest extends Base {

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
	public void validarTituloServices() throws IOException, InterruptedException {

		System.out.println(System.getProperty("user.dir"));

		service = startAppiumServer();

		AppiumDriver<MobileElement> driver = capabilities("ECIAPP");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		InitPage init = new InitPage(driver);

		init.clickBtnAcceptCookies();

		// steps

		service.stop();

	}

}
