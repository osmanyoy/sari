package com.training.patterns.prototype;

import java.util.Arrays;
import java.util.List;

public class CustomerFactory {
	public Customer customerNormal;
	public Customer customerAdmin;
	public Customer customerReport;

	public CustomerFactory() {
		List<String> normalRoles = Arrays.asList("role1",
		                                         "role2");
		List<String> normalGroups = Arrays.asList("group1",
		                                          "group2");
		this.customerNormal = new Customer();
		this.customerNormal.setRoles(normalRoles);
		this.customerNormal.setGroup(normalGroups);

		List<String> adminRoles = Arrays.asList("arole1",
		                                        "arole2");
		List<String> adminGroups = Arrays.asList("agroup1",
		                                         "agroup2");
		this.customerAdmin = new Customer();
		this.customerAdmin.setRoles(adminRoles);
		this.customerAdmin.setGroup(adminGroups);

		List<String> reportRoles = Arrays.asList("rrole1",
		                                         "rrole2");
		List<String> reportGroups = Arrays.asList("rgroup1",
		                                          "rgroup2");
		this.customerReport = new Customer();
		this.customerReport.setRoles(reportRoles);
		this.customerReport.setGroup(reportGroups);
	}

	public Customer createCustomer(final ECustomerType customerType) {
		try {
			switch (customerType) {
			case ADMIN:
				return (Customer) this.customerAdmin.clone();
			case NORMAL:
				return (Customer) this.customerNormal.clone();
			case REPORT:
				return (Customer) this.customerReport.clone();
			default:
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
