package com.training.ee.batch;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.batch.api.chunk.AbstractItemReader;
import javax.inject.Named;

@Named("myreader")
public class ItemReader extends AbstractItemReader{
    private List<String> employees = new ArrayList<>();
    private int counter = 0;
    
    public ItemReader() {
        try (Stream<String> stream = Files.lines(Paths.get("c:\\temp1\\mylist.txt"))){
            stream.forEach(str -> {
                employees.add(str);
            } );
        } catch (Exception e) {
        }
    }
    
    @Override
    public String readItem() throws Exception {
        String employee = null;
        if (counter < employees.size()) {
            employee =employees.get(counter++);
        }
        return employee;
    }
    
}
