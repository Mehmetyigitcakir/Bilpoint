package bilpoint.ui;

public class MapPin {
    private int x, y;
    private String title;
    private boolean isPrivate;

    public MapPin(int x, int y, String title, boolean isPrivate) {
        this.x = x;
        this.y = y;
        this.title = title;
        this.isPrivate = isPrivate;
    }

    public boolean isClicked(int mouseX, int mouseY) {
        // Tıklanan alanın iğneye yakınlığını kontrol eder
        return Math.abs(x - mouseX) < 20 && Math.abs(y - mouseY) < 20;
    }

    // Getter metodları
    public int getX() { return x; }
    public int getY() { return y; }
    public String getTitle() { return title; }
    public boolean isPrivate() { return isPrivate; }
}