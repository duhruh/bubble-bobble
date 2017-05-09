package bubble.bobble;

import bubble.bobble.Event.*;
import bubble.bobble.Event.Event;
import bubble.bobble.Listeners.ShootEventListener;
import bubble.bobble.models.Bubble;
import bubble.bobble.models.Shooter;

import javax.swing.*;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import bubble.bobble.Event.EventBus;
import bubble.bobble.models.Wall;
import com.google.common.base.Ticker;

import static bubble.bobble.Util.MyVector.*;

public class Game {

    private static final Color[] colors = {Color.gray,Color.red,Color.yellow, Color.green, Color.blue};

    private GameWindow window;

    public Game(){
        // TODO: maybe should take in some config values?
    }

    public void start(){
        JFrame myFrame = new JFrame("Bubble Bobble");
        myFrame.setSize(1920,1080);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

        ArrayList<Color[]> config = new ArrayList<>();

        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});
        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});
        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});
        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});
        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});
        config.add(new Color[]{randomColor(),randomColor(),randomColor(),randomColor(), randomColor(), randomColor()});

        BubbleGraphFactory factory = new BubbleGraphFactory(config);

        ArrayList<Bubble> bubbles = factory.generateGraph();


        window = new GameWindow();

        window.addEntity(new Wall(V(0,0), V(10, 1920), Color.BLACK));
        window.addEntity(new Wall(V(1600,0), V(10, 1920), Color.BLACK));
        window.addEntity(new Wall(V(0,0), V(1600, 10), Color.BLACK));

        Shooter s = new Shooter(V(1920/2, 1040), V(0, 10), 300);

        window.addShooter(s);
        window.addBubbles(bubbles);

        window.setVisible(true);
        window.setSize(1920, 1080);

        myFrame.add(window);

        window.addMouseListener(s);
        window.addMouseMotionListener(s);

        registerEventBusListeners();

        long lastTime = System.nanoTime();
        long currTime;

        while(true) {
            currTime = System.nanoTime();

            window.update(currTime-lastTime);
            myFrame.repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // we good
            }

            lastTime = currTime;
        }
    }

    private void registerEventBusListeners() {
        EventBus bus = EventBus.instance;
        bus.addEventListener("ShootEvent", new EventListener() {
            @Override
            public void performEvent(Event event) {
                ShootEvent e = (ShootEvent) event;
                window.addEntity(new Bubble(e.getVel(), e.getPos(), Color.CYAN));
            }
        });
    }

    private Color  randomColor() {
        Random r = new Random();

        return colors[r.nextInt(colors.length)];
    }




}
