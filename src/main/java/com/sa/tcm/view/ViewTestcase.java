package com.sa.tcm.view;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import com.sa.tcm.controller.TestcaseController;
import com.sa.tcm.dao.TestcaseDAOImpl;
import com.sa.tcm.entity.Testcase;
import com.sa.tcm.model.TestcaseDataModel;
import com.sa.tcm.utils.JsfUtil;

@ManagedBean(name="testcaseView")
@ViewScoped
public class ViewTestcase implements Serializable{
	
	@ManagedProperty("#{testcaseController}")
	TestcaseController startTestcase;
	Date todatdt;
	public Date getTodatdt() {
		return todatdt;
	}

	public void setTodatdt(Date todatdt) {
		this.todatdt = todatdt;
	}

	public void setStartTestcase(TestcaseController startTestcase) {
		this.startTestcase = startTestcase;
	}

	private List<Testcase> testcases;
	private TestcaseDataModel testcaseModel;
	public TestcaseDataModel getTestcaseModel() {
		return testcaseModel;
	}

	private Testcase EditselectedTestcase;
	public Testcase getEditselectedTestcase() {
		return EditselectedTestcase;
	}

	public void setEditselectedTestcase(Testcase editselectedTestcase) {
		EditselectedTestcase = editselectedTestcase;
	}

	private Testcase selectedTestcase;
	public Testcase getSelectedTestcase() {
		return selectedTestcase;
	}
	private List<Testcase> selectedTestcases;
	public List<Testcase> getSelectedTestcases() {
		return selectedTestcases;
	}

	public void setSelectedTestcases(List<Testcase> selectedTestcases) {
		this.selectedTestcases = selectedTestcases;
	}

	public void setSelectedTestcase(Testcase selectedTestcase) {
		this.selectedTestcase = selectedTestcase;
	}

	public List<Testcase> getTestcases() {
		return testcases;
	}

	public void setTestcases(List<Testcase> testcases) {
		this.testcases = testcases;
	}

	@ManagedProperty("#{TestcaseDAOImpl}")
    private  TestcaseDAOImpl caseimpl ;
     
    public void setCaseimpl(TestcaseDAOImpl caseimpl) {
		this.caseimpl = caseimpl;
	}

	@PostConstruct
    public void init() {
		
		testcaseModel = new TestcaseDataModel(caseimpl.getAllTestcaseIDs());
		setTodatdt(caseimpl.getToday());
		//testcases = caseimpl.getAllTestcaseIDs();
    }
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Testcase Selected", ((Testcase) event.getObject()).getTest_Case_ID());
        FacesContext.getCurrentInstance().addMessage(null, msg);
       
    }
	
	public void onClickSave() {
       
        System.out.println(getEditselectedTestcase().getTestcaseIdpk()+" is clicked");
        System.out.println(getEditselectedTestcase().getStatus()+" is clicked");
       startTestcase.updateTestcase(getEditselectedTestcase());
       FacesMessage msg = new FacesMessage("Saved. Testcase # "+ getEditselectedTestcase().getTestcaseIdpk());
       FacesContext.getCurrentInstance().addMessage(null, msg);
       
      
    }
	public Date getCurrentTimeStamp() throws ParseException
    {
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",Locale.ENGLISH);
     Date now = new Date();
     String strDate = formatter.format(now);
     Date date = null;
     formatter.setTimeZone(TimeZone.getTimeZone("IST"));
   
         
      date  = formatter.parse(strDate);
    
    return date;
    }
}
