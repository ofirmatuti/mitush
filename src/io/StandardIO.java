package io;

import java.util.Scanner;

public class StandardIO implements DefaultIO {

    @Override
    public String read() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        //assuming the line has at least 1 line
        String line = scanner.nextLine();
        while(!line.equals("done")){
            sb.append(line).append("\n");
            line = scanner.nextLine();
        }
        return sb.toString();
    }

    @Override
    public void write(String s) {
        System.out.println(s);
    }
}
