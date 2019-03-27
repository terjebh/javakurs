package no.itfakultetet.no;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Ord {

	String fil, fil1, fil2;

	public String getFil() {
		return fil;
	}

	public void setFil(String fil) {
		this.fil = fil;
	}

	public String getFil1() {
		return fil1;
	}

	public void setFil1(String fil1) {
		this.fil1 = fil1;
	}

	public String getFil2() {
		return fil2;
	}

	public void setFil2(String fil2) {
		this.fil2 = fil2;
	}

	public Map<String, Integer> lesFil(String fil) {

		TreeMap<String, Integer> tre1 = new TreeMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fil))) {

			String input;

			while ((input = br.readLine()) != null) {

				String ord[] = input.split("[?\t()*.,;:!'“”\n\r{} ]");

				for (int i = 0; i < ord.length; i++) {

					ord[i] = ord[i].toLowerCase();

					if (tre1.containsKey(ord[i])) {
						tre1.put(ord[i], tre1.get(ord[i]) + 1);
					} else {
						tre1.put(ord[i], 1);
					}
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return tre1;
	}

	// Metode for å sortere en Map<String, Integer>
	public Map<String, Integer> sorterFil(Map<String, Integer> tre2) {

		// Sortere tre2 etter antall (istedenfor etter ord alfabetisk)
		Map<String, Integer> sortertMap = new LinkedHashMap<>();

		tre2.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
				.forEachOrdered(x -> sortertMap.put(x.getKey(), x.getValue()));

		return sortertMap;

	} // Slutt på sorteringsmetode

	 // Metode for å skrive filer
    public void skrivfil(String utfil, Map<String, Integer> tre) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(utfil))) {

            bw.write("ord,antall"+System.getProperty("line.separator").toString());
            tre.forEach((k, v) -> {
                try {
                    if (!k.matches("[0-9].*") && !k.isEmpty()) {
                        bw.write("\"" + k + "\"" + "," + v + System.getProperty("line.separator").toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end skrivfil
	
}
