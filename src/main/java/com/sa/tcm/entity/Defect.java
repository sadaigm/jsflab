package com.sa.tcm.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the defect database table.
 * 
 */
@Entity
@Table(name="defect")
@NamedQuery(name="Defect.findAll", query="SELECT d FROM Defect d")
public class Defect implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String assigned_To;

	@Temporal(TemporalType.DATE)
	private Date closed_date;

	@Temporal(TemporalType.DATE)
	private Date created_Date;

	private String dev_Comments;

	private String fixed_Build_No;

	@Temporal(TemporalType.DATE)
	private Date fixed_Date;

	private int priority;

	private String QA_Comments;

	private String raised_Build_No;

	@Temporal(TemporalType.DATE)
	private Date reopen_date;

	private String severity;

	private String state;

	private String steps_to_Reproduce;

	private String test_case_Ref;

	private String title;

	private String work_Item_Type;

	public Defect() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAssigned_To() {
		return this.assigned_To;
	}

	public void setAssigned_To(String assigned_To) {
		this.assigned_To = assigned_To;
	}

	public Date getClosed_date() {
		return this.closed_date;
	}

	public void setClosed_date(Date closed_date) {
		this.closed_date = closed_date;
	}

	public Date getCreated_Date() {
		return this.created_Date;
	}

	public void setCreated_Date(Date created_Date) {
		this.created_Date = created_Date;
	}

	public String getDev_Comments() {
		return this.dev_Comments;
	}

	public void setDev_Comments(String dev_Comments) {
		this.dev_Comments = dev_Comments;
	}

	public String getFixed_Build_No() {
		return this.fixed_Build_No;
	}

	public void setFixed_Build_No(String fixed_Build_No) {
		this.fixed_Build_No = fixed_Build_No;
	}

	public Date getFixed_Date() {
		return this.fixed_Date;
	}

	public void setFixed_Date(Date fixed_Date) {
		this.fixed_Date = fixed_Date;
	}

	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getQA_Comments() {
		return this.QA_Comments;
	}

	public void setQA_Comments(String QA_Comments) {
		this.QA_Comments = QA_Comments;
	}

	public String getRaised_Build_No() {
		return this.raised_Build_No;
	}

	public void setRaised_Build_No(String raised_Build_No) {
		this.raised_Build_No = raised_Build_No;
	}

	public Date getReopen_date() {
		return this.reopen_date;
	}

	public void setReopen_date(Date reopen_date) {
		this.reopen_date = reopen_date;
	}

	public String getSeverity() {
		return this.severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getSteps_to_Reproduce() {
		return this.steps_to_Reproduce;
	}

	public void setSteps_to_Reproduce(String steps_to_Reproduce) {
		this.steps_to_Reproduce = steps_to_Reproduce;
	}

	public String getTest_case_Ref() {
		return this.test_case_Ref;
	}

	public void setTest_case_Ref(String test_case_Ref) {
		this.test_case_Ref = test_case_Ref;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWork_Item_Type() {
		return this.work_Item_Type;
	}

	public void setWork_Item_Type(String work_Item_Type) {
		this.work_Item_Type = work_Item_Type;
	}

}