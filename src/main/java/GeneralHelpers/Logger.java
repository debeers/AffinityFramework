package GeneralHelpers;

import org.slf4j.LoggerFactory;

public class Logger {

    private org.slf4j.Logger LOG = LoggerFactory.getLogger("affinity.testlogger");

    public void info(String message) {
        LOG.info(message);
    }

    public void info(String message, Throwable e) {
        LOG.info(message, e);
    }

    public void info(StringBuilder message) {
        LOG.info(message.toString());
    }

    public void debug(String message) {
        LOG.debug(message);
    }

    public void trace(String message) {
        LOG.trace(message);
    }

    public void warn(String message) {
        LOG.warn(message);
    }

    public void error(String message) {
        LOG.error(message);
    }

    public void error(String message, Throwable e) {
        LOG.error(message, e);
    }
}