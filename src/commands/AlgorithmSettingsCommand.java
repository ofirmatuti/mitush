package commands;

import java.util.Scanner;

public class AlgorithmSettingsCommand extends AbstractCommand{

    private double threshold;

    public AlgorithmSettingsCommand(){
        threshold = 0.9;
    }

    @Override
    public String getDescription() {
        return "algorithm settings command";
    }

    @Override
    public void execute() {
        System.err.println("Executing "+ getDescription() + ":");
        System.out.println("The current correlation threshold is " + threshold);
        System.out.println("type a new threshold");
        this.threshold  = getThresholdRetries();
    }

    private double getThresholdRetries(){
        Scanner scanner = new Scanner(System.in);
        String message = "Please choose a value between 0 and 1.";
        boolean done = false;
        double res = 0;
        while(!done){
            try {
                res = scanner.nextDouble();
                if( res > 0 && res < 1 ){
                    done = true;
                } else System.out.println(message);
            } catch ( Exception e) {
                System.out.println(message);
                scanner.nextLine();
            }
        }
        return res;
    }
}
