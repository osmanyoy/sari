package com.training.calc;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1-Toplama\n2-��karma\n3-�arpma\n4-B�lme\n");
		int nextInt = scanner.nextInt();
		int nextInt2 = scanner.nextInt();
		int nextInt3 = scanner.nextInt();
		if (nextInt == 1) {
			System.out.println("Toplam : " + (nextInt2 + nextInt3));

		} else if (nextInt == 2) {
			System.out.println("��karma : " + (nextInt2 - nextInt3));

		} else if (nextInt == 3) {
			System.out.println("�arp�m : " + (nextInt2 * nextInt3));

		} else if (nextInt == 4) {
			System.out.println("B�ld�mk : " + (nextInt2 / nextInt3));

		}

	}

}
