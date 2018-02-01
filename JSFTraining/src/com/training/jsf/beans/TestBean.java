package com.training.jsf.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.training.jsf.SecondObject;

@Named
@RequestScoped
public class TestBean implements Serializable {
	private static final long serialVersionUID = -7001012107395574865L;
	
	private String str ="osman";
	private String second = "veli";
	
	@Inject
	private SecondObject secondObject;

	public TestBean() {
		System.out.println("TestBean created!");
	}
	
	@PostConstruct
	public void init() {
		System.out.println(secondObject);
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Test Bean destroy");
	}
	
	public String myAction() {
		return "ikinci";
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}


	public SecondObject getSecondObject() {
		return secondObject;
	}


	public void setSecondObject(SecondObject secondObject) {
		this.secondObject = secondObject;
	}
	
	
}
