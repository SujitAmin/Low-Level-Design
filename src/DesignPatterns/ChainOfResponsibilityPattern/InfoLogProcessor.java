package DesignPatterns.ChainOfResponsibilityPattern;

public class InfoLogProcessor extends AbstractLogProcessor{
    InfoLogProcessor(AbstractLogProcessor abstractLogProcessor) {
        super(abstractLogProcessor);
    }

    @Override
    public boolean canHandle(String message) {
        return message.contains("INFO");
    }

    @Override
    public void handle(String message) {
        System.out.println("InfoLogProcessor handle: " + message);
    }
}
