package com.rdsms.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Nitesh
 *
 */

@Entity
@Table(name="mis")
public class MIS {
	
	@Column(name="Id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Date")
	private Date date;
	
	@Column(name="Operator")
	private String operator;
	
	@Column(name="Partner")
	private String partner;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Bni")
	private double bni;
	
	@Column(name="ChatId")
	private int chatId;
	
	@Column(name="CircleId")
	private String circleId;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="TotalCalls")
	private int totalCalls;
	
	@Column(name="FailedCalls")
	private int failedCalls;
	
	@Column(name="UnAnsweredCalls")
	private int unAnsweredCalls;
	
	@Column(name="SwitchedOff")
	private int switchedOff;
	
	@Column(name="UserBusy")
	private int userBusy;
	
	@Column(name="AnsweredCalls")
	private int answeredCalls;
	
	@Column(name="Durations")
	private int durations;
	
	@Column(name="Pulse")
	private int pulse;
	
	@Column(name="Mous")
	private float mous;
	
	@Column(name="Hours")
	private float hrs;
	
	@Column(name="Att")
	private float att;
	
	@Column(name="FailPercentage")
	private int failPercentage;
	
	@Column(name="CallLessThanOneMin")
	private int callLessThanOneMin;
	
	@Column(name="MousLessThanOneMin")
	private float mousLessThanOneMin;
	
	@Column(name="LoginHours")
	private float loginHours;
	
	@Column(name="FirstPartyDisconnects")
	private float firstPartyDisconnects;
	
	@Column(name="SecondPartyDisconnects")
	private float secondPartyDisconnects;
		
	public MIS() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public double getBni() {
		return bni;
	}

	public void setBni(double bni) {
		this.bni = bni;
	}

	public int getChatId() {
		return chatId;
	}

	public void setChatId(int chatId) {
		this.chatId = chatId;
	}

	public String getCircleId() {
		return circleId;
	}

	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTotalCalls() {
		return totalCalls;
	}

	public void setTotalCalls(int totalCalls) {
		this.totalCalls = totalCalls;
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

	public int getAnsweredCalls() {
		return answeredCalls;
	}

	public void setAnsweredCalls(int answeredCalls) {
		this.answeredCalls = answeredCalls;
	}

	public int getDurations() {
		return durations;
	}

	public void setDurations(int durations) {
		this.durations = durations;
	}

	public int getPulse() {
		return pulse;
	}

	public void setPulse(int pulse) {
		this.pulse = pulse;
	}

	public float getMous() {
		return mous;
	}

	public void setMous(float mous) {
		this.mous = mous;
	}

	public float getHrs() {
		return hrs;
	}

	public void setHrs(float hrs) {
		this.hrs = hrs;
	}

	public float getAtt() {
		return att;
	}

	public void setAtt(float att) {
		this.att = att;
	}

	public int getFailPercentage() {
		return failPercentage;
	}

	public void setFailPercentage(int failPercentage) {
		this.failPercentage = failPercentage;
	}

	public int getCallLessThanOneMin() {
		return callLessThanOneMin;
	}

	public void setCallLessThanOneMin(int callLessThanOneMin) {
		this.callLessThanOneMin = callLessThanOneMin;
	}

	public float getMousLessThanOneMin() {
		return mousLessThanOneMin;
	}

	public void setMousLessThanOneMin(float mousLessThanOneMin) {
		this.mousLessThanOneMin = mousLessThanOneMin;
	}

	public float getLoginHours() {
		return loginHours;
	}

	public void setLoginHours(float loginHours) {
		this.loginHours = loginHours;
	}

	public float getFirstPartyDisconnects() {
		return firstPartyDisconnects;
	}

	public void setFirstPartyDisconnects(float firstPartyDisconnects) {
		this.firstPartyDisconnects = firstPartyDisconnects;
	}

	public float getSecondPartyDisconnects() {
		return secondPartyDisconnects;
	}

	public void setSecondPartyDisconnects(float secondPartyDisconnects) {
		this.secondPartyDisconnects = secondPartyDisconnects;
	}

	@Override
	public String toString() {
		return "MIS [id=" + id + ", date=" + date + ", operator=" + operator + ", partner=" + partner + ", location="
				+ location + ", bni=" + bni + ", chatId=" + chatId + ", circleId=" + circleId + ", type=" + type
				+ ", totalCalls=" + totalCalls + ", failedCalls=" + failedCalls + ", unAnsweredCalls=" + unAnsweredCalls
				+ ", switchedOff=" + switchedOff + ", userBusy=" + userBusy + ", answeredCalls=" + answeredCalls
				+ ", durations=" + durations + ", pulse=" + pulse + ", mous=" + mous + ", hrs=" + hrs + ", att=" + att
				+ ", failPercentage=" + failPercentage + ", callLessThanOneMin=" + callLessThanOneMin
				+ ", mousLessThanOneMin=" + mousLessThanOneMin + ", loginHours=" + loginHours
				+ ", firstPartyDisconnects=" + firstPartyDisconnects + ", secondPartyDisconnects="
				+ secondPartyDisconnects + "]";
	}


}
