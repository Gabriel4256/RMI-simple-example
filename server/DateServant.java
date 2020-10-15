package server;

import rdate.RemoteDate;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DateServant extends UnicastRemoteObject implements RemoteDate {


    protected DateServant() throws RemoteException {
    }

    @Override
    public Date remoteDate() throws RemoteException {
        return new Date();
    }

    @Override
    public String regionalDate(Locale language) throws RemoteException {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, language);
        return df.format(new Date());
    }
}
