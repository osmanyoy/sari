package com.training.ee.cdi;

import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.inject.Named;

@Any
@Named("osman1")
public class ExecuteImpl3 implements IExecute,Serializable {

    private static final long serialVersionUID = 7025157562905094141L;

    @Override
    public String execute() {
        return "Execute 3";
    }

}
