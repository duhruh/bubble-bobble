package bubble.bobble.Listeners;

import bubble.bobble.Event.Event;
import bubble.bobble.Event.EventListener;
import bubble.bobble.Event.ShootEvent;

/**
 * Created by daniel on 5/6/2017.
 */
public class ShootEventListener extends EventListener {
    public void performEvent(Event evt) {
        if (!(evt instanceof ShootEvent)) return;


    }
}
