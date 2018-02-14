package com.training.ee.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

@Singleton
@Startup
@DependsOn({})
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonEJB {
    
    @Resource
    private TimerService timerService;
    
    private int index = 0;
    
    @PostConstruct
    public void PostConstruct() {
        timerService.createSingleActionTimer(10_000, null);
    }
    
    @Timeout
    public void timeout() {
        System.out.println("timeout is here");
    }
    
    @Lock(LockType.READ)
    public int getIndex() {
        return index;
    }
    
    @Lock(LockType.WRITE)
    public int increaseIndex() {
        return index++;
    }
    
    @Schedule(hour="*",minute="*/6",second="*",persistent=false)
    public void execute() {
        System.out.println("Execute called");
    }
    
    
}
