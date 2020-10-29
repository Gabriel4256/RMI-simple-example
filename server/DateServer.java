package server;

import rdate.RemoteDate;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DateServer {

    private static final String BIND_NAME = "rs";

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // System.setProperty("java.rmi.server.hostname","192.168.1.2");
           String port = (args.length < 1) ? 1099 : args[0]; 
           DateServant aRemoteDate = new DateServant();
           RemoteDate stub = (RemoteDate) UnicastRemoteObject.exportObject(aRemoteDate, 1100);
           Registry registry = LocateRegistry.getRegistry(port);
           registry.rebind(BIND_NAME, stub);
            // Naming.rebind(BIND_NAME, (RemoteDate) new DateServant());
            System.out.println("[RMI-SERVER] START");
            while(true){

            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try { Naming.unbind(BIND_NAME); } catch (Exception e) {};
        }

        System.out.println("[RMI-SERVER] EXIT");
    }

    public DateServer() {

    }
}
