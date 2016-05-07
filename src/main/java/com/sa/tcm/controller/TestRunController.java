package com.sa.tcm.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sa.tcm.dao.TestRunDAOImpl;
import com.sa.tcm.entity.Testrun;
import com.sa.tcm.utils.JsfUtil;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "testRunController")
@ViewScoped
public class TestRunController {
	
	private int selectedItemIndex;
	
	@ManagedProperty("#{TestRunDAOImpl}")
	 TestRunDAOImpl testRunimpl ;
	
	public void setTestRunimpl(TestRunDAOImpl testRunimpl) {
		this.testRunimpl = testRunimpl;
	}
	@ManagedProperty("#{UtilMethod}")
	UtilMethod utilMethod;
	
	public void setUtilMethod(UtilMethod utilMethod) {
		this.utilMethod = utilMethod;
	}
	private Testrun current;
	 public Testrun getSelected() {
	        if (current == null) {
	            current = new Testrun();
	            selectedItemIndex = -1;    
	        }
	        return current;
	    }
	 public String prepareCreate() {
	        current = new Testrun();
	        selectedItemIndex = -1;
	        return "ViewExecution.xhtml";
	    }
	
	 public String AddNewMod(){
		 try {
	            current.setTestrunID(0);
	            current.setCreatedDt(utilMethod.getCurrentTimeStamp());
	            testRunimpl.addTestRunnerID(current);
	            JsfUtil.addSuccessMessage("Test Run add Successfully");
	            return prepareCreate();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
	            return null;
	        } 
	 }
	

}
