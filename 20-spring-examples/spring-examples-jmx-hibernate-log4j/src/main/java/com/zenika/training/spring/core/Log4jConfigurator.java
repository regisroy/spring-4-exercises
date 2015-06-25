package com.zenika.training.spring.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@ManagedResource(objectName = "Spring-example:type=log4j,name=log4jConfigurator",
        description = "description")
public class Log4jConfigurator implements Log4jConfiguratorMXBean {

    @ManagedOperation(description = "Get list of Loggers")
    public List<String> getLoggers() {
        List<String> list = new ArrayList<String>();
        for (Enumeration e = LogManager.getCurrentLoggers();
             e.hasMoreElements(); ) {

            Logger log = (Logger) e.nextElement();
            if (log.getLevel() != null) {
                list.add(log.getName() + " = " + log.getLevel().toString());
            }
        }
        return list;
    }

    @ManagedOperation(description = "Get log level for a logger")
    public String getLogLevel(String logger) {
        String level = "unavailable";

        if (StringUtils.isNotBlank(logger)) {
            Logger log = Logger.getLogger(logger);

            if (log != null) {
                level = log.getLevel().toString();
            }
        }
        return level;
    }

    @ManagedOperation(description = "Set a log level for a logger")
    public void setLogLevel(String logger, String level) {
        if (StringUtils.isNotBlank(logger) && StringUtils.isNotBlank(level)) {
            Logger log = Logger.getLogger(logger);

            if (log != null) {
                log.setLevel(Level.toLevel(level.toUpperCase()));
            }
        }
    }

}
