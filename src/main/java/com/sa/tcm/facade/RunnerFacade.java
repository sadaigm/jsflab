/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sa.tcm.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sa.tcm.entity.Runner;

/**
 *
 * @author sadaiyandi
 */
@Stateless
public class RunnerFacade extends AbstractFacade<Runner> {
    @PersistenceContext(unitName = "SmartTCMPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RunnerFacade() {
        super(Runner.class);
    }
    
}
