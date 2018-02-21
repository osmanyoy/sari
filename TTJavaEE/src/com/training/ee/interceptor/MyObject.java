package com.training.ee.interceptor;

public class MyObject {
    
    @LogInterceptor
    public String doSomething() {
        return "I did it";
    }
    
}
