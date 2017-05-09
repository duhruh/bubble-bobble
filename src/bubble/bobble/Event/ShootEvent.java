package bubble.bobble.Event;

import javax.vecmath.Vector2f;
import static bubble.bobble.Util.MyVector.*;

/**
 * Created by daniel on 5/6/2017.
 */
public class ShootEvent extends Event {
    public final String name = "ShootEvent";

    private Vector2f pos;
    private Vector2f vel;

    public ShootEvent(Vector2f pos, Vector2f vel) {
        this.pos = cloneVec(pos);
        this.vel = cloneVec(vel);
    }

    public Vector2f getPos() { return cloneVec(pos); }
    public Vector2f getVel() { return cloneVec(vel); }
}
