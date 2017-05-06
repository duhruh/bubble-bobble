package bubble.bobble.models;

import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

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
        Vector2f a = (Vector2f) this.aim.clone();
        a.scale(this.power);
        Vector2f endpoint = (Vector2f) this.position.clone();
        endpoint.add(a);
        cxt.setColor(Color.black);
        cxt.drawLine((int)this.position.getX(), (int)this.position.getY(), (int)endpoint.getX(), (int)endpoint.getY());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int i = 1+1;
    }

    @Override
    public void mousePressed(MouseEvent e) {

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
        Vector2f mousePoint = new Vector2f(e.getX(), e.getY());
        mousePoint.sub(this.position);
//        newPosition.sub(mousePoint);

        mousePoint.normalize();

        this.aim = mousePoint;
    }
}
