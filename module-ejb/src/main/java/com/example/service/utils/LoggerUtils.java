package com.example.service.utils;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.LoggerContext;

@Log4j2
public class LoggerUtils {

    public static synchronized Logger getLogger(Class<?> cl) {
        LoggerContext ctx = LogManager.getContext(true);
        return ctx.getLogger(cl);
    }

    public static String getLoggerPropVal(String propName) {
//        LoggerContext ctx = LogManager.getContext();
//        Configuration cfg = ctx.getConfiguration();
//        return cfg.getStrSubstitutor().getVariableResolver().lookup(propName);
        return "LASD";
    }
}
