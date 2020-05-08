package com.solution.api;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class RecordAggregationStratergy implements AggregationStrategy{

    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
         if (oldExchange == null) {
            String str = newExchange.getIn().getBody(String.class);
            newExchange.getIn().setBody(str);
            return newExchange;
        }
        String oldStr = oldExchange.getIn().getBody(String.class);
        String newStr = newExchange.getIn().getBody(String.class);
        oldExchange.getIn().setBody(oldStr+newStr);
        return oldExchange;
    }
    
}