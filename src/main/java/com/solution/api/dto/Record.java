package com.solution.api.dto;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@CsvRecord(separator=",", crlf="UNIX")
public class Record {
	@DataField(pos = 1)
    String transId;
    
    @DataField(pos = 2)
    String transTms;
     
    @DataField(pos = 3)
    int rcNum;
      
    @DataField(pos = 4)
    String clientId;

    //getters and setters
	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransTms() {
		return transTms;
	}

	public void setTransTms(String transTms) {
		this.transTms = transTms;
	}

	public int getRcNum() {
		return rcNum;
	}

	public void setRcNum(int rcNum) {
		this.rcNum = rcNum;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
    
    
}
