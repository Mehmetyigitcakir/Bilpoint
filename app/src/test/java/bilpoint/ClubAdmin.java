package bilpoint;

public class ClubAdmin extends User {

 private String clubName;
 private String activationCode;

  public ClubAdmin(String name, String mail, String password, String clubName, String activationCode){
    super(clubName, mail, password); 
    ID = "ADM-" + java.util.UUID.randomUUID().toString().substring(0, 8); 
    this.clubName = clubName;
  }
  public String getClubName() {
      return clubName;
  }
  public String getActivationCode() {
      return activationCode;
  }
   public boolean createClubEvent(String title, String location, String date){
    if (isLoggedIn == false)
        return false;

    Event newEvent = new PublicEvent(this, title, location, 1, date);
    SystemController.getInstance().addEvent(newEvent);
    return true;
   }
   public void removeClubEvent(Event event){
    if (event == null){
        
    }
   }
 
}