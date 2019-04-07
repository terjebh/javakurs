package no.itfakultetet.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class Server implements Runnable {

	private int port, connNo;
	private String serverName;

	public Server(int port, int connNo, String serverName) {
		super();
		this.port = port;
		this.connNo = connNo;
		this.serverName = serverName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getConnNo() {
		return connNo;
	}

	public void setConnNo(int connNo) {
		this.connNo = connNo;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	
	 
        @Override
        public void run() {
 
            ServerSocket serverSocket = null;
 
            try {
                serverSocket = new ServerSocket(port);
                serverSocket.setSoTimeout(0);
                System.out.println("Server er startet...");
                while (true) {
                    try {
                        Socket clientSocket = serverSocket.accept();
 
                        BufferedReader inputReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
 
                        System.out.println(inputReader.readLine());
 
                    } catch (SocketTimeoutException e) {
                        e.printStackTrace();
                    }
                }
 
            } catch (IOException e1) {
                e1.printStackTrace();
            } finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


}
	

