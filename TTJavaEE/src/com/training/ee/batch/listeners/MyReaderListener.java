package com.training.ee.batch.listeners;

import javax.batch.api.chunk.listener.AbstractItemReadListener;
import javax.inject.Named;


@Named
public class MyReaderListener extends AbstractItemReadListener{
    @Override
    public void beforeRead() throws Exception {
        System.out.println("beforeRead");
    }
    
    @Override
    public void afterRead(Object item) throws Exception {
        System.out.println("Read : " + item);
    }
    
    @Override
    public void onReadError(Exception ex) throws Exception {
        System.err.println(ex.getMessage());
    }
}
