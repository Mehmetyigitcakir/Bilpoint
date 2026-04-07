package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class SystemController {

    private static SystemController instance;
    private List<User> users;
    private List<Event> events;
    private List<ChatSession> activeChats;

    private SystemController() {
        this.users = new ArrayList<>();
        this.events = new ArrayList<>();
        this.activeChats = new ArrayList<>();
    }

    public static SystemController getInstance() {
        if (instance == null) {
            instance = new SystemController();
        }
        return instance;
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}