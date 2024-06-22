package DesignPatterns.ChainOfResponsibilityPattern;

public class Client {
    public static void main(String[] args) {
        // Create the chain of responsibility
        AbstractLogProcessor logger = new InfoLogProcessor(
                new DebugLogProcessor(
                        new ErrorLogProcessor(null)
                )
        );

        // Log messages
        logger.log("INFO: This is an INFO log.");
        logger.log("DEBUG: This is a DEBUG log.");
        logger.log("ERROR: This is an ERROR log.");
        logger.log("This is a general log."); // Will not be processed by any specific handler
    }
}
