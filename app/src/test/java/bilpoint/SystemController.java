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

    public void register(String name, String mail, String password, String department, int type) {
        User newUser;
        if (type == 0) {
            newUser = new Student(name, mail, password, password);
            users.add(newUser);
        } else if (type == 1) {
            newUser = new ClubAdmin(name, mail, password, name, "a");
            users.add(newUser);
        }
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
        User s1 = new Student("Yiğit", "yigit@bilkent.edu.tr", "123", "CS");
        User s2 = new Student("Nazim", "nazim@bilkent.edu.tr", "5423", "EE");
        User admin = new ClubAdmin("Furkan ", "music@bilkent.edu.tr", "456", "Music", "AUTH123");
        this.users.add(s1);
        this.users.add(s2);
        this.users.add(admin);
        this.events.add(new PublicEvent(admin, "Concert", "Center Campus", 60, "02.03.2026"));
    }

    public void removeEvent(User requester, Event event) {
        if (requester.isLoggedIn() &&
                requester instanceof ClubAdmin &&
                event.getHost().getID().equals(requester.getID())) {

            // KONTROL BAŞARILI: Etkinliği sistem listesinden siliyoruz
            if (events.contains(event)) {
                events.remove(event);
                System.out.println(
                        "[System] Event '" + event.getTitle() + "' successfully removed by " + requester.getName());
            }
        } else {
            // KONTROL BAŞARISIZ: Yetkisiz işlem uyarısı
            System.out.println(
                    "[Access Denied] User " + requester.getName() + " is not authorized to remove this event.");
        }
    }
}