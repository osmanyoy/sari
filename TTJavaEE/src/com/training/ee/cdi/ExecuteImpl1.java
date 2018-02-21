package com.training.ee.cdi;

import javax.enterprise.inject.Any;

@Any
@MySelAnno
public class ExecuteImpl1 implements IExecute{

    @Override
    public String execute() {
        return "Execute 1";
    }

}
