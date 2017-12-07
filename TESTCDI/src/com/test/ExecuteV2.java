package com.test;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class ExecuteV2 implements IExecute, Serializable {

	private static final long serialVersionUID = 6168891021543386846L;

	private int counter;

	public ExecuteV2() {
	}

	@PostConstruct
	public void Init() {
	}

	@Override
	public String execute() {
		int a = this.counter++;
		if (a == 5) {
			System.out.println("a = 5");
		}
		return "V2 : " + a;
	}

}
