package com.sa.tcm.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sa.tcm.entity.Runner;
import com.sa.tcm.entity.Testrun;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "RunnerDAOImpl")
@ApplicationScoped
public class RunnerDAOImpl  implements Serializable,RunnerDAO {
	/**
	 * 
	 */
	
	String ModuleName,ItrName,runIDFilter;
	public String getRunIDFilter() {
		return runIDFilter;
	}

	public void setRunIDFilter(String runIDFilter) {
		this.runIDFilter = runIDFilter;
	}

	public String getModuleName() {
		return ModuleName;
	}

	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}

	public String getItrName() {
		return ItrName;
	}

	public void setItrName(String itrName) {
		ItrName = itrName;
	}

	private  Date today = null;
	public  Date getToday() {
		return today;
	}

	public  void setToday(Date todaydate) {
		today = todaydate;
	}

	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SmartTCMPU");
    EntityManager entitymanager =  emfactory.createEntityManager();
	 
	@ManagedProperty("#{UtilMethod}")
	UtilMethod utilMethod;
    
    
	public void setUtilMethod(UtilMethod utilMethod) {
		this.utilMethod = utilMethod;
	}

	public List<Runner> getAllRunnerIDs() {
	
		today = utilMethod.getCurrentDate();
		Query query = entitymanager.createNamedQuery("Runner.findAll");
		
		@SuppressWarnings("unchecked")
		List<Runner> runners = query.getResultList();
		
		
		/*for( Runner e:runners ){
	         System.out.print(" ID :" + e.getTestCaseId());
	         System.out.println("\t  Status :" + e.getStatus());
	      }*/
		
		
		return runners;
		
	}

	public List<Runner> getTodayExecution() {
		
		//Query query = entitymanager.createQuery("SELECT r FROM Runner r WHERE  to_char(r.executeddate,'DD-Mon-YY') = :executeddate");
		Query query = entitymanager.createNamedQuery("Runner.findLikeExecuteddate");
		query.setParameter("executeddate",utilMethod.getCurrentDate());
		System.out.println(utilMethod.getCurrentDate());
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<Runner> runners = query.getResultList();
		return runners;
		
	}
public List<Runner> getModuleFilter() {
		
		//Query query = entitymanager.createQuery("SELECT r FROM Runner r WHERE  to_char(r.executeddate,'DD-Mon-YY') = :executeddate");
	boolean isCorrect = false;
	Query query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1 AND t.addtitional_Attrb1 = ?2) and r.runnerId =?3");
	if(ModuleName!="" && ItrName!="" && runIDFilter!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1 AND t.addtitional_Attrb1 = ?2) and r.runnerId =?3");
		query.setParameter("1",ModuleName);
		query.setParameter("2",ItrName);
		query.setParameter("3",Integer.parseInt(runIDFilter));
		isCorrect = true;
		 }
	else if(runIDFilter!="" && ItrName!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.addtitional_Attrb1 = ?2) and r.runnerId =?3");
		query.setParameter("3",Integer.parseInt(runIDFilter));
		query.setParameter("2",ItrName);
		isCorrect = true;
		 }
	else if(runIDFilter!="" && ModuleName!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1) and r.runnerId =?3");
		query.setParameter("1",ModuleName);
		query.setParameter("3",Integer.parseInt(runIDFilter));
		isCorrect = true;
		 }
	else if(ModuleName!="" && ItrName!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1 AND t.addtitional_Attrb1 = ?2)");
		query.setParameter("1",ModuleName);
		query.setParameter("2",ItrName);
		isCorrect = true;
		 }
	else if(ItrName!="")
		 {
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.addtitional_Attrb1 = ?2)");
		query.setParameter("2",ItrName);
		isCorrect = true;	  
		 }
	else if(ModuleName!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1)");
		query.setParameter("1",ModuleName);
		isCorrect = true;
	}
	else if(runIDFilter!="")
	{
		query = entitymanager.createQuery("select r from Runner r where r.runnerId =?3");
		query.setParameter("3",Integer.parseInt(runIDFilter));
		isCorrect = true;
	}
	
	
	if(isCorrect == true)
	{
	//query = entitymanager.createQuery("select r from Runner r where r.testCaseId IN (SELECT t.test_Case_ID FROM Testcase t WHERE t.module = ?1 AND t.addtitional_Attrb1 = ?2)");
		System.out.println(ModuleName+ItrName+runIDFilter);
		Set param = query.getParameters();
		Iterator<Object> itr =param.iterator();
		while (itr.hasNext()) {
			Object par=  itr.next();
			System.out.println(par);
		}
		
		System.out.println(utilMethod.getCurrentDate());
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<Runner> runners = query.getResultList();
		return runners;
	}
	return null;
		
	}
	public Runner getRunnerID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addRunnerID(Runner runner) {
		 try {
	            entitymanager.getTransaction().begin();
	            entitymanager.persist(runner);
	            entitymanager.getTransaction().commit();
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
		
	}
	
	public boolean updateRunnerID(Runner runner) {
		 try {
	            entitymanager.getTransaction().begin();
	            entitymanager.merge(runner);
	            entitymanager.getTransaction().commit();
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
		
	}

	public boolean removeRunnerID(Runner runner) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllRunnerIDs() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
