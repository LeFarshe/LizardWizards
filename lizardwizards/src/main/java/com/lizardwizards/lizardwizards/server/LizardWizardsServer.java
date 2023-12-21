package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.net.ServerSocket;

public class LizardWizardsServer {
    public static boolean isRunning = false;
    static Thread thread = null;

    public static void main(String[] args) throws InterruptedException {
        startServer();

        CommandInterpreter.startInterpreter();

        thread.join();
    }

    public static void startServer() {
        isRunning = true;
        if (thread != null) {
            thread.interrupt();
            thread = null;
        }
        for (int i = 6123; i < 6200; i ++){
            try {
                ServerSocket serverSocket = new ServerSocket(i);
                Server server = new Server(serverSocket);
                thread = new Thread(server);
                System.out.printf("Using port %d\n", i);
                thread.start();
                return;
            } catch (IOException e) {
                System.out.printf("Unable to use port %d: %s%n\n", i, e.getMessage());
            }
        }
        if (thread == null) {
            System.out.println("Server not started\n");
        }
    }
}