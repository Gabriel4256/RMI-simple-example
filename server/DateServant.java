package server;

import rdate.RemoteDate;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.time.format.FormatStyle;
import java.time.format.DateTimeFormatter;
import java.time.ZonedDateTime;

public class DateServant implements RemoteDate {


    protected DateServant() throws RemoteException {
    }

    @Override
    public Date remoteDate() throws RemoteException {
        return new Date();
    }

    @Override
    public String regionalDate(Locale language) throws RemoteException {
        ZonedDateTime now = ZonedDateTime.now();
        return now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(language));
        // System.out.println(now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.US)));
        // DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, language);
        // return df.format(new Date());
    }
}
