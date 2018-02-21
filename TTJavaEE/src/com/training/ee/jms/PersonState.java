package com.training.ee.jms;

import com.training.ee.model.Person;

public class PersonState {
    private Person person;
    private String id;
    private EState smsState = EState.INPROGRESS;
    private EState emailState= EState.INPROGRESS;
    private EState dbState= EState.INPROGRESS;
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public EState getSmsState() {
        return smsState;
    }
    public void setSmsState(EState smsState) {
        this.smsState = smsState;
    }
    public EState getEmailState() {
        return emailState;
    }
    public void setEmailState(EState emailState) {
        this.emailState = emailState;
    }
    public EState getDbState() {
        return dbState;
    }
    public void setDbState(EState dbState) {
        this.dbState = dbState;
    }
    
    
    
}
