package bilpoint;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChatSession {

    private String sessionID;
    private String eventID;
    private int expirationTime; // Hour
    private LocalDateTime creationTime;
    private List<Message> messages;
    private List<Minigame> games;

    public ChatSession(String eventID, int expirationTime) {
        this.sessionID = "SESS-" + java.util.UUID.randomUUID().toString();
        this.eventID = eventID;
        this.creationTime = LocalDateTime.now(); 
        this.expirationTime = expirationTime;
        this.messages = new ArrayList<>();
        this.games = new ArrayList<>();

    }

    public String playCoinFlip(User challanger, User opponent) {
          Minigame game = new CoinFlip(challanger.getID(), "Heads", "Tails");
          game.play(); 
          games.add(game);
          return game.getWinner();
    }
    public String playRPS(User challanger, User opponent, int move1, int move2){
        Minigame game = new RockPaperScissors(challanger.getID(), opponent.getID(), move1, move2);
        game.play();
        games.add(game);
        return game.getWinner(); 
    }

    public void clearHistory() {
        messages.clear();
        games.clear();
        this.creationTime = LocalDateTime.now();
    }

    public void addMessage(String text, User user) {
        messages.add(new Message( user.getID(), text));
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(creationTime.plusHours(expirationTime));
    }

    public List<Message> getMessages() {
        if (isExpired())
            clearHistory();

        return messages;
    }
    public String getSessionID() {
        return sessionID;
    }

}
