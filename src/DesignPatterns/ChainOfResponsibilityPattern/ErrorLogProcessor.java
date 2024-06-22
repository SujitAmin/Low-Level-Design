package DesignPatterns.ChainOfResponsibilityPattern;

public class ErrorLogProcessor extends AbstractLogProcessor{
    ErrorLogProcessor(AbstractLogProcessor abstractLogProcessor) {
        super(abstractLogProcessor);
    }

    @Override
    public boolean canHandle(String message) {
        return message.contains("ERROR");
    }

    @Override
    public void handle(String message) {
        System.out.println("ErrorLogProcessor handle: " + message);
    }
}
