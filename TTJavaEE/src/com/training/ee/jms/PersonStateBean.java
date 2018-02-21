package com.training.ee.jms;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

@Singleton
@LocalBean
public class PersonStateBean {
    private Map<String, PersonState> personStateMap = new HashMap<>();
    
    public PersonState getPersonState(String id) {
        return personStateMap.get(id);
    }
    
    public void writePersonState(PersonState personState) {
        personStateMap.put(personState.getId(), personState);
    }
}
