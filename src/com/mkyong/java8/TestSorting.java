package com.mkyong.java8;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestSorting {

	private static final String ORDER_BY_SALARY = "Salary";
	private static final String ORDER_BY_AGE = "Age";
	private static final String ORDER_BY_NAME = "Name";

	public static void main(String[] args) {
		sortByName();
		sortByAge();
		sortBySalary();
	}

	private static void sortByName() {
		List<Developer> listDevs = listBefore(ORDER_BY_NAME);
		// lambda here!
		listDevs.sort((Developer o1, Developer o2) -> o1.getNome().compareTo(o2.getNome()));
		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}

	private static List<Developer> listBefore(String atributte) {
		List<Developer> listDevs = getDevelopers();
		System.out.println("Before Sort by "+atributte);
		for (Developer developer : listDevs) {
			System.out.println(developer);
		}
		System.out.println("After Sort by "+atributte);
		return listDevs;
	}
	
	private static void sortByAge() {
		List<Developer> listDevs = listBefore(ORDER_BY_AGE);
		// lambda here!
		listDevs.sort((Developer o1, Developer o2) -> o1.getAge()-o2.getAge());
		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}
	
	private static void sortBySalary() {
		List<Developer> listDevs = listBefore(ORDER_BY_SALARY);
		// lambda here!
		listDevs.sort((Developer o1, Developer o2) -> o1.getSalary().compareTo(o2.getSalary()));
		// java 8 only, lambda also, to print the List
		listDevs.forEach((developer) -> System.out.println(developer));
	}

	private static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();
		result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));
		return result;
	}
}