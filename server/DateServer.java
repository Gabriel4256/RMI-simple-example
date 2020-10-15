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
           DateServant aRemoteDate = new DateServant();
           RemoteDate stub = (RemoteDate) UnicastRemoteObject.exportObject(aRemoteDate, 2002);
           Registry registry = LocateRegistry.getRegistry(2001);
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
