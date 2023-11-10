package com.lizardwizards.lizardwizards.core.communication;

import com.lizardwizards.lizardwizards.client.ClientConnectionHandler;

public class UndoPacket extends SentServerData {
    private final boolean redo;
    private SentServerData undoneCommand;

    /**
     * THIS THING SHOULD NEVER BE USED.
     * IF YOU THINK YOU MIGHT NEED TO USE THIS, YOU DON'T.
     * IF THIS WASN'T A REQUIREMENT, THIS THING WOULD NOT EXIST.
     */
    public UndoPacket() {
        super(SentDataType.Undo);
        redo = false;
    }

    /**
     * THIS THING SHOULD NEVER BE USED.
     * IF YOU THINK YOU MIGHT NEED TO USE THIS, YOU DON'T.
     * IF THIS WASN'T A REQUIREMENT, THIS THING WOULD NOT EXIST.
     */
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
