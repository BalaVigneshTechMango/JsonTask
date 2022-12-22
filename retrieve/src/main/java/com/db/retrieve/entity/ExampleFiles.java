package com.db.retrieve.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="example_files")
public class ExampleFiles {

	@Id
	@Column(name = "pr_id")
	private int prId;
	@Column(name = "codes")
	private int codes;
	@Column(name = "platfrom")
	private String platfrom;
	@Column(name = "EnUs")
	private String EnUs;
	@Column(name = "EnIN")
	private String EnIN;
	
	public int getPrId() {
		return prId;
	}
	public void setPrId(int prId) {
		this.prId = prId;
	}
	public int getCodes() {
		return codes;
	}
	public void setCodes(int codes) {
		this.codes = codes;
	}
	public String getPlatfrom() {
		return platfrom;
	}
	public void setPlatfrom(String platfrom) {
		this.platfrom = platfrom;
	}
	public String getEnUs() {
		return EnUs;
	}
	public void setEnUs(String enUs) {
		EnUs = enUs;
	}
	public String getEnIN() {
		return EnIN;
	}
	public void setEnIN(String enIN) {
		EnIN = enIN;
	}

	
	
	
}
