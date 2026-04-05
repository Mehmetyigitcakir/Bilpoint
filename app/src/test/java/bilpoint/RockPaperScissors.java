package bilpoint;

public class RockPaperScissors extends Minigame {

    private String opponentId;
    private int move1;
    private int move2;
    private String winner;
    private String[] RPS = new String[3];

    public RockPaperScissors(String challengerId, String opponentId, int move1, int move2) {
        super(challengerId);
        this.opponentId = opponentId;
        this.move1 = move1;
        this.move2 = move2;
        this.winner = "";
        RPS[0] = "Rock";
        RPS[1] = "Paper";
        RPS[2] = "Scissors";
    }

    @Override
    public void play() {
        setStatus("Playing");
        if (move1 == 0 && move2 == 2) {
            winner += challengerId;
        } else if (move2 == 0 && move1 == 2)
            winner += opponentId;
        else if (move1 > move2) {
            winner += challengerId;
        } else if (move2 > move2) {
            winner += opponentId;
        } else if (move1 == move2) {
            play();
        }

    }

    @Override
    public String getWinner() {
        setStatus("Finished");
        return winner;
    }

    public void evaluateWinner(){}
}
