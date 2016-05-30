package com.sa.tcm.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.sa.tcm.bean.SessionBean;
import com.sa.tcm.dao.RunnerDAOImpl;
import com.sa.tcm.dao.TestRunDAOImpl;
import com.sa.tcm.dao.TestcaseDAOImpl;
import com.sa.tcm.entity.Runner;
import com.sa.tcm.utils.JsfUtil;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "runnerController")
@ViewScoped
public class RunnerController {
String ModuleName,Iteration,runIDfilter;
	
	public String getRunIDfilter() {
	return runIDfilter;
}

public void setRunIDfilter(String runIDfilter) {
	this.runIDfilter = runIDfilter;
}

	public String getModuleName() {
		return ModuleName;
	}

	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}

	public String getIteration() {
		return Iteration;
	}

	public void setIteration(String iteration) {
		Iteration = iteration;
	}
	
	private int selectedItemIndex;
	
Boolean isDateFilter ;
	
	public Boolean getIsDateFilter() {
		return isDateFilter;
	}

	public void setIsDateFilter(Boolean isDateFilter) {
		this.isDateFilter = isDateFilter;
	}


	String filterName;
	public String getFilterName() {
		return filterName;
	}

	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	@ManagedProperty("#{TestcaseDAOImpl}")
	TestcaseDAOImpl testcaseImpl;
	
	public void setTestcaseImpl(TestcaseDAOImpl testcaseImpl) {
		this.testcaseImpl = testcaseImpl;
	}

	@ManagedProperty("#{RunnerDAOImpl}")
	 RunnerDAOImpl runimpl ;
	
	@ManagedProperty("#{TestRunDAOImpl}")
	TestRunDAOImpl testRunImpl;
	
	public void setTestRunImpl(TestRunDAOImpl testRunImpl) {
		this.testRunImpl = testRunImpl;
	}

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
	        fetchdropList();
	        return "Add_ExecutionDetails.xhtml";
	    }
	 public String ViewCreated() {
		this.setFilterName("DATE");
		 SessionBean.getSession().setAttribute("filter", "DATE");
		System.out.println(this.getFilterName());
	        return "ViewExecution.xhtml";
	    }
	 public String ViewFiltered() {
		this.setFilterName("MOD");
		System.out.println(this.getFilterName()+runIDfilter+Iteration+ModuleName);
		
		 SessionBean.getSession().setAttribute("filter", "MOD");
		 if(ModuleName.isEmpty() && Iteration.isEmpty()&& runIDfilter.isEmpty())
		 {
			 ViewTestRunner();
		 }
		 else
		 {
		 SessionBean.getSession().setAttribute("module", ModuleName);
		 SessionBean.getSession().setAttribute("iteration", Iteration);
		 SessionBean.getSession().setAttribute("runidfilter", runIDfilter);
	        return "ViewExecution.xhtml";
		 }
		 return  ViewTestRunner();
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
	           // current.setExecuteddate(utilMethod.getCurrentTimeStamp());
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
	
	
	public void fetchdropList()
	{
		testRunImpl.getRunNameMap();
		testcaseImpl.getTestCaseNameMap();
		testRunImpl.getTestStatusMap();
		testRunImpl.getUserMap();
	}

}
