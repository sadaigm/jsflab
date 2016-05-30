package com.sa.tcm.ui;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="navigatePage")
public class PageNavigation implements Serializable{
	
	String TESTCASE_URL="/faces/ui/testcases/ViewTestCases.xhtml", TEST_URL="tc/ViewTestCases.xhtml",TEST_RUNNER="/faces/ui/TestRunner2.xhtml",TEST_REPORT="/faces/chart2.xhtml",TEST_HOME="/faces/MyTemplateHome.xhtml";
	String TEST_SUMMARY_REPORT_CHART="/faces/TestSummaryReport_Chart.xhtml";
	
	public String getTEST_SUMMARY_REPORT_CHART() {
		return TEST_SUMMARY_REPORT_CHART;
	}

	public void setTEST_SUMMARY_REPORT_CHART(String tEST_SUMMARY_REPORT_CHART) {
		TEST_SUMMARY_REPORT_CHART = tEST_SUMMARY_REPORT_CHART;
	}

	public String getTESTCASE_URL() {
		return TESTCASE_URL;
	}

	public void setTESTCASE_URL(String tESTCASE_URL) {
		TESTCASE_URL = tESTCASE_URL;
	}

	public String getTEST_URL() {
		return TEST_URL;
	}

	public void setTEST_URL(String tEST_URL) {
		TEST_URL = tEST_URL;
	}

	public String getTEST_RUNNER() {
		return TEST_RUNNER;
	}

	public void setTEST_RUNNER(String tEST_RUNNER) {
		TEST_RUNNER = tEST_RUNNER;
	}

	public String getTEST_REPORT() {
		return TEST_REPORT;
	}

	public void setTEST_REPORT(String tEST_REPORT) {
		TEST_REPORT = tEST_REPORT;
	}

	public String getTEST_HOME() {
		return TEST_HOME;
	}

	public void setTEST_HOME(String tEST_HOME) {
		TEST_HOME = tEST_HOME;
	}

	public String navigateTestcases(){
		return "/tc/Testcases";
	}
	
	public String navigateToNewTestRun(){
		return "AddTestRunner2.xhtml";
	}
	
	public String navigateTestReport(){
		return "/Chart2";
	}
	
	public String navigateHomePage(){
		return "/MyTemplateHome";
	}
	
	
}
