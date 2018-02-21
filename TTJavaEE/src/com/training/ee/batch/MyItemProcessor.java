package com.training.ee.batch;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named("myprocessor")
public class MyItemProcessor implements ItemProcessor{

    @Override
    public Employee processItem(Object item) throws Exception {
        String str = (String) item;
        String[] split = str.split(",");
        Employee employee = new Employee();
        employee.setName(split[0]);
        employee.setAge(Integer.parseInt(split[1]));
        return employee;
    }

}
