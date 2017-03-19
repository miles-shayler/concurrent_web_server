import server.*;

import java.util.Scanner;

public class ServerCtl {

    private boolean stopCtl = false;

    private Server server;

    public ServerCtl() {

    }

    private void readUserInput() {
        Scanner scanner = new Scanner(System.in);
        while (!stopCtl) {
            System.out.print("ctl: ");
            try {
                String input = scanner.nextLine();
                evalUserInput(input);
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }
    }

    private void evalUserInput(String input) {
        if (input.equals("quit") || input.equals("q")) {
            stopCtl = true;
        } else if (input.equals("single start")) {
            System.out.println("Starting Single Threaded Server");
            server = new SingleThreadServer();
            new Thread(server).start();
        } else if (input.equals("multi start")) {
            //ToDo: start up multithreaded server
        } else if (input.equals("pool start")) {
            //ToDo: start up thread pool server
        } else if (input.equals("h")) {
            System.out.println("Usage: (single/multi/pool) (start/quit)");
        } else if (input.equals("stop")) {
            server.setIsRunning(false);
        } else {
            System.out.println("ctl: type h for help");
        }
    }

    public static void main(String args[]) {
        ServerCtl ctl = new ServerCtl();
        ctl.readUserInput();
    }
}
