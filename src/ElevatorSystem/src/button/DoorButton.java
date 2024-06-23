package button;

public class DoorButton extends Button {
    private boolean status;

    public DoorButton() {
        this.status = false;
    }

    @Override
    public void pressDown() {
        status = true;
    }

    @Override
    public boolean isPressed() {
        return status;
    }

    public void reset() {
        status = false;
    }
}
