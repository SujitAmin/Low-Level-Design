package DesignPatterns.ChainOfResponsibilityPattern;

public class DebugLogProcessor extends AbstractLogProcessor{
    DebugLogProcessor(AbstractLogProcessor abstractLogProcessor) {
        super(abstractLogProcessor);
    }

    @Override
    public boolean canHandle(String message) {
        return message.contains("DEBUG");
    }

    @Override
    public void handle(String message) {
        System.out.println("DEBUG: " + message);
    }
}
