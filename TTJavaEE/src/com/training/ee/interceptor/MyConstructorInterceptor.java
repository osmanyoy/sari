package com.training.ee.interceptor;

import java.io.Serializable;
import java.util.UUID;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.training.ee.cdi.PersonHolder;

@Interceptor
@NewAnnotation
public class MyConstructorInterceptor implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = -1991731415483099083L;

    @AroundConstruct
    public Object constructCall(InvocationContext ic) throws Exception {
        Object proceed = ic.proceed();
        TestConstructorInterceptor constructorInterceptor = new TestConstructorInterceptor();
        constructorInterceptor.setId(UUID.randomUUID().toString());
        return constructorInterceptor;
    }
}

