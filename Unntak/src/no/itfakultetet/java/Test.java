package no.itfakultetet.java;

import java.io.IOException;

public class Test {

	public void run(int i) throws IOException {
		
		if (i==0) {
			System.out.println("Dette gikk bra");
		} else {
			throw new IOException("Testen feilet! Metoden ble kalt med feil parameter: "+i+". Skulle vært 0"); 	
		}		

	}

}
