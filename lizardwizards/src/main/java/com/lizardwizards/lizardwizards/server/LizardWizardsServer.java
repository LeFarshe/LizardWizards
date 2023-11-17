package com.lizardwizards.lizardwizards.server;

import java.io.IOException;
import java.net.ServerSocket;

public class LizardWizardsServer {
    public static boolean isRunning = false;

    public static void main(String[] args) {
        isRunning = true;
        Thread thread = null;
        for (int i = 6123; i < 6200; i ++){
            try (ServerSocket serverSocket = new ServerSocket(i)) {
                Server server = new Server(serverSocket);
                thread = new Thread(server);
                thread.start();
                System.out.printf("using port %d\n", i);
                thread.join();
                break;
            } catch (IOException e) {
                System.out.printf("Unable to use port %d: %s%n\n", i, e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Server stopped\n");
            }
        }
        if (thread == null)
            System.out.println("Server not started\n");
    }
}