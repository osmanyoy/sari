package com.training.rest;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Person {
	
	@NotNull(message="isim boþ olamaz")
	@MatrixParam("name")
	private String isim;
	
	@Size(min=2,max=30,message="2 ile 30 arasýnda giriniz")
	@MatrixParam("surname")
	private String soyisim;
	
	@Max(100)
	@Min(10)
	@FormParam("age")
	private int yas;
	
	@FormParam("city")
	private String sehir;
	
	@HeaderParam("department")
	private String department;
	
	@HeaderParam("company")
	private String company;

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public String getSoyisim() {
		return soyisim;
	}

	public void setSoyisim(String soyisim) {
		this.soyisim = soyisim;
	}

	public int getYas() {
		return yas;
	}

	public void setYas(int yas) {
		this.yas = yas;
	}

	public String getSehir() {
		return sehir;
	}

	public void setSehir(String sehir) {
		this.sehir = sehir;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Person [isim="
		       + isim
		       + ", soyisim="
		       + soyisim
		       + ", yas="
		       + yas
		       + ", sehir="
		       + sehir
		       + ", department="
		       + department
		       + ", company="
		       + company
		       + "]";
	}
	

}
