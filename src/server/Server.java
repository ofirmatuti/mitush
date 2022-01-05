package server;

import commands.AbstractCommand;
import commands.AlgorithmSettingsCommand;
import commands.AnomalyDetectionCommand;
import commands.UploadCommand;
import java.util.*;

public class Server {

    private Map<Integer, AbstractCommand> commandMap;

    public void start(){
        // getting the first option from the user
        int option = mainMenuInitialization();

        while ( option != 6 ){
            // getting command by option
            AbstractCommand command = commandMap.get(option);
            //executing the command
            command.execute();

            //return to main menu
            option = mainMenuInitialization();
        }
    }

    public int mainMenuInitialization(){
        if(commandMap == null) {
            commandMap = new HashMap<>();
            commandMap.put(1, new UploadCommand());
            commandMap.put(2, new AlgorithmSettingsCommand());
            commandMap.put(3, new AnomalyDetectionCommand());
        }
        StringBuilder sb = new StringBuilder("Welcome to the anomaly detection server. \nPlease choose an option:\n");

        for( Integer key : commandMap.keySet() ){
            String description = commandMap.get(key).getDescription();
            sb.append(key).append(". ").append(description);
            if(key == commandMap.size()){
                break;
            }
            sb.append("\n");
        }

        System.out.println(sb);

        return scanWithRetries();
    }

    private int scanWithRetries(){
        Scanner scanner = new Scanner(System.in);
        String message = "Invalid Input. please choose option again:";
        boolean done = false;
        int res = 0;
        while(!done){
            try {
                res = scanner.nextInt();
                if( res > 0 && res <=commandMap.size() ){
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