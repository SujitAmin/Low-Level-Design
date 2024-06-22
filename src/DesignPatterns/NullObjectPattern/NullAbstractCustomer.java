package DesignPatterns.NullObjectPattern;

public class NullAbstractCustomer extends AbstractCustomer {


    @Override
    public boolean isNil() {
        return true;
    }

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }
}
