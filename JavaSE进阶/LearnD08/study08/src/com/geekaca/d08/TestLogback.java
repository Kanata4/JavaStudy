package com.geekaca.d08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {
    public static final Logger LOGGER = LoggerFactory.getLogger(TestLogback.class);
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            LOGGER.info("这是一个info信息");
            LOGGER.debug("这是一条debug信息");
            LOGGER.error("这是一条error信息");
        }

    }
}
