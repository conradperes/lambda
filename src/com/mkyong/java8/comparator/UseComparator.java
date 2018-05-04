package com.mkyong.java8.comparator;

import static java.lang.System.out;
import static java.util.Collections.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UseComparator {

	public static void main(String[] args) {

		List<String> values = Arrays.asList("AAA", "bbb", "CCC", "ddd", "EEE");

		// Case sensitive sort operation
		sort(values);

		out.println("Simple sort:");
		print(values);

		// Case insensetive sort operation with anonymous class
		// Collections.sort(values, new Comparator<String>() {
		//
		// @Override
		// public int compare(String o1, String o2) {
		// return o1.compareToIgnoreCase(o2);
		// }
		// });

		// Case insensetive sort operation with Lambda
		sort(values, (o1, o2) -> o1.compareToIgnoreCase(o2));

		out.println("Sort with Comparator");
		print(values);
	}

	/**
	 * Function to print provided data.
	 * 
	 * @param data
	 *            to be printed
	 */
	private static void print(Collection<String> data) {

		data.stream().forEach(s -> out.println(s));
	}
}
