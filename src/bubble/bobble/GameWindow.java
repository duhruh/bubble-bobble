package bubble.bobble;

import bubble.bobble.models.Bubble;
import bubble.bobble.models.GameEntity;
import bubble.bobble.models.Shooter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameWindow extends JPanel {

    private ArrayList<GameEntity> entities = new ArrayList<>();

    public void addBubbles(ArrayList<Bubble> bubbles) {
        this.entities.addAll(bubbles);
    }

    public void addBubble(Bubble bubble) { this.entities.add(bubble); }

    public void addShooter(Shooter shooter) {
        this.addEntity(shooter);
    }

    public void addEntity(GameEntity entity) {
        this.entities.add(entity);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D) g;

        for(GameEntity entity: this.entities) {
            entity.draw(graphics2D);
        }
    }

    public void update(long dt) {
        for (GameEntity entity : entities) {
            entity.update(dt);
        }
    }
}
