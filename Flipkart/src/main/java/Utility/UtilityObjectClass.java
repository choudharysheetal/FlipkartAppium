package Utility;

import io.appium.java_client.android.AndroidDriver;
/**
 * This class contains getter and setters of instances
 * @author
 *
 */
public class UtilityObjectClass {
	private static ThreadLocal<AndroidDriver> driver=new ThreadLocal<>();
	private static ThreadLocal<JavaUtility> javaUtility=new ThreadLocal<>();
    private static ThreadLocal<AndroidDriverUtility> androidDriverUtility=new ThreadLocal<>();
	public static JavaUtility getJavaUtility() {
		return javaUtility.get();
	}

	public static void setJavaUtility(JavaUtility actjavaUtility) {
		javaUtility.set(actjavaUtility);
	}

	public static  AndroidDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(AndroidDriver actualdriver) {
		driver.set(actualdriver);
	}
	
	public static AndroidDriverUtility getAndroidDriverUtility() {
		return androidDriverUtility.get();
	}

	public static void setAndroidDriverUtility(AndroidDriverUtility actAndroidDriverUtility) {
		androidDriverUtility.set(actAndroidDriverUtility);
	}
	
}
