package log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class JDKLogDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();
//        Logger logger = Logger.getLogger("test name");
//        Logger logger = Logger.getLogger(JDKLogDemo.class.getName());

//        Handler console = new ConsoleHandler();
//        console.setLevel(Level.FINEST);
//        logger.addHandler(console);

        logger.setLevel(Level.FINEST);

        logger.severe("process will be terminated...");
        logger.warning("memory is running out...");
        logger.info("start process...");
        logger.fine("ignored.");
        logger.finest("finest msg");
    }
}
