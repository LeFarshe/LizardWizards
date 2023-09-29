package com.lizardwizards.lizardwizards.server;

import com.lizardwizards.lizardwizards.core.Utils;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.ServerSocket;

public class LizardWizardsServer {

    public static void main(String[] args) {
        Thread thread = null;
        for (int i = 6123; i < 6200; i ++){
            try (ServerSocket serverSocket = new ServerSocket(i)) {
                Server server = new Server(serverSocket);
                thread = new Thread(server);
                thread.start();
                thread.join();
                break;
            } catch (IOException e) {
                System.out.printf("Unable to use port %d: %s%n", i, e.getMessage());
            } catch (InterruptedException e) {
                System.out.println("Server stopped");
            }
        }
        if (thread == null)
            System.out.println("Server not started");
    }
}