package bilpoint;

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