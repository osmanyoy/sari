package com.test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ResourceMethodInvoker;
import org.jboss.resteasy.core.ServerResponse;
import org.jboss.resteasy.util.Base64;

@Provider
public class RESTSecurityInterceptor
        implements javax.ws.rs.container.ContainerRequestFilter, ExceptionMapper<Exception> {

	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource",
	                                                                       401,
	                                                                       new Headers<Object>());;
	private static final ServerResponse ACCESS_FORBIDDEN = new ServerResponse("Nobody can access this resource",
	                                                                          403,
	                                                                          new Headers<Object>());;
	private static final ServerResponse SERVER_ERROR = new ServerResponse("INTERNAL SERVER ERROR",
	                                                                      500,
	                                                                      new Headers<Object>());

	@Override
	public void filter(final ContainerRequestContext requestContext) {

		ResourceMethodInvoker methodInvoker = (ResourceMethodInvoker) requestContext.getProperty("org.jboss.resteasy.core.ResourceMethodInvoker");
		Method method = methodInvoker.getMethod();
		// Access allowed for all
		if (!method.isAnnotationPresent(PermitAll.class)) {
			// Access denied for all
			if (method.isAnnotationPresent(DenyAll.class)) {
				requestContext.abortWith(RESTSecurityInterceptor.ACCESS_FORBIDDEN);
				return;
			}

			// Get request headers
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();

			// Fetch authorization header
			final List<String> authorization = headers.get(RESTSecurityInterceptor.AUTHORIZATION_PROPERTY);

			// If no authorization information present; block access
			if ((authorization == null) || authorization.isEmpty()) {
				requestContext.abortWith(RESTSecurityInterceptor.ACCESS_DENIED);
				return;
			}

			// Get encoded username and password
			final String encodedUserPassword = authorization.get(0)
			                                                .replaceFirst(RESTSecurityInterceptor.AUTHENTICATION_SCHEME
			                                                        + " ",
			                                                              "");

			// Decode username and password
			String usernameAndPassword = null;
			try {
				usernameAndPassword = new String(Base64.decode(encodedUserPassword));
			} catch (IOException e) {
				requestContext.abortWith(RESTSecurityInterceptor.SERVER_ERROR);
				return;
			}

			// Split username and password tokens
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword,
			                                                      ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			// Verify user access
			if (method.isAnnotationPresent(RolesAllowed.class)) {
				RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
				Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));

				// Is user valid?
				if (!this.isUserAllowed(username,
				                        password,
				                        rolesSet)) {
					requestContext.abortWith(RESTSecurityInterceptor.ACCESS_DENIED);
					return;
				}
			}
		}
	}

	private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet) {
		boolean isAllowed = false;

		// Step 1. Fetch password from database and match with password in
		// argument
		// If both match then get the defined role for user from database and
		// continue; else return isAllowed [false]
		// Access the database and do this part yourself
		// String userRole = userMgr.getUserRole(username);
		String userRole = "ADMIN";

		// Step 2. Verify user role
		if (rolesSet.contains(userRole)) {
			isAllowed = true;
		}
		return isAllowed;
	}

	@Override
	public Response toResponse(final Exception exception) {
		// TODO Auto-generated method stub
		return null;
	}

}