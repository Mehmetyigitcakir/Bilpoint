package bilpoint;

public abstract class Minigame {

    protected String gameId;
    protected String challengerId;    
    protected String status; // Playing, Finished, Pending

    public Minigame(String challengerId){
        this.gameId = "GM-" + java.util.UUID.randomUUID().toString();
        this.challengerId = challengerId;
        this.status = "Pending";
    }

    public void play(){}
    public abstract String getWinner();
    public void setStatus(String s){
    status = s;
    }
    public String getStatus() {
        return status;
    }


}
