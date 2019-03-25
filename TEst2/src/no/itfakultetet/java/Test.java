package no.itfakultetet.java;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		System.out.println("Hallo verden!");

		ArrayList<String> navn = new ArrayList<>();
		navn.add("Ola");
		navn.add("Kari");
		navn.add("Petter");

		for (String person : navn) {
			System.out.println("Navn: " + person);
		}

	}

}
