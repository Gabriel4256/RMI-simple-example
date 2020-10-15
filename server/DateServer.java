package server;

import rdate.RemoteDate;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DateServer {

    private static final String BIND_NAME = "rs";

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
//            DateServant aRemoteDate = new DateServant();
//            RemoteDate stub = (RemoteDate) UnicastRemoteObject.exportObject(aRemoteDate, 0);
           Registry registry = LocateRegistry.getRegistry(2001);
           registry.bind(BIND_NAME, (RemoteDate) new DateServant());
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
