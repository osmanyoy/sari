package com.training.calc.oo;

import com.training.calc.oo.operations.Bolme;
import com.training.calc.oo.operations.Carpma;
import com.training.calc.oo.operations.Cikarma;
import com.training.calc.oo.operations.Square;
import com.training.calc.oo.operations.Toplama;

public class OperationFactory {
	public static IOperation createOperation(int nextInt) {
		IOperation operation = null;
		if (nextInt == 1) {
			operation = new Toplama();
		} else if (nextInt == 2) {
			operation = new Cikarma();
		} else if (nextInt == 3) {
			operation = new Carpma();
		} else if (nextInt == 4) {
			operation = new Bolme();
		} else if (nextInt == 5) {
			operation = new Square();
		}
			
		return operation;
	}
	
	public static String getMenu() {
		return "1-Toplama\n2-Çýkarma\n3-Çarpma\n4-Bölme\n5-Üst";
	}
}
