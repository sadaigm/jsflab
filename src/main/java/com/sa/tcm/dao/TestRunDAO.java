package com.sa.tcm.dao;

import java.util.List;

import com.sa.tcm.entity.Runner;
import com.sa.tcm.entity.Testrun;

public interface TestRunDAO {
	 	public List<Testrun> getAllTestRunnerIDs();
	    public Runner getTestRunnerID(Integer id);
	    public boolean addTestRunnerID(Testrun testrun);
	    public boolean removeTestRunnerID(Testrun testrun);
	    public boolean removeAllTestRunnerIDs();
}
