public class Tile {
    public String tileName;
    public int timesLanded;
    public Tile next;
    public Tile prev;

    public Tile(String tileName) { this.tileName = tileName; }

    public void landed() {
        timesLanded++;
    }
}
