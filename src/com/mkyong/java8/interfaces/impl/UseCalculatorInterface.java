package com.mkyong.java8.interfaces.impl;

import static java.lang.System.out;

import eg.com.tm.java8.features.lambda2.mthdRefs.CalculatorInterface;

public class UseCalculatorInterface {
	public static void main(String[] args) {

		multi();
		soma();
		subtrac();
		divide();
	}

	private static void multi() {
		CalculatorInterface calc = (v1, v2) -> {
			int result = v1 * v2;
			out.println("The calculation result is: " + result);
		};

		calc.doCalculate(10, 5);
	}

	private static void soma() {
		CalculatorInterface calc = (v1, v2) -> {
			int result = v1 + v2;
			out.println("The calculation result is: " + result);
		};

		calc.doCalculate(10, 5);
	}
	private static void subtrac() {
		CalculatorInterface calc = (v1, v2) -> {
			int result = v1 + v2;
			out.println("The calculation result is: " + result);
		};

		calc.doCalculate(10, 5);
	}
	private static void divide() {
		CalculatorInterface calc = (v1, v2) -> {
			int result = v1 + v2;
			out.println("The calculation result is: " + result);
		};

		calc.doCalculate(10, 5);
	}
	
}
