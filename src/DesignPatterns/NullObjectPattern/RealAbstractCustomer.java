package DesignPatterns.NullObjectPattern;

public class RealAbstractCustomer extends AbstractCustomer {

    public RealAbstractCustomer(String name) {
        this.name = name;
    }
    @Override
    public boolean isNil() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }
}
