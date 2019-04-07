package no.itfakultetet.java;

public class ServerApp {

	public static void main(String[] args) {	
		
	if(args.length==3) {
		String navn = args[0];
		int port = Integer.parseInt(args[1]);
		int antall = Integer.parseInt(args[1]);
		Server s1 = new Server(port, antall, navn);
		s1.run();
	} else {
		System.out.println("Bruk: java -jar server.jar <navn> <port> <antall tilkoblinger>");
	}
	
	
	}

}
