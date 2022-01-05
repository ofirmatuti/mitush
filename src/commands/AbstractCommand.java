package commands;

import io.DefaultIO;

public abstract class AbstractCommand implements ICommand {

    protected String description;
    protected DefaultIO io;

    public abstract String getDescription();

    public DefaultIO getIo() {
        return io;
    }

    public void setIo(DefaultIO io) {
        this.io = io;
    }
}