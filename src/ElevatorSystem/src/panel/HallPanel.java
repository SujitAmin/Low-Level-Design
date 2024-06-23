package panel;

import button.Direction;
import button.HallButton;

public class HallPanel {
    private HallButton up;
    private HallButton down;

    public HallPanel() {
        this.up = new HallButton(Direction.UP);
        this.down = new HallButton(Direction.DOWN);
    }

    public HallButton getUp() {
        return up;
    }

    public HallButton getDown() {
        return down;
    }
}
