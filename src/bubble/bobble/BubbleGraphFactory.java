package bubble.bobble;


import bubble.bobble.models.Bubble;

import javax.vecmath.Vector2f;
import java.awt.*;

import java.util.ArrayList;

/**
 * This class will generate bubble positions in a graph
 */
public class BubbleGraphFactory {


    private static int RADIUS = 25;

    private ArrayList<Color[]> levelConfig;


    public BubbleGraphFactory(ArrayList<Color[]> levelConfig){
        this.levelConfig = levelConfig;
    }


    public ArrayList<Bubble> generateGraph(){
        ArrayList<Bubble> bubbles = new ArrayList<>();

        int rowOffset = 0;
        int columnOffset = 0;

        int gameBoardOffset = 1920/2 - this.levelConfig.get(0).length * RADIUS;


        ArrayList<Bubble> prevRow = null;

        for (int i = 0; i < this.levelConfig.size(); i++) {
            Color[] row1 = this.levelConfig.get(i);
            rowOffset = (i%2) * (RADIUS);
            columnOffset = 5 * i;
            ArrayList<Bubble> currentRow = new ArrayList<>();

            //

            for(int j = 0; j < row1.length; j++){



                Vector2f position = new Vector2f(((RADIUS*j*2) + rowOffset) + gameBoardOffset,(RADIUS*i*2) - columnOffset);
                Vector2f velocity = new Vector2f(0,0);

                Bubble bubble = new Bubble(velocity, position, row1[j]);
                bubbles.add(bubble);

                if (prevRow != null) {

                    if (i % 2 == 1) {
                        bubble.addParent(prevRow.get(j));
                        prevRow.get(j).addChild(bubble);

                        if (prevRow.size() > j+1) {
                            bubble.addParent(prevRow.get(j+1));
                            prevRow.get(j+1).addChild(bubble);
                        }

                    } else {
                        bubble.addParent(prevRow.get(j));
                        prevRow.get(j).addChild(bubble);

                        if (0 <= j-1) {
                            bubble.addParent(prevRow.get(j-1));
                            prevRow.get(j-1).addChild(bubble);
                        }
                    }
                }

                currentRow.add(bubble);
            }

            prevRow = currentRow;

        }

        return bubbles;

    }

}
