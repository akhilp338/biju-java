package net.guides.springboot2.springboot2jpacrudexample.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "punchList")
public class PunchList {

	private long id;

	private String ProjectId;
	private String purchaseOrderNumber;
	private String reportNumber;
	private String sequenceNumber;
	private String equipment;
	private String tagNumber;
	private java.util.Date dateRaised;
	private Date plannedCompletionDate;
	private String description;
	private String photos;
	private String actionBy;
	private String punchPointCategory;
	private String openClose;
	private String closureEvidence;
	private String Comments;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProject(String project) {
		ProjectId = project;
	}
	public String getPurchaseOrderNumber() {
		return purchaseOrderNumber;
	}
	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		this.purchaseOrderNumber = purchaseOrderNumber;
	}
	public String getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getEquipment() {
		return equipment;
	}
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	public String getTagNumber() {
		return tagNumber;
	}
	public void setTagNumber(String tagNumber) {
		this.tagNumber = tagNumber;
	}
	public java.util.Date getDateRaised() {
		return dateRaised;
	}
	public void setDateRaised(java.util.Date dateRaised) {
		this.dateRaised = dateRaised;
	}
	public Date getPlannedCompletionDate() {
		return plannedCompletionDate;
	}
	public void setPlannedCompletionDate(Date plannedCompletionDate) {
		this.plannedCompletionDate = plannedCompletionDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	public String getActionBy() {
		return actionBy;
	}
	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}
	public String getPunchPointCategory() {
		return punchPointCategory;
	}
	public void setPunchPointCategory(String punchPointCategory) {
		this.punchPointCategory = punchPointCategory;
	}
	public String getOpenClose() {
		return openClose;
	}
	public void setOpenClose(String openClose) {
		this.openClose = openClose;
	}
	public String getClosureEvidence() {
		return closureEvidence;
	}
	public void setClosureEvidence(String closureEvidence) {
		this.closureEvidence = closureEvidence;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getComments() {
		return Comments;
	}
	public void setComments(String comments) {
		Comments = comments;
	}
	@Override
	public String toString() {
		return "PunchList [id=" + id + ", Project=" + ProjectId + ", purchaseOrderNumber=" + purchaseOrderNumber
				+ ", reportNumber=" + reportNumber + ", sequenceNumber=" + sequenceNumber + ", equipment=" + equipment
				+ ", tagNumber=" + tagNumber + ", dateRaised=" + dateRaised + ", plannedCompletionDate="
				+ plannedCompletionDate + ", description=" + description + ", photos=" + photos + ", actionBy="
				+ actionBy + ", punchPointCategory=" + punchPointCategory + ", openClose=" + openClose
				+ ", closureEvidence=" + closureEvidence + ", Comments=" + Comments + "]";
	}


	
}
