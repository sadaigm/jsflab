package com.sa.tcm.dao;

import java.util.List;

import com.sa.tcm.entity.Runner;

public interface RunnerDAO {
	 	public List<Runner> getAllRunnerIDs();
	    public Runner getRunnerID(Integer id);
	    public boolean addRunnerID(Runner runner);
	    public boolean removeRunnerID(Runner runner);
	    public boolean removeAllRunnerIDs();
}
