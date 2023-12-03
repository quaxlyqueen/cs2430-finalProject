public class Tile {
    public String tilename;
    public int timesLanded;
    public Tile next;
    public Tile prev;

    public Tile(String tilename) { this.tilename = tilename; }

    public void landed() {
        timesLanded++;
    }
}
