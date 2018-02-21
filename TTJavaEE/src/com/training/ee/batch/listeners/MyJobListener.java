package com.training.ee.batch.listeners;

import javax.batch.api.listener.AbstractJobListener;
import javax.inject.Named;

@Named
public class MyJobListener extends AbstractJobListener{
    @Override
    public void beforeJob() throws Exception {
        System.out.println("Job start");
    }
    
    @Override
    public void afterJob() throws Exception {
        System.out.println("Job end");
    }
}
