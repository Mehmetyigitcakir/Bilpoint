package bilpoint;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

    private String department;
    private List<Student> friends;

    public Student(String name, String ID, String mail, String password, String department) {
        super(name, ID, mail, password);
        this.department = department;
        friends = new ArrayList<Student>();
    }

    public void sendFriendRequest(Student s) {
        if (s == null|| s.equals(this))
            return;
        String message = this.getName() + " sent you a friend request.";
        s.getNotifications().add(new Notification(message));
    }

    public void acceptFriend(Student friend){
       if (!friends.contains(friend)) {
            this.friends.add(friend);
            friend.getFriends().add(this); 
        } 
    }
    public void joinEvent(Event event) {
        

    }

    public String getDepartment() {
        return department;
    }
    public List<Student> getFriends() {
        return friends;
    }
}