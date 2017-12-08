package com.training.ee.interceptor;

import java.lang.reflect.Field;

import javax.interceptor.AroundConstruct;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@NewInterceptor
public class MyConstructInterceptor {

	public MyConstructInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@AroundConstruct
	public Object aroundInvoke(final InvocationContext ic) throws Exception {
		System.out.println("Before Construct");
		Object proceed = ic.proceed();
		Class<?> class1 = proceed.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		for (Field field : declaredFields) {
			MyAnno annotation = field.getAnnotation(MyAnno.class);
			if (annotation != null) {
				String myValue = annotation.myValue();
				field.set(proceed,
				          myValue);
			}
		}
		return ic.proceed();
	}

}
