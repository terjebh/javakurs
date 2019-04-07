package no.itfakultetet.java;

public class ClientApp {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Bruk: java -jar klient.jar <host> <port> <ditt navn>");
			System.exit(-1);
		}
		String host = args[0];
		Integer port = Integer.parseInt(args[1]);
		String navn = args[2];

		new Thread(new Client(host, navn, port)).start();

	}

}
