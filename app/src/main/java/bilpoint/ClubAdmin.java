package bilpoint;

public class ClubAdmin extends User {

    private String clubName;
    private String activationCode;

    public ClubAdmin(String name, String mail, String password, String clubName, String activationCode, String department) {
        super(clubName, mail, password, department);
        ID = "ADM-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.clubName = clubName;
    }

    public String getClubName() {
        return clubName;
    }
    public String getDepartment() {
        return department;
    }
    public String getActivationCode() {
        return activationCode;
    }

    public boolean createClubEvent(String title, String location, String date) {
        if (isLoggedIn == false)
            return false;

        Event newEvent = new PublicEvent(this, title, location, date, 13 ,13  ,13);
        SystemController.getInstance().addEvent(newEvent);
        return true;
    }

    public boolean removeClubEvent(Event event) {
        if (event == null) {
            return false;
        }
        if (!this.isLoggedIn) {
            return false;
        }
        if (event.getHost().getID().equals(this.ID)) {
            SystemController.getInstance().removeEvent(this, event);
            return true;
        } else {
            return false;
        }
    }

}