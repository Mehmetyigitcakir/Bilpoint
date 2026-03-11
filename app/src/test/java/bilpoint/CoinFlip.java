package bilpoint;

import java.util.Random;

public class CoinFlip extends Minigame {
    Random random =new Random();
    
    private String optionOne;
    private String optionTwo;
    private boolean headsSelector;
    private boolean tailsSelector;

    public CoinFlip(String gameId, String challengerId, String optionOne, String optionTwo){
        super(gameId, challengerId);
        this.optionOne = optionOne;
        this.optionTwo = optionTwo;
        this.headsSelector = false;
        this.tailsSelector = false;
    }

    @Override
    public void play() {
        if(headsSelector == true && tailsSelector == false){

        }
        else if(tailsSelector == true && headsSelector == false){

        }
        else{

        }
    }

    @Override
    public String getWinner() {
        if(headsSelector == true && tailsSelector == false){

        }
        else if(tailsSelector == true && headsSelector == false){

        }
        else{

        }
        return null;
    }

    public void flip(){
        boolean selector = random.nextBoolean();
        if (selector){
            headsSelector = true;
            tailsSelector = false;
        }
        else {
            tailsSelector = true;
            headsSelector = false;
        }
    }
}
