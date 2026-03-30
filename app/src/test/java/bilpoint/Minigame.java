package bilpoint;

<<<<<<< Updated upstream

public abstract class Minigame {
protected String challengerId;
protected String gameId;
public Minigame(String gameId, String challengerId){
 this.challengerId = challengerId;
 this.gameId = gameId;
}
    
public abstract void play();

public abstract String getWinner();

}





=======
public abstract class Minigame {

    private String gameId;
    private String challengerId;    
    private String status; // Playing, Finished, Pending

    public Minigame(String gameId, String challengerId){
        this.gameId = gameId;
        this.challengerId = challengerId;
        this.status = "PENDING";
    }

    public void play(){}
    public abstract String getWinner();

}
>>>>>>> Stashed changes
