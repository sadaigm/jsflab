package com.sa.tcm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sa.tcm.entity.Runner;
import com.sa.tcm.entity.Testrun;
import com.sa.tcm.entity.Teststatus;
import com.sa.tcm.entity.User;

@ManagedBean(name = "TestRunDAOImpl")
@ApplicationScoped
public class TestRunDAOImpl implements TestRunDAO {

	private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SmartTCMPU");
	EntityManager entitymanager = emfactory.createEntityManager();
	private Map<String, String> runNames = new HashMap<String, String>();
	private Map<String, String> testStatus = new HashMap<String, String>();
	private Map<String, String> executors = new HashMap<String, String>();
	
	public Map<String, String> getExecutors() {
		return executors;
	}

	public void setExecutors(Map<String, String> executors) {
		this.executors = executors;
	}

	public Map<String, String> getTestStatus() {
		return testStatus;
	}

	public void setTestStatus(Map<String, String> testStatus) {
		this.testStatus = testStatus;
	}

	public Map<String, String> getRunNames() {
		return runNames;
	}

	public void setRunNames(Map<String, String> runNames) {
		this.runNames = runNames;
	}

	@Override
	public List<Testrun> getAllTestRunnerIDs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Runner getTestRunnerID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTestRunnerID(Testrun testrun) {
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(testrun);
			entitymanager.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Testrun> getTestRunNames() {

		Query query = entitymanager.createNamedQuery("Testrun.findAll");
		@SuppressWarnings("unchecked")
		List<Testrun> runNames = query.getResultList();
		return runNames;

	}

	@Override
	public boolean removeTestRunnerID(Testrun testrun) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAllTestRunnerIDs() {
		// TODO Auto-generated method stub
		return false;
	}

	public void getRunNameMap() {
		List<Testrun> names = getTestRunNames();
		for (Testrun name : names) {
			runNames.put(name.getName(), name.getName());
     }
	}
	
	public void getTestStatusMap() {
		List<Teststatus> names = getTestStatusNames();
		for (Teststatus name : names) {
			testStatus.put(name.getStatusName(), name.getStatusName());
     }
	}
	public List<Teststatus> getTestStatusNames() {

		Query query = entitymanager.createNamedQuery("Teststatus.findAll");
		@SuppressWarnings("unchecked")
		List<Teststatus> statusNames = query.getResultList();
		return statusNames;

	}
	public List<User> getUserList() {

		Query query = entitymanager.createNamedQuery("User.findAll");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		return users;

	}
	
	
	public void getUserMap() {
		List<User> names = getUserList();
		for (User name : names) {
			executors.put(name.getUname().toUpperCase(), name.getUname().toUpperCase());
     }
	}
	
}
