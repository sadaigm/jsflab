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

import com.sa.tcm.entity.Testcase;
import com.sa.tcm.utils.UtilMethod;
@ManagedBean(name = "TestcaseDAOImpl")
@ApplicationScoped
public class TestcaseDAOImpl  implements Serializable,TestcaseDAO {
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

	public List<Testcase> getAllTestcaseIDs() {
	
		today = utilMethod.getCurrentDate();
		Query query = entitymanager.createNamedQuery("Testcase.findAll");
		
		@SuppressWarnings("unchecked")
		List<Testcase> testcases = query.getResultList();
		
		
		/*for( Testcase e:testcases ){
	         System.out.print(" ID :" + e.getTestCaseId());
	         System.out.println("\t  Status :" + e.getStatus());
	      }*/
		
		
		return testcases;
		
	}

	public List<Testcase> getTodayExecution() {
		
		//Query query = entitymanager.createQuery("SELECT r FROM Testcase r WHERE  to_char(r.executeddate,'DD-Mon-YY') = :executeddate");
		Query query = entitymanager.createNamedQuery("Testcase.findLikeExecuteddate");
		query.setParameter("executeddate",utilMethod.getCurrentDate());
		System.out.println(utilMethod.getCurrentDate());
		System.out.println(query.toString());
		@SuppressWarnings("unchecked")
		List<Testcase> testcases = query.getResultList();
		return testcases;
		
	}
	public Testcase getTestcaseID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addTestcaseID(Testcase testcase) {
		 try {
	            entitymanager.getTransaction().begin();
	            entitymanager.persist(testcase);
	            entitymanager.getTransaction().commit();
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
		
	}
	
	public boolean updateTestcaseID(Testcase testcase) {
		 try {
	            entitymanager.getTransaction().begin();
	            entitymanager.merge(testcase);
	            entitymanager.getTransaction().commit();
	            return true;
	        }catch (Exception e){
	            e.printStackTrace();
	            return false;
	        }
		
	}

	public boolean removeTestcaseID(Testcase testcase) {
		entitymanager.getTransaction().begin();
		
		entitymanager.remove(testcase);
		entitymanager.getTransaction().commit();
		return false;
	}

	@Override
	public boolean removeAllTestcaseIDs() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
