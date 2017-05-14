package bubble.bobble.models;


import javax.vecmath.Vector2f;
import java.awt.*;
import java.util.ArrayList;
import static bubble.bobble.Util.MyVector.*;

public class Bubble  implements GameEntity {

    public static final int RADIUS = 25;

    private Color color;

    private Vector2f velocity;

    private Vector2f position;


    private ArrayList<Bubble> parents = new ArrayList<>();

    private ArrayList<Bubble> children = new ArrayList<>();


    public Bubble(Vector2f velocity, Vector2f position, Color color) {
        this.velocity = cloneVec(velocity);
        this.position = cloneVec(position);
        this.color = color;
    }

    public void addParent(Bubble bubble) {
        this.parents.add(bubble);
    }

    public void addChild(Bubble bubble) {
        this.children.add(bubble);
    }

    public Vector2f getPosition(){
        return cloneVec(position);
    }

    /**
     * This should draw the bubble
     * takes in anything it needs to accomplish this
     */
    public void draw(Graphics2D cxt) {
        cxt.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        cxt.setColor(this.color);
        cxt.fillOval(((int) this.position.getX()), ((int) this.position.getY()), RADIUS*2, RADIUS*2);
        for(Bubble child: this.children) {
            cxt.setColor(Color.black);
            cxt.drawLine((int)this.position.getX() + RADIUS, (int)this.position.getY()+ RADIUS, (int)child.getPosition().getX()+ RADIUS, (int)child.getPosition().getY()+ RADIUS);
        }
    }

    public void update(long dt) {
        if (velocity.lengthSquared() == 0.0f) return;
        if (position.getY() <= 0) return;

        position.add(scaleVec(velocity, dt/1_000_000_000f));
    }
}
