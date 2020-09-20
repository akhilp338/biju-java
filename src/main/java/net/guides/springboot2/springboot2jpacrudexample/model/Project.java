package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project {


	private long projectId;
	private String projectName;
	private String endUser;
	private String client;
	private String supplier;
	private String supplierAddress;
	private String purchaseOrderNumber;

	


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", endUser=" + endUser + ", client="
				+ client + ", supplier=" + supplier + ", supplierAddress=" + supplierAddress + ", purchaseOrderNumber="
				+ purchaseOrderNumber + "]";
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getProjectId() {
		return projectId;
	}

	

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getEndUser() {
		return endUser;
	}

	public void setEndUser(String endUser) {
		this.endUser = endUser;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	
	
}
