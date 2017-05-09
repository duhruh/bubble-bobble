package bubble.bobble.models;

import javax.vecmath.Vector2f;
import java.awt.*;
import static bubble.bobble.Util.MyVector.*;

/**
 * Created by daniel on 5/6/2017.
 */
public class Wall implements GameEntity {
    private Vector2f position;
    private Vector2f size;
    private Color color;

    public Wall(Vector2f position, Vector2f size, Color color) {
        this.position = cloneVec(position);
        this.size = cloneVec(size);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D cxt) {
        cxt.fillRect((int) position.getX(), (int) position.getY(), (int) size.getX(), (int) size.getY());
    }

    @Override
    public void update(long dt) {

    }
}
