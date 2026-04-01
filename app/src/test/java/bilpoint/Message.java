package bilpoint;

public class Message {

    private String msgID;
    private String senderID;
    private String content;
    private long timestamp;

    public Message(String msgID, String senderID, String content, long timestamp) {
        this.content = content;
        this.senderID = senderID;
        this.msgID = msgID;
        this.timestamp = timestamp;

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

}