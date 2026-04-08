package bilpoint;

public class Message {

    private String msgID;
    private String senderID;
    private String content;
    private long timestamp;

    public Message(String senderID, String content) {
        this.content = content;
        this.senderID = senderID;
        this.msgID = "MSG-" + java.util.UUID.randomUUID().toString().substring(0, 8);
        this.timestamp = System.currentTimeMillis();

    }
    public String getContent() {
        return content;
    }
    public String getMsgID() {
        return msgID;
    }
    public String getSenderID() {
        return senderID;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setContent(String content) {
        this.content = content;
    }

}