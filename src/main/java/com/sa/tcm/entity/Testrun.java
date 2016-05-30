package com.sa.tcm.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the testrun database table.
 * 
 */
@Entity
@Table(name="testrun")
@NamedQuery(name="Testrun.findAll", query="SELECT t FROM Testrun t")
public class Testrun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "testrunID", nullable = false)
	private int testrunID;

	private String buildNo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDt;

	private String moduleName;

	private String name;

	private String projectName;

	public Testrun() {
	}

	public int getTestrunID() {
		return this.testrunID;
	}

	public void setTestrunID(int testrunID) {
		this.testrunID = testrunID;
	}

	public String getBuildNo() {
		return this.buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	public Date getCreatedDt() {
		return this.createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

}