public class Spot {

	private String name;
	private int landedCount;

	public Spot(String name) {
		this.name = name;
		landedCount = 0;
	}

	public String getName() {
		return name;
	}

	public int getLandedCount() {
		return landedCount;
	}

	public void landed() {
		landedCount++;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
