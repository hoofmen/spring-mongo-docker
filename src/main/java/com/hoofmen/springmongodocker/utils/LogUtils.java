package com.hoofmen.springmongodocker.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogUtils {
    public static Logger buildLogClient(Class<?> clazz){
        return LoggerFactory.getLogger(clazz);
    }

    public static String getprintStackTrace(Logger logger, Exception ex){
        if(logger.isDebugEnabled())
        {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            return sw.toString();
        }
        return "";
    }
}
