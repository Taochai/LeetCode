package log;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * slf4j + logback
 * logback.xml
 * */
public class Slf4jDemo {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Slf4jDemo.class);

        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
}
