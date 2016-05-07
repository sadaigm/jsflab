package com.sa.tcm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.sa.tcm.entity.Runner;

@ManagedBean(name="UtilMethod")
@ApplicationScoped
public class UtilMethod {
	public Date getCurrentTimeStamp()
    {
         SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss",Locale.ENGLISH);
     Date now = new Date();
     String strDate = formatter.format(now);
     Date date = null;
     formatter.setTimeZone(TimeZone.getTimeZone("IST"));
    try {
         
      date  = formatter.parse(strDate);
    } catch (ParseException ex) {
        Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
    }
    return date;
    }
	
	public Date getCurrentDate()
    {
         SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
     Date now = new Date();
     String strDate = formatter.format(now);
     System.out.println(strDate);
     Date date = null;
     formatter.setTimeZone(TimeZone.getTimeZone("IST"));
    try {
         
      date  = formatter.parse(strDate);
    } catch (ParseException ex) {
        Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
    }
    return date;
    }
}
