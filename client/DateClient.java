package client;

// 실행 커맨드
// 클라이언트 : java -Djava.security.policy=server.policy client.DateClient
// 서버 : java -Djava.security.policy=server.policy -Djava.rmi.server.codebase=file://C:\Users\tla42\IdeaProjects\RMI-remote-Data-Service\out\production\RMI-Remote-Data-Service\ server.DateServer
// rmiregistry: start rmiregistry -J-Djava.rmi.server.codebase=file:C:\Users\tla42\IdeaProjects\RMI-remote-Data-Service\out\production\RMI-Remote-Data-Service\

import rdate.RemoteDate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;
import java.util.Locale;

public class DateClient {
    private static void printOptions(){
        while(true) {

        }
    }

    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        String host = (args.length < 1) ? null : args[0];
        RemoteDate aRemoteDate = null;

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            // aRemoteDate = (RemoteDate) Naming.lookup("rs");
            aRemoteDate = (RemoteDate) registry.lookup("rs");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.println("Choose the option");
                System.out.println("1. get server date & time");
                System.out.println("2. get local date & time");
                try {
                    while (true) {
                        String input = reader.readLine();
                        if (input.trim().equals("1")) {
                            Date now = aRemoteDate.remoteDate();
                            System.out.println("The date is " + now.toString());
                            break;
                        } else if (input.trim().equals("2")) {
                            while(true) {
                                System.out.println("Choose the option");
                                System.out.println("1. get Korea local time");
                                System.out.println("2. get US local time");

                                input = reader.readLine();
                                if (input.trim().equals("1")) {
                                    String koreanTime = aRemoteDate.regionalDate(Locale.KOREA);
                                    System.out.println("The current date of korea is " + koreanTime);
                                    break;
                                } else if (input.trim().equals("2")) {
                                    String usTime = aRemoteDate.regionalDate(Locale.US);
                                    System.out.println("The current date of usa is " + usTime);
                                    break;
                                } else {
                                    System.out.println("Invalid choice, try again");
                                }
                            }
                            break;
                        } else {
                            System.out.println("Invalid choice, try again");
                        }
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        try {
////            Registry registry = LocateRegistry.getRegistry(host);
////            aRemoteDate = (RemoteDate) registry.lookup("rs");
//              aRemoteDate = (RemoteDate) Naming.lookup("rs");
//            try {
//                Date now = aRemoteDate.remoteDate();
//                System.out.println("The date is " + now.toString());
//                String koreanTime = aRemoteDate.regionalDate(Locale.KOREA);
//                System.out.println("The current date of korea is " + koreanTime);
//                String usaTime = aRemoteDate.regionalDate(Locale.US);
//                System.out.println("The current date of usa is " + usaTime);
//            } catch (RemoteException e){
//                System.out.println(e.getMessage());
//            }
//        } catch (Exception e){
//            System.out.println("Client: " + e.getMessage());
//        }
    }

}
