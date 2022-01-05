package commands;

public class AnomalyDetectionCommand  extends AbstractCommand {

    @Override
    public void execute() {
        System.err.println("Executing " + getDescription() + ":");
    }

    @Override
    public String getDescription() {
        return "anomaly detection command";
    }
}
