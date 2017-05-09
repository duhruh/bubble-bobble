package bubble.bobble.Event;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by daniel on 5/6/2017.
 */
public class EventBus {
    public static EventBus instance = new EventBus();

    private HashMap<String, ArrayList<EventListener>> listeners = new HashMap<>();

    public void addEventListener(String eventName, EventListener listener) {
        if (!listeners.containsKey(eventName)) {
            listeners.put(eventName, new ArrayList<>());
        }
        listeners.get(eventName).add(listener);
    }

    public void emit(String eventName, Event event) {
        if (!listeners.containsKey(eventName)) {
            return;
        }
        for (EventListener listener : listeners.get(eventName)) {
            listener.performEvent(event);
        }
    }
}
