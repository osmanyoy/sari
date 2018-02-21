package com.training.ee.cdi;

import javax.enterprise.inject.Default;

@Default
public class ExecuteImpl2 implements IExecute {

    @Override
    public String execute() {
        return "Execute 2";
    }

}
