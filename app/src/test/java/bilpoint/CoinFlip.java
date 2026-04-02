package bilpoint;

import java.util.Random;

public class CoinFlip extends Minigame {
    private final Random random = new Random();
    
    private String optionOne;
    private String optionTwo;
    private boolean headsSelector;
    

    public CoinFlip( String challengerId, String optionOne, String optionTwo){
        super(challengerId);
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
    }

    @Override
    public void play() {
        flip();
    }

    @Override
    public String getWinner() {
        if(headsSelector){
            return optionOne;
        }
        else{
            return optionTwo;
        }
    }

    public void flip(){
        this.headsSelector = random.nextBoolean();
    }
    
}
