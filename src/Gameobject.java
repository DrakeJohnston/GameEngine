
public class Gameobject {

    private Vector2 pos;
    private String symbol;
    private String name;
    private int id = 0;
    boolean isActive = true;

    static int lastID = 0;

    public Gameobject(Vector2 pos, String symbol, String name){
        this.pos = pos;
        this.symbol = symbol;
        this.name = name;

        id = lastID+1;
        lastID = id;

        Engine.objects.add(this);
    }

    public int getID(){
        return id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
