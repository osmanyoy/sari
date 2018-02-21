package com.training.ee.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.sql.DataSource;

import org.jboss.logging.Logger;

@Singleton
@Startup
@DependsOn({})
@LocalBean
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class SingletonEJB {
    
    public static final Logger logger = Logger.getLogger(SingletonEJB.class);
    
    @Resource(lookup="java:jboss/datasources/mysqlDS")
    private DataSource datasource;
    
    @Resource
    private SessionContext sessionContext;
    
    private int index = 0;
    
    @PostConstruct
    public void PostConstruct() {
        sessionContext.getTimerService().createSingleActionTimer(10_000, new TimerConfig());
    }
    
    @Timeout
    public void timeout() {
        System.out.println("timeout is here");
        try {
            Connection connection = datasource.getConnection();
            Statement createStatement = connection.createStatement();
            ResultSet executeQuery = createStatement.executeQuery("SELECT * FROM SPOUSE");
            while (executeQuery.next()) {
                String name = executeQuery.getString(2);
                String surname = executeQuery.getString(3);
                logger.info("Name : " + name + " Surname : " + surname);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    @Lock(LockType.READ)
    public int getIndex() {
        return index;
    }
    
    @Lock(LockType.WRITE)
    public int increaseIndex() {
        return index++;
    }
    
    @Schedule(hour="*",minute="*",second="10",persistent=false)
    public void execute() {
        System.out.println("Execute called");
    }
    
    
}
