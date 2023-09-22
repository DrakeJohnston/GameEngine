
public class Gameobject {

    private Vector2 pos;
    private String symbol;
    boolean isActive = true;

    public Gameobject(Vector2 pos, String symbol){
        this.pos = pos;
        this.symbol = symbol;
        Engine.objects.add(this);
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Vector2 getPos() {
        return pos;
    }

    public void setPos(Vector2 pos) {
        this.pos = pos;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
