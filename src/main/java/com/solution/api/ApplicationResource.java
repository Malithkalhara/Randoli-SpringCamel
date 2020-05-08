package com.solution.api;

import java.util.Map;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.BindyType;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solution.api.dto.Record;

@Component
public class ApplicationResource extends RouteBuilder {
	
	Logger log = LoggerFactory.getLogger(ApplicationResource.class);

	private ObjectMapper jsonMapper = new ObjectMapper();
	
	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet")
		.port(9090)
		.host("localhost")
		.bindingMode(RestBindingMode.json);
		
		
		rest().post("/exportPayload").to("direct:processPayload");
		from("direct:processPayload")
			.setProperty("batchId", jsonpath("$.batchId"))
			//spilt records
			.split(jsonpath("$.records")).process((exchange) -> {
				  Map map = (Map) exchange.getIn().getBody();
		          Record record = jsonMapper.convertValue(map, Record.class);
		          exchange.getIn().setBody(record);
			})
			//transform to CSV format
			.marshal().bindy(BindyType.Csv, Record.class)
			// aggregate all using same expression
            .aggregate(constant(true),new RecordAggregationStratergy())
            //set completion size
            .completionSize(10)
            //set completion timeout to 1 minute
            .completionTimeout(60000)
            //file location
            .to("file://C:/recordsCSV/?fileName=records-${date:now:yy_MM_dd_hh_mm_ss_SSS}.csv&charset=utf-8");
	}

}
