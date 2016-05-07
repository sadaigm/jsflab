package com.sa.tcm.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sa.tcm.dao.RunnerDAOImpl;
import com.sa.tcm.entity.Runner;
import com.sa.tcm.entity.Testrun;
import com.sa.tcm.utils.JsfUtil;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "runnerController")
@ViewScoped
public class RunnerController {
	
	private int selectedItemIndex;
	
	@ManagedProperty("#{RunnerDAOImpl}")
	 RunnerDAOImpl runimpl ;
	
	
	@ManagedProperty("#{UtilMethod}")
	UtilMethod utilMethod;
	
	public void setUtilMethod(UtilMethod utilMethod) {
		this.utilMethod = utilMethod;
	}
	private Runner current;
	 public Runner getSelected() {
	        if (current == null) {
	            current = new Runner();
	            selectedItemIndex = -1;    
	        }
	        return current;
	    }

	 public String prepareCreate() {
	        current = new Runner();
	        selectedItemIndex = -1;
	        return "Add_ExecutionDetails.xhtml";
	    }
	 public String ViewCreated() {
	        return "ViewExecution.xhtml";
	    }
	 public String ViewTestRunner() {
	        return "TestRunner2.xhtml";
	    }
	 public String AddTestModule() {
	        return "AddTestRunner2.xhtml";
	    }
	
	 public String AddNewExecLog(){
		 try {
	            current.setRunnerId(0);
	            current.setExecuteddate(utilMethod.getCurrentTimeStamp());
	            current.setLastupdatedate(utilMethod.getCurrentTimeStamp());
	            runimpl.addRunnerID(current);
	            JsfUtil.addSuccessMessage("Execution Task add Successfully");
	            return ViewCreated();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
	            return null;
	        } 
	 }
	 
	 public String updateExecLog(Runner runner){
		 try {
			 runner.setLastupdatedate(utilMethod.getCurrentTimeStamp());
	            runimpl.updateRunnerID(runner);
	            JsfUtil.addSuccessMessage("Execution Task add Successfully");
	            return ViewTestRunner();
	        } catch (Exception e) {
	            JsfUtil.addErrorMessage(e, "PersistenceErrorOccured");
	            return null;
	        } 
	 }
	
	public void setRunimpl(RunnerDAOImpl runimpl) {
		this.runimpl = runimpl;
	}
	public static List <Runner> RunnerList;

	public List<Runner> getRunnerList() {
		return RunnerList;
	}

	public void setRunnerList(List<Runner> runnerList) {
		RunnerList = runnerList;
	}

	public String DisplayTestRunner()
	{
		RunnerList = runimpl.getAllRunnerIDs();
		return "/ui/TestRunner";
	}
	

}
