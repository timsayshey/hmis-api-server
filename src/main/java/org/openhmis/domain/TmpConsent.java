package org.openhmis.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TmpContact generated by hbm2java
 */
@Entity
@Table(name = "TMP_CONSENT")
public class TmpConsent implements java.io.Serializable {

	private Integer consentId;
	private Integer submitterId;
	private Date dateProcessed;
	private Date dateCreated;
	private Date dateUpdated;

	public TmpConsent() {
	}

	public TmpConsent(Integer consentId, Integer submitterId, Date dateProcessed, Date dateCreated, Date dateUpdated) {
		this.consentId = consentId;
		this.submitterId = submitterId;
		this.dateProcessed = dateProcessed;
		this.dateCreated = dateCreated;
		this.dateUpdated = dateUpdated;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "consentId", unique = true, nullable = false)
	public Integer getConsentId() {
		return this.consentId;
	}

	public void setConsentId(Integer consentId) {
		this.consentId = consentId;
	}

	@Column(name = "submitterId")
	public Integer getSubmitterId() {
		return this.submitterId;
	}

	public void setSubmitterId(Integer submitterId) {
		this.submitterId = submitterId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateProcessed", length = 10)
	public Date getDateProcessed() {
		return this.dateProcessed;
	}

	public void setDateProcessed(Date dateProcessed) {
		this.dateProcessed = dateProcessed;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateCreated", length = 10)
	public Date getDateCreated() {
		return this.dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateUpdated", length = 10)
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
