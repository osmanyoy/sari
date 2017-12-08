package com.training.ee.interceptor;

import java.lang.reflect.Method;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.jboss.logging.Logger;

@Interceptor
@LogInterceptor
public class MyInterceptor {

	private static final Logger log = Logger.getLogger(MyInterceptor.class);

	public MyInterceptor() {
	}

	@AroundInvoke
	public Object xyz(final InvocationContext ic) throws Exception {
		Method method = ic.getMethod();
		MyInterceptor.log.info("About to invoke : " + method.getName());
		long delta = System.currentTimeMillis();
		Object proceed = ic.proceed();
		MyInterceptor.log.info("Invoked : " + method.getName() + " delta : " + (System.currentTimeMillis() - delta));
		String string = null;
		if (proceed instanceof String) {
			string = (String) proceed;
			string += " intercepted";
			return string;
		}
		return proceed;
	}

}
