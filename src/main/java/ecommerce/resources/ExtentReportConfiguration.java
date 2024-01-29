package ecommerce.resources;


import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportConfiguration {

	    
//	public static  ExtentReports configuration() {
////		File newFile =new File(System.getProperty("user.dir")+"//reports//index.html");
//		String path = System.getProperty("user.dir"+"//reports//index.html");
//		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
//		reporter.config().setReportName("Automation Results");
//		reporter.config().setDocumentTitle("Test Report");
//		ExtentReports extentReports=new ExtentReports();
//		extentReports.attachReporter(reporter);
//		extentReports.setSystemInfo("Tester", "Aparna");
//		return extentReports;
////		ExtentReports extent = new ExtentReports();
////		extent.attachReporter(reporter);
////		extent.setSystemInfo("Tester", "Aparna");
////		return extent;
//		}
	   private static ExtentReports extentReports;

	    public static ExtentReports getExtentReport() {
	        if (extentReports == null) {
	            extentReports = createExtentReport();
	        }
	        return extentReports;
	    }

	    private static ExtentReports createExtentReport() {
			String path = System.getProperty("user.dir")+"//reports//index.html";
	        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
	        sparkReporter.config().setDocumentTitle("Automation Test Results");
	        sparkReporter.config().setReportName("Selenium Test Report");
//	        sparkReporter.config().setTheme(Theme.DARK);

	        extentReports = new ExtentReports();
	        extentReports.attachReporter(sparkReporter);

	        return extentReports;
	    }
	}

