package org.openhmis.domain;

// Generated Aug 4, 2015 11:17:14 PM by Hibernate Tools 4.3.1

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
 * PathClientVeteranInfo generated by hbm2java
 */
@Entity
@Table(name = "PATH_CLIENT_VETERAN_INFO", catalog = "openhmis")
public class PathClientVeteranInfo implements java.io.Serializable {

	private Integer clientKey;
	private Integer veteranKey;
	private String yrEnterMilitary;
	private String yrSepMilitary;
	private Integer militaryBranch;
	private Integer dischargeStatus;
	private Integer worldWarIi;
	private Integer koreanWar;
	private Integer vietnamWar;
	private Integer persianWar;
	private Integer afghanistanWar;
	private Integer iraqFreedom;
	private Integer iraqDawn;
	private Integer other;
	private String createUserKey;
	private String updateUserKey;
	private Date createDate;
	private Date updateTimestamp;
	private Date verifiedDate;

	public PathClientVeteranInfo() {
	}

	public PathClientVeteranInfo(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	public PathClientVeteranInfo(Integer veteranKey, String yrEnterMilitary,
			String yrSepMilitary, Integer militaryBranch,
			Integer dischargeStatus, Integer worldWarIi, Integer koreanWar,
			Integer vietnamWar, Integer persianWar, Integer afghanistanWar,
			Integer iraqFreedom, Integer iraqDawn, Integer other,
			String createUserKey, String updateUserKey, Date createDate,
			Date updateTimestamp, Date verifiedDate) {
		this.veteranKey = veteranKey;
		this.yrEnterMilitary = yrEnterMilitary;
		this.yrSepMilitary = yrSepMilitary;
		this.militaryBranch = militaryBranch;
		this.dischargeStatus = dischargeStatus;
		this.worldWarIi = worldWarIi;
		this.koreanWar = koreanWar;
		this.vietnamWar = vietnamWar;
		this.persianWar = persianWar;
		this.afghanistanWar = afghanistanWar;
		this.iraqFreedom = iraqFreedom;
		this.iraqDawn = iraqDawn;
		this.other = other;
		this.createUserKey = createUserKey;
		this.updateUserKey = updateUserKey;
		this.createDate = createDate;
		this.updateTimestamp = updateTimestamp;
		this.verifiedDate = verifiedDate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CLIENT_KEY", unique = true, nullable = false)
	public Integer getClientKey() {
		return this.clientKey;
	}

	public void setClientKey(Integer clientKey) {
		this.clientKey = clientKey;
	}

	@Column(name = "VETERAN_KEY")
	public Integer getVeteranKey() {
		return this.veteranKey;
	}

	public void setVeteranKey(Integer veteranKey) {
		this.veteranKey = veteranKey;
	}

	@Column(name = "YR_ENTER_MILITARY", length = 20)
	public String getYrEnterMilitary() {
		return this.yrEnterMilitary;
	}

	public void setYrEnterMilitary(String yrEnterMilitary) {
		this.yrEnterMilitary = yrEnterMilitary;
	}

	@Column(name = "YR_SEP_MILITARY", length = 20)
	public String getYrSepMilitary() {
		return this.yrSepMilitary;
	}

	public void setYrSepMilitary(String yrSepMilitary) {
		this.yrSepMilitary = yrSepMilitary;
	}

	@Column(name = "MILITARY_BRANCH")
	public Integer getMilitaryBranch() {
		return this.militaryBranch;
	}

	public void setMilitaryBranch(Integer militaryBranch) {
		this.militaryBranch = militaryBranch;
	}

	@Column(name = "DISCHARGE_STATUS")
	public Integer getDischargeStatus() {
		return this.dischargeStatus;
	}

	public void setDischargeStatus(Integer dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	@Column(name = "WORLD_WAR_II")
	public Integer getWorldWarIi() {
		return this.worldWarIi;
	}

	public void setWorldWarIi(Integer worldWarIi) {
		this.worldWarIi = worldWarIi;
	}

	@Column(name = "KOREAN_WAR")
	public Integer getKoreanWar() {
		return this.koreanWar;
	}

	public void setKoreanWar(Integer koreanWar) {
		this.koreanWar = koreanWar;
	}

	@Column(name = "VIETNAM_WAR")
	public Integer getVietnamWar() {
		return this.vietnamWar;
	}

	public void setVietnamWar(Integer vietnamWar) {
		this.vietnamWar = vietnamWar;
	}

	@Column(name = "PERSIAN_WAR")
	public Integer getPersianWar() {
		return this.persianWar;
	}

	public void setPersianWar(Integer persianWar) {
		this.persianWar = persianWar;
	}

	@Column(name = "AFGHANISTAN_WAR")
	public Integer getAfghanistanWar() {
		return this.afghanistanWar;
	}

	public void setAfghanistanWar(Integer afghanistanWar) {
		this.afghanistanWar = afghanistanWar;
	}

	@Column(name = "IRAQ_FREEDOM")
	public Integer getIraqFreedom() {
		return this.iraqFreedom;
	}

	public void setIraqFreedom(Integer iraqFreedom) {
		this.iraqFreedom = iraqFreedom;
	}

	@Column(name = "IRAQ_DAWN")
	public Integer getIraqDawn() {
		return this.iraqDawn;
	}

	public void setIraqDawn(Integer iraqDawn) {
		this.iraqDawn = iraqDawn;
	}

	@Column(name = "OTHER")
	public Integer getOther() {
		return this.other;
	}

	public void setOther(Integer other) {
		this.other = other;
	}

	@Column(name = "CREATE_USER_KEY", length = 20)
	public String getCreateUserKey() {
		return this.createUserKey;
	}

	public void setCreateUserKey(String createUserKey) {
		this.createUserKey = createUserKey;
	}

	@Column(name = "UPDATE_USER_KEY", length = 20)
	public String getUpdateUserKey() {
		return this.updateUserKey;
	}

	public void setUpdateUserKey(String updateUserKey) {
		this.updateUserKey = updateUserKey;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE", length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATE_TIMESTAMP", nullable = false, length = 19)
	public Date getUpdateTimestamp() {
		return this.updateTimestamp;
	}

	public void setUpdateTimestamp(Date updateTimestamp) {
		this.updateTimestamp = updateTimestamp;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIFIED_DATE", length = 10)
	public Date getVerifiedDate() {
		return this.verifiedDate;
	}

	public void setVerifiedDate(Date verifiedDate) {
		this.verifiedDate = verifiedDate;
	}

}
