package com.training.jsf.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Town {
	@Id
	@GeneratedValue
	private long townId;
	private String townName;

	public long getTownId() {
		return townId;
	}
	public void setTownId(long townId) {
		this.townId = townId;
	}
	public String getTownName() {
		return townName;
	}
	public void setTownName(String townName) {
		this.townName = townName;
	}
	
	
	
}
