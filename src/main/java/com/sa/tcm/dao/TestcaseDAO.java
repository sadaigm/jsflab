/**
 * 
 */
package com.sa.tcm.dao;

import java.util.List;

import com.sa.tcm.entity.Testcase;

/**
 * @author sadaiyandi
 *
 */
public interface TestcaseDAO {
	public List<Testcase> getAllTestcaseIDs();
    public Testcase getTestcaseID(Integer id);
    public boolean addTestcaseID(Testcase testcase);
    public boolean removeTestcaseID(Testcase testcase);
    public boolean removeAllTestcaseIDs();
}
