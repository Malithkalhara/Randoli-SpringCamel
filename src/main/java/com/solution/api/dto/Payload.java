package com.solution.api.dto;

import java.util.List;

public class Payload {
	String batchId;
	List<Record> records;
	
	//getters and setters
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	
	

}
