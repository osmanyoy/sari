package com.training.calc;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-Toplama\n2-Çýkarma\n3-Çarpma\n4-Bölme\n");
		int nextInt = scanner.nextInt();
		int nextInt2 = scanner.nextInt();
		int nextInt3 = scanner.nextInt();
		if (nextInt == 1) {
			System.out.println("Toplam : " + (nextInt2 + nextInt3));

		} else if (nextInt == 2) {
			System.out.println("Çýkarma : " + (nextInt2 - nextInt3));

		} else if (nextInt == 3) {
			System.out.println("Çarpým : " + (nextInt2 * nextInt3));

		} else if (nextInt == 4) {
			System.out.println("Böldümk : " + (nextInt2 / nextInt3));

		}

	}

}
