package bilpoint;

public class RockPaperScissors extends Minigame {
    
    private String opponentId;
    public RockPaperScissors(String gameId, String challengerId, String opponentId){
     super(gameId, challengerId, opponentId);
     this.opponentId = opponentId;
    }
}
