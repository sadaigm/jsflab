package com.sa.tcm.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sa.tcm.entity.Runner;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "RunnerDAOImpl")
@ApplicationScoped
public class RunnerDAOImpl  implements Serializable,RunnerDAO {
	/**
	 * 
	 */
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
