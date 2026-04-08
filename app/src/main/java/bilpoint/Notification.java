package bilpoint;

public class Notification {

    private String content;
    private String title;
    private boolean isRead;

    public Notification(String content) {
        this.content = content;
        isRead = false;
    }
    public String getContent() {
        return content;
    }
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
    public String getTitle() {
        return title;
    }
}