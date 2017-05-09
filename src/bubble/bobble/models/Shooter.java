package bubble.bobble.models;

import bubble.bobble.Event.EventBus;
import bubble.bobble.Event.ShootEvent;

import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import static bubble.bobble.Util.MyVector.*;

/**
 * Created by duhruh on 5/6/2017.
 */
public class Shooter implements GameEntity, MouseListener, MouseMotionListener {

    private Vector2f position;
    private Vector2f aim;
    private float power;

    public Shooter(Vector2f position, Vector2f aim, float power) {
        this.position = position;
        this.aim = aim;
        this.power = power;
    }

    public void draw(Graphics2D cxt) {
        Vector2f a = cloneVec(aim);
        a.scale(this.power);
        Vector2f endpoint = cloneVec(position);
        endpoint.add(a);
        cxt.setColor(Color.black);
        cxt.drawLine((int)this.position.getX(), (int)this.position.getY(), (int)endpoint.getX(), (int)endpoint.getY());
    }

    public Vector2f getVel() {
        return scaleVec(aim, power);
    }

    public void update(long dt) {}

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Vector2f pos = subVec(position, V(Bubble.RADIUS/2.0f, Bubble.RADIUS/2.0f));
        EventBus.instance.emit("ShootEvent", new ShootEvent(pos, getVel()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Vector2f mousePoint = V(e.getX(), e.getY());
        mousePoint.sub(this.position);
        mousePoint.normalize();

        this.aim = mousePoint;
    }
}
