package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
    private final ServerSocket serverSocket;
    private final Session session;

    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                if (session.acceptingConnections()) {
                    // Start handling player
                }
                else {
                    // Send error message
                }
            }
        }
        catch (IOException e) {
            try {
                e.printStackTrace();
                stopServer();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public Server(ServerSocket serverSocket){
        this.session = new Session();
        this.serverSocket = serverSocket;
    }

    public void stopServer() throws IOException {
        serverSocket.close();
    }
}
