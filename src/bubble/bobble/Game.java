package bubble.bobble;

import bubble.bobble.models.Bubble;
import bubble.bobble.models.Shooter;
import com.google.common.base.Ticker;
import com.google.common.eventbus.EventBus;

import javax.swing.*;
import javax.vecmath.Vector2f;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;


public class Game {

    private static final Color[] colors = {Color.gray,Color.red,Color.yellow, Color.green, Color.blue};
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

        GameWindow window = new GameWindow();

        Shooter s = new Shooter(new Vector2f(1920/2, 1040), new Vector2f(0, 10), 50);
//        window.addMouseListener(s);

        window.addShooter(s);
        window.addBubbles(bubbles);

        window.setVisible(true);
        window.setSize(1920, 1080);

        myFrame.add(window);

        window.addMouseListener(s);
        window.addMouseMotionListener(s);

        EventBus bus = new EventBus();


        while(true) {

            myFrame.repaint();

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // we good
            }
        }
    }



    private Color  randomColor() {
        Random r = new Random();

        return colors[r.nextInt(colors.length)];
    }




}
