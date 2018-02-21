package com.training.ee.batch.listeners;

import javax.batch.api.chunk.listener.AbstractChunkListener;
import javax.inject.Named;

@Named
public class MyChunkListener extends AbstractChunkListener{
    @Override
    public void beforeChunk() throws Exception {
        System.out.println("beforeChunk");
    }
    
    @Override
    public void afterChunk() throws Exception {
        System.out.println("afterChunk");
    }
    
    @Override
    public void onError(Exception ex) throws Exception {
        System.out.println("onError");

    }
}
