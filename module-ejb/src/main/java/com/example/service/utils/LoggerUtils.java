package com.example.service.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerUtils {

    public static synchronized Logger getLogger(Class<?> cl) {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(true);
        return ctx.getLogger(cl);
    }

    public static synchronized void close() {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(true);
        Configurator.shutdown(ctx);
    }

    public static String getLoggerPropVal(String propName) {
        LoggerContext ctx = (LoggerContext) LogManager.getContext();
        Configuration cfg = ctx.getConfiguration();
        return cfg.getStrSubstitutor().getVariableResolver().lookup(propName);
    }
}
