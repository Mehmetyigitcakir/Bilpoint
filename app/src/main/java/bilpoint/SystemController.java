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
        initSystem();
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

    public boolean register(String name, String mail, String password, String department, int type) {
        User newUser;
        if (type == 0) {
            newUser = new Student(name, mail, password, password);
            users.add(newUser);
            return true;
        } else if (type == 1) {
            newUser = new ClubAdmin(name, mail, password, name, "a", department);
            users.add(newUser);
            return true;
        }
        return false;
    }

    public User loginUser(String mail, String password) {
        for (User u : users) {
            if (u.login(mail, password)) {
                return u;
            }
        }
        return null;
    }

    public void initSystem() {
        User s1 = new Student("Mehmet Yiğit Çakır", "yigit@ug.bilkent.edu.tr", "123", "CS");
        User s2 = new Student("Nazim", "nazim@bilkent.edu.tr", "5423", "EE");
        User admin = new ClubAdmin("Furkan ", "music@ug.bilkent.edu.tr", "456", "Music", "AUTH123", "LAW");
        this.users.add(s1);
        this.users.add(s2);
        this.users.add(admin);
        this.events.add(new PublicEvent(admin, "Concert", "Center Campus", "02.03.2026", 15, 20, 60));
    }

    public boolean removeEvent(User requester, Event event) {
        if (requester.isLoggedIn() &&
                requester instanceof ClubAdmin &&
                event.getHost().getID().equals(requester.getID())) {

            if (events.contains(event)) {
                events.remove(event);
                return true;
            }
            return false;
          } else {     
            return false;
        }
    }
}