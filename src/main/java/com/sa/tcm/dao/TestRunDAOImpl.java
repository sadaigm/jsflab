package com.sa.tcm.dao;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sa.tcm.entity.Runner;
import com.sa.tcm.entity.Testrun;

@ManagedBean(name="TestRunDAOImpl")
@ApplicationScoped
public class TestRunDAOImpl implements TestRunDAO{

	private static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("SmartTCMPU");
    EntityManager entitymanager =  emfactory.createEntityManager();
	 
	
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
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }     
		
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

	

}
