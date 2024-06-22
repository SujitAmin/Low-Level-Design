package DesignPatterns.ChainOfResponsibilityPattern;

public abstract class AbstractLogProcessor {
    public AbstractLogProcessor nextProcessor;

    AbstractLogProcessor(AbstractLogProcessor abstractLogProcessor) {
        this.nextProcessor = abstractLogProcessor;
    }

    public void log(String message) {
        if (canHandle(message)) {
            handle(message);
        } else if (nextProcessor != null) {
            nextProcessor.log(message);
        }
    }

    public abstract boolean canHandle(String message);
    public abstract void handle(String message);
}
