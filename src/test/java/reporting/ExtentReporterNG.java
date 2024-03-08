package reporting;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
static ExtentReports extent;
	
	/*
	 *Stores extent report in report.hmtl
	 *returns extent report object 
	 */
	public static ExtentReports getReporterObject() {
		String path=System.getProperty("user.dir")+File.separator+"reports"+File.separator+"report.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Report Name");
		reporter.config().setDocumentTitle("Document Title");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}
}
