package com.rdsms.entity;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="bsnl_dsr")
public class DsrBsnl {

		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Id")
		private int id;
		
		@Column(name="Circle")
		private String circle;
		
		@Column(name="CurrentDate")
		private Date currentDate;
		
		@Column(name="Time")
		private Time time;
		
		@Column(name="AgentNo")
		private int agentNo;
		
		@Column(name="ChatId")
		private int chatId;
		
		@Column(name="Vendor")
		private String vendor;
		
		@Column(name="Location")
		private String location;
		
		@Column(name="LastLoginLogoutTime")
		private Timestamp lastLoginLogoutTime;
		
		@Column(name="LastLoginLogoutStatus")
		private String 	lastLoginLogoutStatus;
		
		@Column(name="LastLoginLogoutTimeMins")
		private int loginLogoutTimeMins;
		
		@Column(name="Status")
		private String status;
		
		@Column(name="Hours")
		private int hours;
		
		@Column(name="TotalCalls")
		private int totalCalls;
		
		@Column(name="SuccessCalls")
		private int successCalls;
		
		@Column(name="FailedCalls")
		private int failedCalls;
		
		@Column(name="UnAnsweredCalls")
		private int unAnsweredCalls;
		
		@Column(name="SwitchedOff")
		private int switchedOff;
		
		@Column(name="UserBusy")
		private int userBusy;
		
		@Column(name="NetworkIssue")
		private int networkIssue;
		
		@Column(name="Mou")
		private int mou;
		
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

		public Date getCurrentDate() {
			return currentDate;
		}

		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
		}

		public Time getTime() {
			return time;
		}

		public void setTime(Time time) {
			this.time = time;
		}

		public int getAgentNo() {
			return agentNo;
		}

		public void setAgentNo(int agentNo) {
			this.agentNo = agentNo;
		}

		public int getChatId() {
			return chatId;
		}

		public void setChatId(int chatId) {
			this.chatId = chatId;
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

		public Timestamp getLastLoginLogoutTime() {
			return lastLoginLogoutTime;
		}

		public void setLastLoginLogoutTime(Timestamp timestamp) {
			this.lastLoginLogoutTime = timestamp;
		}

		public String getLastLoginLogoutStatus() {
			return lastLoginLogoutStatus;
		}

		public void setLastLoginLogoutStatus(String lastLoginLogoutStatus) {
			this.lastLoginLogoutStatus = lastLoginLogoutStatus;
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

		public int getHours() {
			return hours;
		}

		public void setHours(int hours) {
			this.hours = hours;
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

		public int getUnAnsweredCalls() {
			return unAnsweredCalls;
		}

		public void setUnAnsweredCalls(int unAnsweredCalls) {
			this.unAnsweredCalls = unAnsweredCalls;
		}

		public int getSwitchedOff() {
			return switchedOff;
		}

		public void setSwitchedOff(int switchedOff) {
			this.switchedOff = switchedOff;
		}

		public int getUserBusy() {
			return userBusy;
		}

		public void setUserBusy(int userBusy) {
			this.userBusy = userBusy;
		}

		public int getNetworkIssue() {
			return networkIssue;
		}

		public void setNetworkIssue(int networkIssue) {
			this.networkIssue = networkIssue;
		}

		public int getMou() {
			return mou;
		}

		public void setMou(int mou) {
			this.mou = mou;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		@Override
		public String toString() {
			return "DsrBsnl [id=" + id + ", circle=" + circle + ", currentDate=" + currentDate + ", time=" + time
					+ ", agentNo=" + agentNo + ", chatId=" + chatId + ", vendor=" + vendor + ", location=" + location
					+ ", lastLoginLogoutTime=" + lastLoginLogoutTime + ", lastLoginLogoutStatus="
					+ lastLoginLogoutStatus + ", loginLogoutTimeMins=" + loginLogoutTimeMins + ", status=" + status
					+ ", hours=" + hours + ", totalCalls=" + totalCalls + ", successCalls=" + successCalls
					+ ", failedCalls=" + failedCalls + ", unAnsweredCalls=" + unAnsweredCalls + ", switchedOff="
					+ switchedOff + ", userBusy=" + userBusy + ", networkIssue=" + networkIssue + ", mou=" + mou
					+ ", isActive=" + isActive + "]";
		}

		
		
}
