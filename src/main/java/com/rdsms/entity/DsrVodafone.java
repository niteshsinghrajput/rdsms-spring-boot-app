package com.rdsms.entity;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
/**
 * @author Nitesh
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vodafone_dsr")
public class DsrVodafone {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Id")
	private int id;
	
	@Column(name="Circle")
	private String circle;
	
	@Column(name="AgentLocation")
	private String agentLocation;
	
	@Column(name="ReportDateTime")
	private Date reportDateTime;
	
	@Column(name="DetailHours")
	private int detailHours;
	
	@Column(name="LoginLogoutTime")
	private Timestamp loginLogoutTime;
	
	@Column(name="ChatId")
	private int chatId;
	
	@Column(name="LoginLogoutStatus")
	private String loginLogoutStatus;
	
	@Column(name="Ani")
	private long ani;
	
	@Column(name="Vendor")
	private String vendor;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="LoginLogoutTimeMins")
	private int loginLogoutTimeMins;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="Category")
	private String category;
	
	@Column(name="Priority")
	private int priority;
	
	@Column(name="TotalCalls")
	private int totalCalls;
	
	@Column(name="SuccessCalls")
	private int successCalls;
	
	@Column(name="FailedCalls")
	private int failedCalls;
	
	@Column(name="Pulses")
	private int pulses;
	
	@Column(name="Mou")
	private int mou;
	
	@Column(name="Others")
	private int others;
	
	@Column(name="APartyDisconnects")
	private int aPartyDisconnects;
	
	@Column(name="UnAnswered")
	private int unAnswered;
	
	@Column(name="SwitchedOff")
	private int switchedOff;
	
	@Column(name="IsActive")
	private boolean isActive;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getAgentLocation() {
		return agentLocation;
	}

	public void setAgentLocation(String agentLocation) {
		this.agentLocation = agentLocation;
	}

	public Date getReportDateTime() {
		return reportDateTime;
	}

	public void setReportDateTime(Date reportDateTime) {
		this.reportDateTime = reportDateTime;
	}

	public int getDetailHours() {
		return detailHours;
	}

	public void setDetailHours(int detailHours) {
		this.detailHours = detailHours;
	}

	public Timestamp getLoginLogoutTime() {
		return loginLogoutTime;
	}

	public void setLoginLogoutTime(Timestamp timestamp) {
		this.loginLogoutTime = timestamp;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getLoginLogoutStatus() {
		return loginLogoutStatus;
	}

	public void setLoginLogoutStatus(String loginLogoutStatus) {
		this.loginLogoutStatus = loginLogoutStatus;
	}

	public long getAni() {
		return ani;
	}

	public void setAni(long ani) {
		this.ani = ani;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getLoginLogoutTimeMins() {
		return loginLogoutTimeMins;
	}

	public void setLoginLogoutTimeMins(int loginLogoutTimeMins) {
		this.loginLogoutTimeMins = loginLogoutTimeMins;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getTotalCalls() {
		return totalCalls;
	}

	public void setTotalCalls(int totalCalls) {
		this.totalCalls = totalCalls;
	}

	public int getSuccessCalls() {
		return successCalls;
	}

	public void setSuccessCalls(int successCalls) {
		this.successCalls = successCalls;
	}

	public int getFailedCalls() {
		return failedCalls;
	}

	public void setFailedCalls(int failedCalls) {
		this.failedCalls = failedCalls;
	}

	public int getPulses() {
		return pulses;
	}

	public void setPulses(int pulses) {
		this.pulses = pulses;
	}

	public int getMou() {
		return mou;
	}

	public void setMou(int mou) {
		this.mou = mou;
	}

	public int getOthers() {
		return others;
	}

	public void setOthers(int others) {
		this.others = others;
	}

	public int getaPartyDisconnects() {
		return aPartyDisconnects;
	}

	public void setaPartyDisconnects(int aPartyDisconnects) {
		this.aPartyDisconnects = aPartyDisconnects;
	}

	public int getUnAnswered() {
		return unAnswered;
	}

	public void setUnAnswered(int unAnswered) {
		this.unAnswered = unAnswered;
	}

	public int getSwitchedOff() {
		return switchedOff;
	}

	public void setSwitchedOff(int switchedOff) {
		this.switchedOff = switchedOff;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "DsrVoda [id=" + id + ", circle=" + circle + ", agentLocation=" + agentLocation + ", reportDateTime="
				+ reportDateTime + ", detailHours=" + detailHours + ", loginLogoutTime=" + loginLogoutTime + ", chatId="
				+ chatId + ", loginLogoutStatus=" + loginLogoutStatus + ", ani=" + ani + ", vendor=" + vendor
				+ ", location=" + location + ", loginLogoutTimeMins=" + loginLogoutTimeMins + ", status=" + status
				+ ", category=" + category + ", priority=" + priority + ", totalCalls=" + totalCalls + ", successCalls="
				+ successCalls + ", failedCalls=" + failedCalls + ", pulses=" + pulses + ", mou=" + mou + ", others="
				+ others + ", aPartyDisconnects=" + aPartyDisconnects + ", unAnswered=" + unAnswered + ", switchedOff="
				+ switchedOff + ", isActive=" + isActive + "]";
	}

}
