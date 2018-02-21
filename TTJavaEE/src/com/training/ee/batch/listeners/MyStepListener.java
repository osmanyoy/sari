package com.training.ee.batch.listeners;

import javax.batch.api.listener.AbstractStepListener;
import javax.inject.Named;

@Named
public class MyStepListener extends AbstractStepListener{
    @Override
    public void beforeStep() throws Exception {
        System.out.println("beforeStep");
    }
    
    @Override
    public void afterStep() throws Exception {
        System.out.println("beforeStep");
    }
    
}
