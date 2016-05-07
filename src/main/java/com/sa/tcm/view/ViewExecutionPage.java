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

import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;

import com.sa.tcm.controller.RunnerController;
import com.sa.tcm.dao.RunnerDAOImpl;
import com.sa.tcm.entity.Runner;
import com.sa.tcm.model.RunnerDataModel;

@ManagedBean(name="ExecView")
@ViewScoped
public class ViewExecutionPage implements Serializable{
	Date todatdt;
	public Date getTodatdt() {
		return todatdt;
	}

	public void setTodatdt(Date todatdt) {
		this.todatdt = todatdt;
	}

	
	@ManagedProperty("#{runnerController}")
	RunnerController startRunner;
	
	public void setStartRunner(RunnerController startRunner) {
		this.startRunner = startRunner;
	}

	
	private List<Runner> runners;
	private RunnerDataModel runnerModel;
	public RunnerDataModel getRunnerModel() {
		return runnerModel;
	}

	private Runner selectedRunner;
	public Runner getSelectedRunner() {
		return selectedRunner;
	}

	public void setSelectedRunner(Runner selectedRunner) {
		this.selectedRunner = selectedRunner;
	}

	public List<Runner> getRunners() {
		return runners;
	}

	public void setRunners(List<Runner> runners) {
		this.runners = runners;
	}

	@ManagedProperty("#{RunnerDAOImpl}")
    private  RunnerDAOImpl runimpl ;
     
    public void setRunimpl(RunnerDAOImpl runimpl) {
		this.runimpl = runimpl;
	}

	@PostConstruct
    public void init() {
		loadTodayExecution();
		//runners = runimpl.getAllRunnerIDs();
    }
	public void loadEventTodayExecution(CloseEvent event)
	{
		loadTodayExecution();
	}
	public void loadTodayExecution()
	{
		runnerModel = new RunnerDataModel(runimpl.getTodayExecution());
		setTodatdt(runimpl.getToday());
	}
	
	public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Runner Selected", ((Runner) event.getObject()).getTestCaseId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void onClickSave() {
	       
        System.out.println(getSelectedRunner().getRunnerId()+" is clicked");
        System.out.println(getSelectedRunner().getStatus()+" is clicked");
       startRunner.updateExecLog(getSelectedRunner());
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
