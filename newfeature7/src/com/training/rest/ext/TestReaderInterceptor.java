package com.training.rest.ext;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
@LogMe
public class TestReaderInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		context.getHeaders()
		       .add("test",
		            "test123");
		String first = context.getHeaders()
		                      .getFirst("myheader");
		// if (first == null) {
		// return null;
		// }
		// String firstZip = context.getHeaders().getFirst("zip");
		// if (firstZip != null && firstZip.equals("true")) {
		// InputStream inputStream = context.getInputStream();
		// GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
		// context.setInputStream(gzipInputStream);
		// }
		return context.proceed();
	}

}
