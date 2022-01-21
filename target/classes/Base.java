package eci.qa.AppiumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {

	public static AppiumDriverLocalService service;
	public static AppiumDriver<MobileElement> driver;

	public AppiumDriverLocalService startAppiumServer() throws IOException {

		boolean flag = checkIfServerIsRunning(4723);

		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();

			service.start();

		}
		return service;

	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;

		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public static AppiumDriver<MobileElement> capabilities(String app) throws IOException, InterruptedException {

		String SO = System.getProperty("SO");

		switch (SO) {

		case "ANDROID":
			System.out.println("SO ANDROID");

			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/eci/qa/AppiumFramework/global.properties");
			Properties prop = new Properties();
			prop.load(fis);

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("avd", "emuladorECI");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emuladorECI");
			cap.setCapability(MobileCapabilityType.APP, prop.get(app));
//			cap.setCapability("isHeadless", true);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

			driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);

			return driver;

		case "iOS":
			System.out.println("SO IOS");
			DesiredCapabilities desiredCaps = new DesiredCapabilities();

			desiredCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
			desiredCaps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
			desiredCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
			desiredCaps.setCapability("wdaStartupRetries", "4");
			desiredCaps.setCapability("iosInstallPause", "8000");
			desiredCaps.setCapability("wdaStartupRetryInterval", "20000");
			String appios = "/Users/juan.pablo.bejarano/Desktop/elcorteinglesPRE.app";
			desiredCaps.setCapability(MobileCapabilityType.APP, appios);
			driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), desiredCaps);

			return driver;

		default:
			System.out.println("SISTEMA OPERATIVO INEXISTENTE");

			return null;

		}
	}

	public static void getScreenshot(String name) throws IOException {
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "/" + name + ".png"));
	}

}
