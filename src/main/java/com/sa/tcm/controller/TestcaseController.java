package com.sa.tcm.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sa.tcm.dao.TestcaseDAOImpl;
import com.sa.tcm.entity.Testcase;
import com.sa.tcm.entity.Testrun;
import com.sa.tcm.utils.JsfUtil;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "testcaseController")
@ViewScoped
public class TestcaseController {
	
	private int selectedItemIndex;
	
	@ManagedProperty("#{TestcaseDAOImpl}")
	 TestcaseDAOImpl caseimpl ;
	
	
	@ManagedProperty("#{UtilMethod}")
	UtilMethod utilMethod;
	
	public void setUtilMethod(UtilMethod utilMethod) {
		this.utilMethod = utilMethod;
	}
	private Testcase current;
	 public Testcase getSelected() {
	        if (current == null) {
	            current = new Testcase();
	            selectedItemIndex = -1;    
	        }
	        return current;
	    }

	 public String prepareCreate() {
	        current = new Testcase();
	        selectedItemIndex = -1;
	        return "Add_TestCaseDetails.xhtml";
	    }
	 public String ViewCreated() {
	        return "ViewTestCases.xhtml";
	    }
	 public String ViewTestCases() {
	        return "ViewTestCases.xhtml";
	    }
	
	 public String AddNewTestcase(){
		 try {
	            current.setTestcaseIdpk(0);
	            current.setCreated_Date(utilMethod.getCurrentTimeStamp());
	            current.setLast_Updated_dt(utilMethod.getCurrentTimeStamp());
	            caseimpl.addTestcaseID(current);
	            JsfUtil.addSuccessMessage("Execution Task add Successfully");
	            return ViewCreated();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
	            return null;
	        } 
	 }
	 
	 public String updateTestcase(Testcase testcase){
		 try {
			 testcase.setLast_Updated_dt(utilMethod.getCurrentTimeStamp());
	            caseimpl.updateTestcaseID(testcase);
	            JsfUtil.addSuccessMessage("Execution Task add Successfully");
	            return ViewCreated();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
	            return null;
	        } 
	 }
	
	public void setCaseimpl(TestcaseDAOImpl caseimpl) {
		this.caseimpl = caseimpl;
	}
	public static List <Testcase> TestcaseList;

	public List<Testcase> getTestcaseList() {
		return TestcaseList;
	}

	public void setTestcaseList(List<Testcase> testcaseList) {
		TestcaseList = testcaseList;
	}

	public String DisplayTestTestcase()
	{
		TestcaseList = caseimpl.getAllTestcaseIDs();
		return "/ui/Testcase";
	}
	

}
