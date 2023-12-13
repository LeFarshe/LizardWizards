package com.lizardwizards.lizardwizards.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CommandInterpreter {
    public static boolean active = true;
    public static void startInterpreter() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (active) {
                var input = reader.readLine().split(" +", 2);
                for (var command : ServerCommands.values()) {
                    if (command.checkMatch(input[0])) {
                        if (input.length > 1)
                            command.execute(input[1].split(" +"));
                        else
                            command.execute();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
