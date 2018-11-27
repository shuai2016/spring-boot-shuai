package com.shuai.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HelloWorld
 *
 * @author shuai
 * @date 2018/11/27
 */
public class HelloWorld {
  public static void main(String[] args) {
    Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    logger.info("Hello World");
  }
}