package ru.job4j.io;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        String n = "Hello log";
        int i = 14;
        char cr = 'c';
        float f = 3.14f;
        double d = 3.14;
        long l = 100000000L;
        boolean b = true;
        short s = 6;
        LOG.debug("String n = {}, Char cr = {}, Float = {}, Double = {}, Long l = {}, Boolean = {}, Short s = {}",
                n, i, cr, f, d, l, b, s);
    }
}