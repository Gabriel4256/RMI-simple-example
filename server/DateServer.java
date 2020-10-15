package server;

import rdate.RemoteDate;

import java.rmi.Naming;

public class DateServer {

    private static final String BIND_NAME = "rs";

    public static void main(String[] args) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
//            DateServant aRemoteDate = new DateServant();
//            RemoteDate stub = (RemoteDate) UnicastRemoteObject.exportObject(aRemoteDate, 0);
//            Registry registry = LocateRegistry.getRegistry();
//            registry.bind("rs", aRemoteDate);
            Naming.rebind(BIND_NAME, (RemoteDate) new DateServant());
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
