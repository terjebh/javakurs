package no.itfakultetet.java;

import java.sql.ResultSet;

public class App {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Bruk: java -jar kontakter.jar <csv> <html> ");
		} else {
			String filtype = args[0].strip();
			GetData data = new GetData();
			ResultSet rad = data.hentRader();
			if (filtype.equals("html")) {
				String tabell = data.lagTabellHTML(rad);
				data.lagFil(tabell, "kontakter.html");
				System.out.println("Data er lagret i filen: kontakter.html");
			} else if (filtype.equals("csv")) {
				String tabell = data.lagTabellCSV(rad);
				data.lagFil(tabell, "kontakter.csv");
				System.out.println("Data er lagret i filen: kontakter.csv");
			} else {
				System.out.println("Filtype " + filtype + " ukjent...");
			}
		}
	}

}
