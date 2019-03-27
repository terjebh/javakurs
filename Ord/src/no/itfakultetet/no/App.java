package no.itfakultetet.no;

import java.util.Map;

public class App {

	public static void main(String[] args) {

		// Sjekk at det gis ett argument til programmet eller opplys om bruken

		if (args.length != 1) {
			System.out.println("Bruk: java -Jar ord.jar <tekstfil>");
			System.exit(0);
		}

		// Hent filnavnet fra kommandolinjens første argument (det første vi
		// skriver inn) og lagre filnavnet i variablen fil

		String fil = args[0];

		// Instansier et Ord-objekt
		Ord ord = new Ord();

		ord.setFil(fil);
		// start en tidtaker
		Long start = System.currentTimeMillis();

		ord.setFil1("alfabetisk_" + fil);
		ord.setFil2("antall_" + fil);

		// Lag to Maps hvor vi kan mellomlagre ordene i tekstfilen vi leser inn
		Map<String, Integer> tre = ord.lesFil(ord.getFil());
		Map<String, Integer> sortert = ord.sorterFil(tre);

		// Skriv fil med ord i alfabetisk orden
		ord.skrivfil(ord.getFil1(), tre);

		// Skriv fil med ord sortert etter antall
		ord.skrivfil(ord.getFil2(), sortert);

		Long stop = System.currentTimeMillis();
		Double tid = (stop - start) / 1000.0;

		System.out.println("Filene "+ord.getFil1()+" og "+ord.getFil2()+" ble skrevet på "+tid+" sekunder");
		
	}

}
