package com.training.ee.batch;

import java.util.Properties;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/batch")
public class BatchRest {
    
    @GET
    public String start() {
        JobOperator jobOperator = BatchRuntime.getJobOperator();
        Properties properties = new Properties();
        long start = jobOperator.start("myjob", properties);
        return "" + start;
    }
}
