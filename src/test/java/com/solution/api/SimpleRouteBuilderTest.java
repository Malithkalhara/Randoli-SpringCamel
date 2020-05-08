package com.solution.api;

import org.apache.camel.EndpointInject;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@MockEndpoints("file://C:/recordsCSV/?fileName=records-${date:now:yy_MM_dd_hh_mm_ss_SSS}.csv&charset=utf-8")
public class SimpleRouteBuilderTest extends CamelTestSupport {
	
	@EndpointInject(uri="mock:file://C:/recordsCSV/?fileName=records-${date:now:yy_MM_dd_hh_mm_ss_SSS}.csv&charset=utf-8")
	MockEndpoint mock;
	
	@Autowired
	ProducerTemplate template;
	
	@Test
	public void testPayloadIsReached() throws InterruptedException {
		
	}
}
