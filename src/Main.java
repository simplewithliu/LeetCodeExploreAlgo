package com.leetcode.explore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Start process {}...", Main.class.getName());
        logger.debug("stack...", new Exception());
        int i = 45;
        logger.debug("num is {}", i);
        logger.info("Process end.");
    }
}
