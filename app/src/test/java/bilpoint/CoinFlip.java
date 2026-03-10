package bilpoint;

public class CoinFlip extends Minigame {
    
    private String optionOne;
    private String optionTwo;

    public CoinFlip(String gameId, String challengerId, String optionOne, String optionTwo){
        super(gameId, challengerId);
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
    }
}
