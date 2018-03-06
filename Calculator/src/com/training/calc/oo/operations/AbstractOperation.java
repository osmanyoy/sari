package com.training.calc.oo.operations;

import java.util.Scanner;

import com.training.calc.oo.IOperation;

public abstract class AbstractOperation implements IOperation {
	
	private int parameterCount;
	private String operationName;
	private IOp op;

	public AbstractOperation(int parameterCount,String operationName,IOp op) {
		this.parameterCount = parameterCount;
		this.operationName = operationName;
		this.op = op;
		
	}
	
	// abstract double executeOperation(int[] params);
	
	@Override
	public double execute(Scanner scanner) {
		int[] params = new int[parameterCount]; 
		for (int i = 0; i < parameterCount; i++) {
			System.out.println(operationName + " yapýlacak " + i + ". deðer : ");
			params[i] = scanner.nextInt();
		}
		return op.exec(params);
	}

	public int getParameterCount() {
		return parameterCount;
				
	}
}
