package bilpoint;

public abstract class Minigame {

    protected String gameId;
    protected String challengerId;    
    protected String status; // Playing, Finished, Pending

    public Minigame(String gameId, String challengerId){
        this.gameId = gameId;
        this.challengerId = challengerId;
        this.status = "PENDING";
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
