package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;

public class UndoPacket extends SentServerData {
    private final boolean redo;
    private SentServerData undoneCommand;

    public UndoPacket() { // THIS THING SHOULD NEVER BE USED
        super(SentDataType.Undo); // IF YOU THINK YOU MIGHT NEED TO USE THIS, YOU DON'T
        redo = false; // IF THIS WASN'T A REQUIREMENT, THIS THING WOULD NOT EXIST
    }

    public UndoPacket(boolean redo) {
        super(SentDataType.Undo);
        this.redo = redo;
    }

    @Override
    public void execute() {
        var cch = ClientConnectionHandler.CurrentHandler;
        undoneCommand = cch.tryUndo(redo);
        addToHistory();
    }

    @Override
    public void undo() {
        undoneCommand.execute();
    }
}
