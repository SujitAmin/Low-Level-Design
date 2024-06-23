package button;

public class HallButton extends Button{
    private boolean status;
    private Direction buttonSign;

    public HallButton(Direction buttonSign) {
        this.status = false;
        this.buttonSign = buttonSign;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    @Override
    public void pressDown() {
        status = true;
        //buttonSign = Direction.DOWN;
    }

    public void reset() {
        status = false;
    }
    public Direction getButtonSign() {
        return buttonSign;
    }
}
