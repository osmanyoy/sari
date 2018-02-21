package com.training.ee.trans;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@RequestScoped
@Transactional
public class CDITransProp {

    @Transactional(value = TxType.REQUIRED,
                   dontRollbackOn = IllegalAccessException.class,
                   rollbackOn = Exception.class)
    public void method1() {
        method2();
        method3();
    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public void method2() {

    }

    @Transactional(value = TxType.SUPPORTS)
    public void method3() {

    }

}
