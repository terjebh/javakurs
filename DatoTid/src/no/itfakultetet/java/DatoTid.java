package no.itfakultetet.java;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DatoTid {

	public static void main(String[] args) {

		LocalDate idag = LocalDate.now();
		System.out.println(idag);

		LocalDateTime naa = LocalDateTime.now();
		System.out.println(naa);

		LocalDate generalforsamling = LocalDate.of(2019, 2, 23);
		LocalDate utsattGeneralforsamling = generalforsamling.plusDays(25);

		System.out
				.println("Generalforsamlingen utsettes fra: " + generalforsamling + " til: " + utsattGeneralforsamling);

		// På norsk
		Locale bokmaal = new Locale("nb", "NO");
		Locale nynorsk = new Locale("nn", "NO");
		LocalDate kursstart = LocalDate.parse("2019-03-25");

		String kursstartNB = kursstart.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", bokmaal));
		String kursstartNN = kursstart.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM, yyyy", nynorsk));

		System.out.println("Kurset starter på : " + kursstartNB);
		System.out.println("Kurset startar på : " + kursstartNN);

	}

}
