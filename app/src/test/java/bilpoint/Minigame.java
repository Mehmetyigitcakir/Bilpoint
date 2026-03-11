package bilpoint;

public abstract class Minigame {
private String challengerId;
private String gameId;
public Minigame(String gameId, String challngerId){
 this.challengerId = challngerId;
 this.gameId = gameId;
}
    
public abstract void play();
public abstract void getWinner();
}