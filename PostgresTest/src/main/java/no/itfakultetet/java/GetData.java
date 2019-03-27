package no.itfakultetet.java;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetData {

	public ResultSet hentRader() {
		ResultSet resultat = null;
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://s1.itfakultetet.no:5432/kurs", "kurs",
				"kurs123")) {
			Statement st = con.createStatement();
			resultat = st.executeQuery("Select fornavn,etternavn,epost,tel from kontakter");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	public String lagTabellCSV(ResultSet rad) {
		StringBuilder tabell = new StringBuilder();
		tabell.append("Navn,Epost,Telefon");
		tabell.append(System.getProperty("line.separator").toString());
		try {
			while (rad.next()) {
				tabell.append(rad.getString("fornavn") + " " + rad.getString("etternavn") + ",");
				tabell.append(rad.getString("epost") + "," + rad.getString("tel"));
				tabell.append(System.getProperty("line.separator").toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabell.toString();
	}

	public String lagTabellHTML(ResultSet rad) {
		StringBuilder tabell = new StringBuilder();
		tabell.append("<table border=2>\n");
		tabell.append("<tr><th>Navn</th><th>Epost</th><th>Telefon</th></tr>\n");
		try {
			while (rad.next()) {
				tabell.append("<tr>");
				tabell.append("<td>" + rad.getString("fornavn") + " " + rad.getString("etternavn") + "</td>");
				tabell.append("<td>" + rad.getString("epost") + "</td><td>" + rad.getString("tel") + "</td>");
				tabell.append("</tr>\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tabell.append("</table>");
		return tabell.toString();
	}
	
	
	// Skriver hva som helst til en fil.
	public void lagFil(String tabell, String filnavn) {
		FileWriter utfil;
		try {
			utfil = new FileWriter(filnavn);
			utfil.write(tabell);
			utfil.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
