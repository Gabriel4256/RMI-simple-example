package rdate;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Locale;

public interface RemoteDate extends Remote {
    Date remoteDate() throws RemoteException;
    String regionalDate(Locale language) throws RemoteException;
}
