package com.sa.tcm.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 * The persistent class for the testcases database table.
 * 
 */
@Entity
@Table(name="testcases")
@NamedQuery(name="Testcase.findAll", query="SELECT t FROM Testcase t order by t.testcaseIdpk desc")
public class Testcase implements Serializable {
	private static final long serialVersionUID = 1L;
	   
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name="testcase_idpk", unique=true, nullable=false)
	private Integer testcaseIdpk;
	@Column(length=45)
	private String addtitional_Attrb1;

	@Column(length=45)
	private String addtitional_Attrb2;

	@Column(length=45)
	private String addtitional_Attrb3;

	@Column(length=45)
	private String addtitional_Attrb4;

	@Column(length=45)
	private String addtitional_Attrb5;

	@Column(length=45)
	private String addtitional_Attrb6;

	@Column(length=4000)
	private String comments;

	@Column(length=45)
	private String component;
	 
	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_Date;

	@Lob
	private String dependent_test_cases;

	@Column(length=4000)
	private String expected_result;

	@Basic(optional = false)
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_Updated_dt;

	@Column(length=50)
	private String level;

	@Column(length=45)
	private String model;

	@Lob
	private String module;

	@Column(length=2000)
	private String reference;

	@Column(length=2550)
	private String scenario;

	@Column(length=45)
	private String scenario_IDPK;

	@Lob
	private String scenarioID;

	@Column(length=12)
	private String status;

	@Column(length=4000)
	private String test_Case_Description;

	@Column(length=100)
	private String test_Case_Flow;

	@Column(length=250)
	private String test_Case_ID;

	@Column(length=4000)
	private String test_data;

	@Column(length=255)
	private String tester;

	@Column(length=45)
	private String testingType;

	@Lob
	private String title;

	public Testcase() {
	}
	public Integer getTestcaseIdpk() {
		return testcaseIdpk;
	}
	public void setTestcaseIdpk(Integer testcaseIdpk) {
		this.testcaseIdpk = testcaseIdpk;
	}	

	public String getAddtitional_Attrb1() {
		return this.addtitional_Attrb1;
	}

	public void setAddtitional_Attrb1(String addtitional_Attrb1) {
		this.addtitional_Attrb1 = addtitional_Attrb1;
	}

	public String getAddtitional_Attrb2() {
		return this.addtitional_Attrb2;
	}

	public void setAddtitional_Attrb2(String addtitional_Attrb2) {
		this.addtitional_Attrb2 = addtitional_Attrb2;
	}

	public String getAddtitional_Attrb3() {
		return this.addtitional_Attrb3;
	}

	public void setAddtitional_Attrb3(String addtitional_Attrb3) {
		this.addtitional_Attrb3 = addtitional_Attrb3;
	}

	public String getAddtitional_Attrb4() {
		return this.addtitional_Attrb4;
	}

	public void setAddtitional_Attrb4(String addtitional_Attrb4) {
		this.addtitional_Attrb4 = addtitional_Attrb4;
	}

	public String getAddtitional_Attrb5() {
		return this.addtitional_Attrb5;
	}

	public void setAddtitional_Attrb5(String addtitional_Attrb5) {
		this.addtitional_Attrb5 = addtitional_Attrb5;
	}

	public String getAddtitional_Attrb6() {
		return this.addtitional_Attrb6;
	}

	public void setAddtitional_Attrb6(String addtitional_Attrb6) {
		this.addtitional_Attrb6 = addtitional_Attrb6;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getComponent() {
		return this.component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public Date getCreated_Date() {
		return this.created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public String getDependent_test_cases() {
		return this.dependent_test_cases;
	}

	public void setDependent_test_cases(String dependent_test_cases) {
		this.dependent_test_cases = dependent_test_cases;
	}

	public String getExpected_result() {
		return this.expected_result;
	}

	public void setExpected_result(String expected_result) {
		this.expected_result = expected_result;
	}

	public Date getLast_Updated_dt() {
		return this.last_Updated_dt;
	}

	public void setLast_Updated_dt(Date last_Updated_dt) {
		this.last_Updated_dt = last_Updated_dt;
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getScenario() {
		return this.scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public String getScenario_IDPK() {
		return this.scenario_IDPK;
	}

	public void setScenario_IDPK(String scenario_IDPK) {
		this.scenario_IDPK = scenario_IDPK;
	}

	public String getScenarioID() {
		return this.scenarioID;
	}

	public void setScenarioID(String scenarioID) {
		this.scenarioID = scenarioID;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTest_Case_Description() {
		return this.test_Case_Description;
	}

	public void setTest_Case_Description(String test_Case_Description) {
		this.test_Case_Description = test_Case_Description;
	}

	public String getTest_Case_Flow() {
		return this.test_Case_Flow;
	}

	public void setTest_Case_Flow(String test_Case_Flow) {
		this.test_Case_Flow = test_Case_Flow;
	}

	public String getTest_Case_ID() {
		return this.test_Case_ID;
	}

	public void setTest_Case_ID(String test_Case_ID) {
		this.test_Case_ID = test_Case_ID;
	}

	public String getTest_data() {
		return this.test_data;
	}

	public void setTest_data(String test_data) {
		this.test_data = test_data;
	}

	public String getTester() {
		return this.tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getTestingType() {
		return this.testingType;
	}

	public void setTestingType(String testingType) {
		this.testingType = testingType;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}