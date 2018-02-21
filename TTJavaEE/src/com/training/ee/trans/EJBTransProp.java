package com.training.ee.trans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class EJBTransProp {
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void trans1() {
        
    }
    
}
