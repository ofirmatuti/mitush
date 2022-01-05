package commands;

import io.StandardIO;

public class UploadCommand extends AbstractCommand {

    public UploadCommand(){
        this.io = new StandardIO();
    }

    @Override
    public void execute() {
        System.err.println("Executing "+ getDescription() +":");

        System.out.println("please upload your local train CSV file.");
        String trainData = io.read();
        io.write("Upload complete.");

        System.out.println("please upload your local test CSV file.");
        String testData = io.read();
        io.write("Upload complete.");

    }

    @Override
    public String getDescription() {
        return "upload command";
    }

}