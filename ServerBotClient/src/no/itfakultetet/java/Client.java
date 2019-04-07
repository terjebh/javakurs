package no.itfakultetet.java;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client implements Runnable {

	private String host, navn;
	private Integer port;
	private Scanner sc1 = new Scanner(System.in);

	public Client(String host, String navn, Integer port) {
		super();
		this.host = host;
		this.navn = navn;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public void run() {

		Socket socket = null;
		try {

			socket = new Socket(host, port);

			PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);

			outWriter.println(navn+" kobler seg til...");

				
			while(sc1.hasNext()) {
				outWriter.println(navn+": "+sc1.nextLine());	
				
			}
			
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (socket != null)
					socket.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
}
