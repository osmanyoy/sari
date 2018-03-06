package com.training.calc.oo;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(OperationFactory.getMenu());
		int nextInt = scanner.nextInt();
		
		IOperation operation = OperationFactory.createOperation(nextInt);

		System.out.println("Ýþlem : " + operation.execute(scanner));

	}
}
