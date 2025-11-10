package com.idsspl.webproject.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AGENT_OPENING_DENOMINATION", schema = "CUSTOMER")
public class OpeningDenominationEntity {



	@EmbeddedId
    private OpeningDenominationId id;

	
	@Column(name = "agent_name")
	private String agentName;


	@Column(name = "r2000")
	private Long r2000;
	@Column(name = "r500")
	private Long r500;
	@Column(name = "r200")
	private Long r200;
	@Column(name = "r100")
	private Long r100;
	@Column(name = "r50")
	private Long r50;
	@Column(name = "r20")
	private Long r20;
	@Column(name = "r10")
	private Long r10;
	@Column(name = "r5")
	private Long r5;
	@Column(name = "r2")
	private Long r2;
	@Column(name = "r1")
	private Long r1;
	@Column(name = "oppening_amount")
	private Long openingAmount;
	public OpeningDenominationId getId() {
		return id;
	}
	public String getAgentName() {
		return agentName;
	}
	public Long getR2000() {
		return r2000;
	}
	public Long getR500() {
		return r500;
	}
	public Long getR200() {
		return r200;
	}
	public Long getR100() {
		return r100;
	}
	public Long getR50() {
		return r50;
	}
	public Long getR20() {
		return r20;
	}
	public Long getR10() {
		return r10;
	}
	public Long getR5() {
		return r5;
	}
	public Long getR2() {
		return r2;
	}
	public Long getR1() {
		return r1;
	}
	public Long getOpeningAmount() {
		return openingAmount;
	}
	public void setId(OpeningDenominationId id) {
		this.id = id;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public void setR2000(Long r2000) {
		this.r2000 = r2000;
	}
	public void setR500(Long r500) {
		this.r500 = r500;
	}
	public void setR200(Long r200) {
		this.r200 = r200;
	}
	public void setR100(Long r100) {
		this.r100 = r100;
	}
	public void setR50(Long r50) {
		this.r50 = r50;
	}
	public void setR20(Long r20) {
		this.r20 = r20;
	}
	public void setR10(Long r10) {
		this.r10 = r10;
	}
	public void setR5(Long r5) {
		this.r5 = r5;
	}
	public void setR2(Long r2) {
		this.r2 = r2;
	}
	public void setR1(Long r1) {
		this.r1 = r1;
	}
	public void setOpeningAmount(Long openingAmount) {
		this.openingAmount = openingAmount;
	}


}
