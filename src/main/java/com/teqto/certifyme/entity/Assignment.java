package com.teqto.certifyme.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the assignments database table.
 * 
 */
@Entity
@Table(name="assignments")
@NamedQuery(name="Assignment.findAll", query="SELECT a FROM Assignment a")
public class Assignment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private byte active;

	@Temporal(TemporalType.DATE)
	@Column(name="actual_end_date")
	private Date actualEndDate;

	@Column(name="assignment_type")
	private String assignmentType;

	@Column(name="billability_terms")
	private String billabilityTerms;

	private int budget;

	@Column(name="completion_percent")
	private int completionPercent;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="created_by")
	private int createdBy;

	private String customer;

	@Column(name="customer_payment")
	private int customerPayment;

	private String customerid;

	@Lob
	private String description;

	private String domain;

	@Temporal(TemporalType.DATE)
	@Column(name="expected_end_date")
	private Date expectedEndDate;

	@Column(name="project_owner")
	private String projectOwner;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="published_at")
	private Date publishedAt;

	@Lob
	private String remarks;

	@Lob
	@Column(name="resource_name")
	private String resourceName;

	private int resourcecount;

	@Column(name="scrum_master")
	private String scrumMaster;

	@Temporal(TemporalType.DATE)
	private Date startdate;

	private int task;

	@Column(name="tech_stack")
	private String techStack;

	private String title;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="updated_by")
	private int updatedBy;

	public Assignment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getActualEndDate() {
		return this.actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public String getAssignmentType() {
		return this.assignmentType;
	}

	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	public String getBillabilityTerms() {
		return this.billabilityTerms;
	}

	public void setBillabilityTerms(String billabilityTerms) {
		this.billabilityTerms = billabilityTerms;
	}

	public int getBudget() {
		return this.budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getCompletionPercent() {
		return this.completionPercent;
	}

	public void setCompletionPercent(int completionPercent) {
		this.completionPercent = completionPercent;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getCustomerPayment() {
		return this.customerPayment;
	}

	public void setCustomerPayment(int customerPayment) {
		this.customerPayment = customerPayment;
	}

	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getExpectedEndDate() {
		return this.expectedEndDate;
	}

	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public String getProjectOwner() {
		return this.projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Date getPublishedAt() {
		return this.publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getResourcecount() {
		return this.resourcecount;
	}

	public void setResourcecount(int resourcecount) {
		this.resourcecount = resourcecount;
	}

	public String getScrumMaster() {
		return this.scrumMaster;
	}

	public void setScrumMaster(String scrumMaster) {
		this.scrumMaster = scrumMaster;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public int getTask() {
		return this.task;
	}

	public void setTask(int task) {
		this.task = task;
	}

	public String getTechStack() {
		return this.techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public int getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

}